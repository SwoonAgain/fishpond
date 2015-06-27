package fishpond.service;

import java.util.List;

import fishpond.entity.ReadableDevice;

public interface DeviceService {
	
	List<ReadableDevice> viewAllDevice();
	
	List<ReadableDevice> viewOnlineDevice();
}
