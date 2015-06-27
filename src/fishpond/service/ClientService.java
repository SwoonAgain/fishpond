package fishpond.service;

import static fishpond.app.Application.MANDATORS;
import static fishpond.app.Application.UNKNOWN_DEVICES;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import fishpond.app.CommandWriter;
import fishpond.dao.impl.DeviceDaoImpl;
import fishpond.entity.Device;
import fishpond.server.Client;
import fishpond.server.Client.Status;
import fishpond.utils.BytesUtil;
import fishpond.utils.ConvertUtil;

public class ClientService implements CommandWriter{
	/*---------发送指令---------*/
	public static final byte[] SYNC = {0x5a};
	public static final byte[] END = {0x77};
	/** 确认*/
	public static final byte[] CONFIRM = {0x03};
	/** 获取编辑参数*/
	public static final byte[] GET_EDIT = {0x04};
	/** 获取实时数据及系统状态*/
	public static final byte[] GET_REAL_TIME = {0x06};
	/** 在数据库中*/
	public static final byte[] IN_DATABASE = {0x00};
	/** 不在数据库中*/
	public static final byte[] NOT_IN_DATABASE = {0x01};
	/** 保留位*/
	public static final byte[] KEEP = {0x00,0X00};
	/** 校验值*/
	public static final byte[] CHECK = {(byte) 0xff,(byte) 0xff};
	
	/*-------TAG--------*/
	/** sync */
	public static final byte SYNC_TAG = 0x5a;
	/** end */
	public static final byte END_TAG = 0x77;
	/** 注册 */
	public static final byte REGISTER_TAG = 0x01;
	/** 心跳 */
	public static final byte HEARTBEAT_TAG = 0x02;
	/** 编辑参数*/
	public static final byte EDIT_TAG = 0x05;
	/**实时数据及系统状态*/
	public static final byte REAL_TIME_TAG = 0x07;

	private DeviceDaoImpl deviceDaoImpl;

	/**持有的设备，每一个线程对应一个client,service同时也持有一个device*/
	private Device mDevice;
	private Client mClient;
	private ApplicationContext appCtx; 

	/**注册状态，服务器掉线重新收到心跳包而没收到注册包，注册状态将为false*/
	private boolean registerStatus = false;

	/**心跳状态*/
	private boolean beat = false;
	
	/**同步方法是否进入进程中,必须由client线程来更新它*/
	private boolean isProgress = false;
	
	public ClientService(Client client) {
		mClient = client;
		deviceDaoImpl = new DeviceDaoImpl();
		appCtx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = appCtx.getBean(JdbcTemplate.class);
		deviceDaoImpl.setJdbcTemplate(jdbcTemplate);
	}

	/**
	 * 
	 * @param data 从DTU设备读取的信息
	 * @return 返回给DTU设备的数据
	 */
	public void handleData(byte[] data){
		byte tag = data[1];
		switch(tag){
		case REGISTER_TAG :
			handleRegister(data);
			break;
		case HEARTBEAT_TAG :
			handleHeartbeat(data);
			break;
		case EDIT_TAG :
			handleEdit(data);
			break;
		case REAL_TIME_TAG :
			handleRealTime(data);
			break;
		default :
			break;
		}
	}

	/**
	 * 处理实时数据及DTU系统状态
	 * @param data
	 */
	protected void handleRealTime(byte[] data) { //TODO 处理实时数据
		if (data[2]== 0x00 && data.length == 6) {  //获取失败
			
		}
	}
	
	/**
	 * 处理编辑参数
	 * @param data
	 */
	protected void handleEdit(byte[] data) { //TODO 处理编辑参数
		
	}
	
