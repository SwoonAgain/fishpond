package fishpond.server;

import static fishpond.app.Application.MANDATORS;
import static fishpond.app.Application.UNKNOWN_DEVICES;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import fishpond.app.CommandMappingHelper;
import fishpond.app.CommandMappingHelper.CommandType;
import fishpond.app.CommandWriter;
import fishpond.dao.impl.DeviceDaoImpl;
import fishpond.entity.Command;
import fishpond.entity.Device;
import fishpond.server.Client.Status;
import fishpond.utils.BytesUtil;
import fishpond.utils.ConvertUtil;
import fishpond.utils.SpringApplicationContextProvider;

public class ClientService implements CommandWriter{

	/*-------TAG--------*/
	/** sync */
	public static final byte SYNC_TAG = 0x5a;
	/** end */
	public static final byte END_TAG = 0x77;
	/** 注册 */
	public static final byte REGISTER_TAG = 0x01;
	/** 心跳 */
	public static final byte HEARTBEAT_TAG = 0x02;

	public static final byte[] HEARTBEATorREGISTER = new byte[]{0x5a};
	
	private DeviceDaoImpl deviceDaoImpl;

	/**持有的设备，每一个线程对应一个client,service同时也持有一个device*/
	private Device mDevice;
	private Client mClient;

	/**注册状态，服务器掉线重新收到心跳包而没收到注册包，注册状态将为false*/
	private boolean registerStatus = false;

	/**心跳状态*/
	private boolean beat = false;

	private byte[] expect;
	private int expectLength;

	private byte[] response;

	public ClientService(Client client) {
		mClient = client;
		deviceDaoImpl = new DeviceDaoImpl();
		JdbcTemplate jdbcTemplate = SpringApplicationContextProvider.getApplicationContext().getBean(JdbcTemplate.class);
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
		default :
			break;
		}
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

		BytesUtil.arrayscopy(data, 2, dtuCodeBytes,companyCodeBytes,fishPondCodeBytes,fishPondNoBytes,platformIdBytes);

		String dtuCodeHexStr = ConvertUtil.bytesToHexString(dtuCodeBytes);
		String companyCodeHexStr = ConvertUtil.bytesToHexString(companyCodeBytes);
		String fishPondCodeHexStr = ConvertUtil.bytesToHexString(fishPondCodeBytes);
		String fishPondNoHexStr = ConvertUtil.bytesToHexString(fishPondNoBytes);
		String platformIdHexStr = ConvertUtil.bytesToHexString(platformIdBytes);

		Device device = new Device(dtuCodeHexStr,companyCodeHexStr, fishPondCodeHexStr, fishPondNoHexStr, platformIdHexStr);
		//从数据库中查询
		System.out.println("DTU_CODE:\t"+device.getDtuCode());
		Device deviceFromDatabase = findByDtuCode(device.getDtuCode());
		if (deviceFromDatabase != null) {
			//持有设备
			mDevice = deviceFromDatabase;
			//更新状态
			updateStatus(Status.ONLINE);
			Thread.currentThread().setName("DTU:"+mDevice.getDtuCode());
		}else {
			mDevice = device;
			mDevice.set_id(-1);
			UNKNOWN_DEVICES.put(mDevice.get_id(), this);
		}
		registerStatus = true;
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

				String dtuCodeHexStr = ConvertUtil.bytesToHexString(dtuCodeBytes);
				Device deviceFromDatabase = findByDtuCode(dtuCodeHexStr);
				if (deviceFromDatabase != null) { //数据库中存在，则设备已经注册进来，重新注册设备
					reRegister(deviceFromDatabase);
				}else {
					mDevice = new Device(dtuCodeHexStr, "unknown", "unknown", "unknown", "unknown");
					UNKNOWN_DEVICES.put(mDevice.get_id(), this);
				}
			}
		}
		beat = true;
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
		if (mDevice != null) {
			switch (status) {
			case ONLINE:
				mDevice.setOnlineStatus(true);
				deviceDaoImpl.update("update device set online_status = true where _id = "+mDevice.get_id());
				MANDATORS.put(mDevice.get_id(), this);
				break;
			case OFFLINE:
				mDevice.setOnlineStatus(false);
				deviceDaoImpl.update("update device set online_status = false where _id = "+mDevice.get_id());
				MANDATORS.remove(mDevice.get_id());
				UNKNOWN_DEVICES.remove(mDevice.get_id());
				break;
			default:
				break;
			}
		}
	}

	/**
	 * 同步方法,防止多个线程同时写指令
	 */
	@Override
	public synchronized boolean write(byte[] command) {
		return mClient.write(command);
	}

	@Override
	public synchronized byte[] writeExpectResponse(byte[] command, Command commandEntity,
			CommandType type) {
		String expt = CommandMappingHelper.expect(commandEntity, type);
		int exptLen = CommandMappingHelper.expectLength(commandEntity, type);
		updateExpect(ConvertUtil.hexStringToByteArray(expt),exptLen);
		response = null;
		boolean isWriten = mClient.write(command);
		long begin = System.currentTimeMillis();
		while (isWriten && (System.currentTimeMillis() - begin) < 5000) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (response != null) {
				updateExpect(HEARTBEATorREGISTER, 0);
				return response;
			}
		}
		updateExpect(HEARTBEATorREGISTER, 0);
		return null;
	}

	public synchronized void updateExpect(byte[] expect,int expectLength){
		this.expect = expect;
		this.expectLength = expectLength;
	}

	public byte[] getExpect() {
		if (expect == null) {
			return HEARTBEATorREGISTER;
		}
		return expect;
	}

	public int getExpectLength(){
		return expectLength;
	}

	public void setResponse(byte[] response) {
		this.response = response;
	}
}
