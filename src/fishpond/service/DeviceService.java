package fishpond.service;

import java.util.List;
import java.util.Map;

import fishpond.entity.DeviceStatus;
import fishpond.entity.ReadableDevice;

public interface DeviceService {
	
	/**
	 * @param orderBy
	 * @param begin
	 * @param count
	 * @return
	 */
	List<ReadableDevice> viewAllDevice(String orderBy,int begin,int count);
	
	/**
	 * @param orderBy
	 * @param begin
	 * @param count
	 * @param strings
	 * @return
	 */
	List<ReadableDevice> viewAllDevice(String orderBy,int begin,int count,Map<String,String> filters);
	
	/**
	 * @param orderBy
	 * @param begin
	 * @param count
	 * @return
	 */
	List<ReadableDevice> viewOnlineDevice(String orderBy,int begin,int count);
	
	/**
	 * @param orderBy
	 * @param begin
	 * @param count
	 * @param strings
	 * @return
	 */
	List<ReadableDevice> viewOnlineDevice(String orderBy,int begin,int count,Map<String,String> filters);

	int onlineDeviceAmount();

	int allDeviceAmount();

	List<DeviceStatus> getStatus(List<ReadableDevice> onlinedevices);

	List<DeviceStatus> refreshStatus(String[] ids);

	int deviceAmount(Map<String, String> filters);

	int onlineDeviceAmount(Map<String, String> filters);
}
