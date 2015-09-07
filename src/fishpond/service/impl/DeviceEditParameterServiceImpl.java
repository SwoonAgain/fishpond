package fishpond.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fishpond.app.Application;
import fishpond.app.CommandWriter;
import fishpond.app.DeviceHelper;
import fishpond.app.DeviceHelper.DeviceReadException;
import fishpond.dao.DeviceEditParameterDao;
import fishpond.entity.DeviceEditParameter;
import fishpond.entity.DeviceStatus;
import fishpond.service.DeviceEditParameterService;

@Service("deviceEditParameterServiceImpl")
public class DeviceEditParameterServiceImpl implements
		DeviceEditParameterService {
	
	@Resource(name="deviceEditParameterDaoImpl")
	private DeviceEditParameterDao deviceEditParameterDao;

	@Override
	public DeviceEditParameter findById(Integer _id) {
		return deviceEditParameterDao.findByDeviceId(_id);
	}

	@Override
	public boolean saveParameters(DeviceEditParameter editParameter) {
		CommandWriter commandWriter = Application.getCommandWriterByDeviceId(editParameter.getDeviceId());
		DeviceEditParameter fromDtabase = deviceEditParameterDao.findByDeviceId(editParameter.getDeviceId());
		boolean isSuccess = DeviceHelper.writeToDevice(commandWriter,editParameter,fromDtabase);
		if (isSuccess) {
			deviceEditParameterDao.update(editParameter);
		}
		return isSuccess;
	}

	@Override
	public DeviceStatus getDeviceStatus(Integer _id) {
		CommandWriter commandWriter = Application.getCommandWriterByDeviceId(_id);
		try {
			return DeviceHelper.requestDeviceStatus(_id,commandWriter);
		} catch (DeviceReadException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
}
