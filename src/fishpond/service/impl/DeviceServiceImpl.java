package fishpond.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fishpond.dao.DeviceDao;
import fishpond.dao.ReadableDeviceDao;
import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Service("deviceServiceImpl")
public class DeviceServiceImpl implements DeviceService {

	@Resource(name = "readableDeviceDaoImpl")
	private ReadableDeviceDao readableDeviceDao;

	@Resource(name = "deviceDaoImpl")
	private DeviceDao deviceDao;

	@Override
	public List<ReadableDevice> viewAllDevice(String orderBy,int begin,int count) {
		return readableDeviceDao.find(orderBy,begin,count,"");
	}
	@Override
	public List<ReadableDevice> viewAllDevice(String orderBy, int begin,
			int count, String... strings) {
		return readableDeviceDao.find(orderBy,begin,count,strings);
	}

	@Override
	public List<ReadableDevice> viewOnlineDevice(String orderBy,int begin,int count) {
		return readableDeviceDao.find(orderBy,begin,count,"online_status-true");
	}

	@Override
	public List<ReadableDevice> viewOnlineDevice(String orderBy, int begin,
			int count, String... strings) {
		String[] strs = new String[strings.length+1];
		strs[0] = "online_status-true";
		System.arraycopy(strings, 0, strs, 1, strings.length);
		return readableDeviceDao.find(orderBy,begin,count,strs);
	}

	@Override
	public int onlineDeviceAmount() {
		return readableDeviceDao.getDeviceAmount("online_status-true");
	}

	@Override
	public int allDeviceAmount() {
		return readableDeviceDao.getDeviceAmount("");
	}
	@Override
	public int deviceAmount(String filter) {
		return readableDeviceDao.getDeviceAmount(filter);
	}
	@Override
	public int onlineDeviceAmount(String filter) {
		return readableDeviceDao.getDeviceAmount("online_status-true",filter);
	}
}
