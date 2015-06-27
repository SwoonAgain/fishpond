package fishpond.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fishpond.dao.DeviceDao;
import fishpond.entity.Device;

@Controller("rawDeviceController")
//@RequestMapping("/view/raw")
public class RawDeviceController {
	
	@Resource(name = "deviceDaoImpl")
	private DeviceDao deviceDao;

//	@RequestMapping(value="/view_all",method=RequestMethod.GET)
	public String listOnlineDevice(ModelMap model) {
		List<Device> list = deviceDao.findAll();
		model.addAttribute("devices", list);
		return "list";
	}
}
