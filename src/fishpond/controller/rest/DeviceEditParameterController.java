package fishpond.controller.rest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fishpond.entity.DeviceEditParameter;
import fishpond.service.DeviceEditParameterService;

@Controller("deviceEditParameterController")
@RequestMapping
public class DeviceEditParameterController {
	
	@Resource(name = "deviceEditParameterServiceImpl")
	private DeviceEditParameterService deviceEditParameterService;

	@RequestMapping(value = "/device-edit-parameters/{_id}",method = RequestMethod.GET)
	@ResponseBody
	public DeviceEditParameter getDeviceEditParameter(@PathVariable Integer _id) {
		DeviceEditParameter dep = deviceEditParameterService.findById(_id);
		return dep;
	}
}