	/**
	 * 处理收到注册包：
	 * <br/>1、从数据库中查找注册包中包含的设备信息.
	 * <br/>2、查询数据库中是否有该设备，初始化本对象持有的设备{@link #mDevice}.
	 * <br/>3、此服务上线，更新registerStatus.
	 * <br/>4、写反馈命令.
	 * @param data DTU编码,公司名，渔场名，鱼塘编号，平台ID
	 */
	protected void handleRegister(byte[] data){
		byte[] dtuCodeBytes = new byte[3];
		byte[] companyCodeBytes = new byte[2];
		byte[] fishPondCodeBytes = new byte[2];
		byte[] fishPondNoBytes = new byte[2];
		byte[] platformIdBytes = new byte[1];
		
		BytesUtil.arrayscopy(data, 2, dtuCodeBytes,companyCodeBytes,fishPondCodeBytes,platformIdBytes);
		
		String dtuCodeHexStr = ConvertUtil.bytesToHex(dtuCodeBytes);
		String companyCodeHexStr = ConvertUtil.bytesToHex(companyCodeBytes);
		String fishPondCodeHexStr = ConvertUtil.bytesToHex(fishPondCodeBytes);
		String fishPondNoHexStr = ConvertUtil.bytesToHex(fishPondNoBytes);
		String platformIdHexStr = ConvertUtil.bytesToHex(platformIdBytes);

		Device device = new Device(dtuCodeHexStr,companyCodeHexStr, fishPondCodeHexStr, fishPondNoHexStr, platformIdHexStr);
		//从数据库中查询
		Device deviceFromDatabase = findByDtuCode(device.getDtuCode());
		if (deviceFromDatabase != null) {
			//持有设备
			mDevice = deviceFromDatabase;
			//更新状态
			updateStatus(Status.ONLINE);
		}else {
			mDevice = device;
			mDevice.set_id(-1);
			UNKNOWN_DEVICES.put(mDevice, this);
		}
		registerStatus = true;
		//写反馈命令
		byte[] confirmCommand = BytesUtil.composeCommand(SYNC,CONFIRM
															,dtuCodeBytes,companyCodeBytes,fishPondCodeBytes,fishPondNoBytes
															,KEEP,CHECK,END);
		write(confirmCommand);//设备确认
		byte[] getEditCommand = BytesUtil.composeCommand(SYNC,GET_EDIT,NOT_IN_DATABASE
															,CHECK,END);
		write(getEditCommand);//获取编辑参数
	}
	
	
	/**
	 * 获取DTU设备上的编辑参数，
	 * @param command
	 * @param timeout
	 * @return
	 */
	public boolean getEditParameterFromDevice(byte[] command, long timeout) {
		return false;
	}
	
	/**
	 * 默认超时5秒
	 * @param command
	 * @return {@link #getEditParameterFromDevice(byte[], long)}
	 */
	public boolean getEditParameterFromDevice(byte[] command) {
		return getEditParameterFromDevice(command,5000);
	}
	
	/**
	 * 处理收到心跳包：
	 * <br/>1、检查注册状态
	 * <br/>2、写反馈命令.
	 * @param data  DTU编码
	 */
	protected void handleHeartbeat(byte[] data){
		if (! beat) { //如果没有进入心跳状态
			//检查注册状态
			if (registerStatus) { //注册OK，那么进入心跳
				beat = true;
			}else { //没有检测到注册状态，可能是服务器重启而设备没掉线，没发注册包过来而心跳包继续
				byte[] dtuCodeBytes = new byte[3];
				
				BytesUtil.arrayscopy(data, 2, dtuCodeBytes);
				
				String dtuCodeHexStr = ConvertUtil.bytesToHex(dtuCodeBytes);
				Device deviceFromDatabase = findByDtuCode(dtuCodeHexStr);
				if (deviceFromDatabase != null) { //数据库中存在，则设备已经注册进来，重新注册设备
					reRegister(deviceFromDatabase);
				}else {
					mDevice = new Device(dtuCodeHexStr, "unknown", "unknown", "unknown", "unknown");
					UNKNOWN_DEVICES.put(mDevice, this);
				}
			}
		}
		beat = true;
		write(data);
	}
	
	/**
	 * 根据已有设备重新注册设备
	 * @param device
	 */
	public void reRegister(Device device) {
		registerStatus = true;
		mDevice = device;
		updateStatus(Status.ONLINE);
	}

	
	
	private Device findByDtuCode(String dtuCode) {
		return deviceDaoImpl.findByDtuCode(dtuCode);
	}

	/**
	 * ONLINE 相关：
	 * <br/>{@link #mDevice}.setOnlineStatus(true);
	 * <br/>对应更新数据库中的column : online_status
	 * <br/>应用全局变量{@link #MANDATORS}添加{@link #mDevice},{@link #mCommandWriter}
	 * <br/>OFFLINE相关：
	 * <br/>与ONLINE 相关相反
	 * 
	 * @param status
	 */
	public void updateStatus(Client.Status status) {
		switch (status) {
		case ONLINE:
			mDevice.setOnlineStatus(true);
			deviceDaoImpl.update("update device set online_status = true where _id = "+mDevice.get_id());
			MANDATORS.put(mDevice, this);
			break;
		case OFFLINE:
			mDevice.setOnlineStatus(false);
			deviceDaoImpl.update("update device set online_status = false where _id = "+mDevice.get_id());
			MANDATORS.remove(mDevice);
			UNKNOWN_DEVICES.remove(mDevice);
			break;
		default:
			break;
		}
	}

	/**
	 * 同步方法,防止多个线程同时写指令
	 */
	@Override
	public synchronized boolean write(byte[] command) {
		return mClient.write(command);
	}
}
