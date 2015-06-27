package fishpond.dao;

import java.util.List;

import fishpond.entity.ReadableDevice;

public interface ReadableDeviceDao {
	
	List<ReadableDevice> findAll();

	List<ReadableDevice> findOnline();
}
