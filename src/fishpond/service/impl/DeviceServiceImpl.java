package fishpond.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fishpond.dao.DeviceDao;
import fishpond.dao.DeviceStatusDao;
import fishpond.dao.ReadableDeviceDao;
import fishpond.entity.DeviceStatus;
import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Service("deviceServiceImpl")
public class DeviceServiceImpl implements DeviceService {

	@Resource(name = "readableDeviceDaoImpl")
	private ReadableDeviceDao readableDeviceDao;

	@Resource(name = "deviceDaoImpl")
	private DeviceDao deviceDao;
	
	@Resource(name = "deviceStatusDaoImpl")
	private DeviceStatusDao deviceStatusDao;

	@Override
	public List<ReadableDevice> viewAllDevice(String orderBy,int begin,int count) {
		return readableDeviceDao.find(orderBy,begin,count,null);
	}
	@Override
	public List<ReadableDevice> viewAllDevice(String orderBy, int begin,
			int count, Map<String,String> filters) {
		return readableDeviceDao.find(orderBy,begin,count,filters);
	}

	@Override
	public List<ReadableDevice> viewOnlineDevice(String orderBy,int begin,int count) {
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("online_status", "true");
		return readableDeviceDao.find(orderBy,begin,count,map);
	}

	@Override
	public List<ReadableDevice> viewOnlineDevice(String orderBy, int begin,
			int count,Map<String,String> filters) {
		filters.put("online_status", "true");
		return readableDeviceDao.find(orderBy,begin,count,filters);
	}

	@Override
	public int onlineDeviceAmount() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("online_status", "true");
		return readableDeviceDao.getDeviceAmount(map);
	}

	@Override
	public int allDeviceAmount() {
		return readableDeviceDao.getDeviceAmount(null);
	}
	@Override
	public int deviceAmount(Map<String,String> filters) {
		return readableDeviceDao.getDeviceAmount(filters);
	}
	@Override
	public int onlineDeviceAmount(Map<String,String> filters) {
		filters.put("online_status", "true");
		return readableDeviceDao.getDeviceAmount(filters);
	}
	@Override
	public List<DeviceStatus> getStatus(List<ReadableDevice> onlinedevices) {
		List<DeviceStatus> list = new ArrayList<DeviceStatus>();
		for (ReadableDevice readableDevice : onlinedevices) {
			DeviceStatus status = deviceStatusDao.findByDeviceId(readableDevice.get_id());
			list.add(status);
		}
		return list;
	}
	@Override
	public List<DeviceStatus> refreshStatus(String[] ids) {
		List<DeviceStatus> list = new ArrayList<DeviceStatus>();
		for (String id : ids) {
			DeviceStatus status = deviceStatusDao.findByDeviceId(Integer.valueOf(id));
			list.add(status);
		}
		return list;
	}
}
