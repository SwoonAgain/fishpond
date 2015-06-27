package fishpond.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fishpond.dao.ReadableDeviceDao;
import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Service("deviceServiceImpl")
public class DeviceServiceImpl implements DeviceService {
	
	@Resource(name = "readableDeviceDaoImpl")
	private ReadableDeviceDao readableDeviceDao;
	
	@Override
	public List<ReadableDevice> viewAllDevice() {
		return readableDeviceDao.findAll();
	}

	@Override
	public List<ReadableDevice> viewOnlineDevice() {
		return readableDeviceDao.findOnline();
	}

}
