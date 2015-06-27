package fishpond.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Controller("deviceController")
public class DeviceController {
	
	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;
	
	@RequestMapping(value="/list-online",method=RequestMethod.GET)
	public String listOnlineDevice(ModelMap model) {
		List<ReadableDevice> onlinedevices = deviceService.viewOnlineDevice();
		model.addAttribute("onlinedevices", onlinedevices);
		return "list-online";
	}
	
	@RequestMapping(value="/list-all",method=RequestMethod.GET)
	public String listAllDevice(ModelMap model) {
		List<ReadableDevice> alldevices = deviceService.viewAllDevice();
		model.addAttribute("alldevices", alldevices);
		return "list-all";
	}
}
