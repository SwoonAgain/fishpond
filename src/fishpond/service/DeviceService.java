package fishpond.service;

import java.util.List;

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
	List<ReadableDevice> viewAllDevice(String orderBy,int begin,int count,String ...strings);
	
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
	List<ReadableDevice> viewOnlineDevice(String orderBy,int begin,int count,String ...strings);

	int onlineDeviceAmount();

	int allDeviceAmount();

	/**
	 * 
	 * @param filter
	 * @return
	 */
	int deviceAmount(String filter);

	int onlineDeviceAmount(String filter);

	List<DeviceStatus> getStatus(List<ReadableDevice> onlinedevices);

	List<DeviceStatus> refreshStatus(String[] ids);
}
