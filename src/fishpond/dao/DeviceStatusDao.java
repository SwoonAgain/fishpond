package fishpond.dao;

import fishpond.entity.DeviceStatus;

public interface DeviceStatusDao {

	DeviceStatus findByDeviceId(int deviceId);

	void updateWeight(int deviceId, int weight);
	
}
