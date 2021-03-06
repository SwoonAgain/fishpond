package fishpond.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fishpond.entity.DeviceEditParameter;
import fishpond.entity.DeviceStatus;
import fishpond.service.DeviceEditParameterService;

@Controller("deviceEditParameterController")
public class DeviceDetailController {
	
	@Resource(name = "deviceEditParameterServiceImpl")
	private DeviceEditParameterService deviceEditParameterService;

	@RequestMapping(value = "/status-detail/{_id}",method = RequestMethod.GET)
	public String getDeviceStatus(@PathVariable Integer _id,ModelMap model) {
		DeviceStatus status = deviceEditParameterService.getDeviceStatus(_id);
		model.addAttribute("status", status);
		return "modal/status-detail-modal";
	}
	
	@RequestMapping(value = "/setting-detail/{_id}",method = RequestMethod.GET)
	public String getDeviceEditParameter(@PathVariable Integer _id,ModelMap model) {
		DeviceEditParameter dep = deviceEditParameterService.findById(_id);
		model.addAttribute("editParameter", dep);
		return "modal/setting-detail-modal";
	}
	
	@RequestMapping(value = "/set-parameters",method = RequestMethod.POST)
	@ResponseBody
	public boolean setDeviceEditParameter(DeviceEditParameter editParameter) {
		boolean isSeccess = deviceEditParameterService.saveParameters(editParameter);
		return isSeccess;
	}
}
