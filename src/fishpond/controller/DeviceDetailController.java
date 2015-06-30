package fishpond.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fishpond.entity.DeviceEditParameter;
import fishpond.service.DeviceEditParameterService;

@Controller("deviceEditParameterController")
public class DeviceDetailController {
	
	@Resource(name = "deviceEditParameterServiceImpl")
	private DeviceEditParameterService deviceEditParameterService;

	@RequestMapping(value = "/device-detail/{_id}",method = RequestMethod.GET)
	public String getDeviceEditParameter(@PathVariable Integer _id,ModelMap model) {
		DeviceEditParameter dep = deviceEditParameterService.findById(_id);
		model.addAttribute("editParameter", dep);
		return "modal/device-detail-modal";
	}
}
