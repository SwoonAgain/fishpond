package fishpond.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fishpond.dao.DeviceEditParameterDao;
import fishpond.entity.DeviceEditParameter;
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
	
	
}
