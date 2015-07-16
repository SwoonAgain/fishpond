package fishpond.service;

import fishpond.entity.DeviceEditParameter;
import fishpond.entity.DeviceStatus;

public interface DeviceEditParameterService {

	DeviceEditParameter findById(Integer _id);

	/**
	 * 获取一个CommandWriter，遍历每一个filed，如果不同，则读写。
	 * @param editParameter
	 * @return
	 */
	boolean saveParameters(DeviceEditParameter editParameter);

	DeviceStatus getDeviceStatus(Integer _id);
}
