package fishpond.dao;

import java.util.List;

import fishpond.entity.ReadableDevice;

public interface ReadableDeviceDao {
	
	List<ReadableDevice> find(String orderBy,int begin,int count,String ...strings);

	int getDeviceAmount(String... filters);
	
}
