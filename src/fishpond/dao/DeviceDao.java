package fishpond.dao;

import java.util.List;

import fishpond.entity.Device;

public interface DeviceDao {
	
	void add(Device device);
	
	List<Device> findAll();

	void update(String sql);

	Device findByDtuCode(String dtuCode);
}
