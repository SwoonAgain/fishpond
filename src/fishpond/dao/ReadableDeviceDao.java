package fishpond.dao;

import java.util.List;
import java.util.Map;

import fishpond.entity.ReadableDevice;

public interface ReadableDeviceDao {
	
	List<ReadableDevice> find(String orderBy,int begin,int count,Map<String,String> filters);

	int getDeviceAmount(Map<String, String> filters);
	
}
