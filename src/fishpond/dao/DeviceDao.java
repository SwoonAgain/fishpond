package fishpond.dao;

import fishpond.entity.Device;

public interface DeviceDao {
	
	void add(Device device);
	
	void update(String sql);

	Device findByDtuCode(String dtuCode);
}
