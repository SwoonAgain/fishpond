package fishpond.dao;

import fishpond.entity.DeviceEditParameter;

public interface DeviceEditParameterDao {

	DeviceEditParameter findByDeviceId(int deviceId);
	
}
