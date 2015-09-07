package fishpond.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fishpond.entity.DeviceStatus;
import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Controller("deviceController")
public class DeviceController {

	private static final int PER_PAGE_COUNT = 10;

	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;

	@RequestMapping(value="/list-online/{page}",method=RequestMethod.GET)
	public String listOnlineDevice(@PathVariable Integer page,ModelMap model) {
		List<ReadableDevice> onlinedevices = deviceService.viewOnlineDevice(null, countBegin(1), PER_PAGE_COUNT);
		List<DeviceStatus> status = deviceService.getStatus(onlinedevices);
		int onlineDevicesAmoount = deviceService.onlineDeviceAmount();
		int pageAmount = countPageAmount(onlineDevicesAmoount, PER_PAGE_COUNT);
		model.addAttribute("onPage", page);
		model.addAttribute("pageAmount", pageAmount);
		model.addAttribute("onlinedevices", onlinedevices);
		model.addAttribute("status", status);
		return "list-online";
	}

	@RequestMapping(value="/list-all/{page}",method=RequestMethod.GET)
	public String listAllDevice(@PathVariable Integer page,ModelMap model) {
		List<ReadableDevice> alldevices = deviceService.viewAllDevice(null, countBegin(1), PER_PAGE_COUNT);
		int allDevicesAmoount = deviceService.allDeviceAmount();
		int pageAmount = countPageAmount(allDevicesAmoount, PER_PAGE_COUNT);
		model.addAttribute("onPage", page);
		model.addAttribute("pageAmount", pageAmount);
		model.addAttribute("alldevices", alldevices);
		return "list-all";
	}

	@RequestMapping(value="/list-online/table/{page}",method=RequestMethod.GET)
	public String listOnlineDeviceTable(@PathVariable Integer page,
			@RequestParam(value="sort", required=false) String sort,
			@RequestParam(value="filter", required=false) String filter,
			@RequestParam(value="value", required=false) String value,
			ModelMap model) {
		filter = composeFilter(filter, value);
		List<ReadableDevice> onlinedevices = deviceService.viewOnlineDevice(sort,countBegin(page),PER_PAGE_COUNT,filter);
		int devicesAmoount = deviceService.onlineDeviceAmount(filter);
		int pageAmount = countPageAmount(devicesAmoount, PER_PAGE_COUNT);
		model.addAttribute("onPage", page);
		model.addAttribute("pageAmount", pageAmount);
		model.addAttribute("onlinedevices", onlinedevices);
		return "onlineDevicesTable";
	}

	@RequestMapping(value="/list-all/table/{page}",method=RequestMethod.GET)
	public String listAllDeviceTable(@PathVariable Integer page,
			@RequestParam(value="sort", required=false) String sort,
			@RequestParam(value="filter", required=false) String filter,
			@RequestParam(value="value", required=false) String value,
			ModelMap model) {
		filter = composeFilter(filter, value);
		List<ReadableDevice> alldevices = deviceService.viewAllDevice(sort,countBegin(page),PER_PAGE_COUNT,filter);
		int devicesAmoount = deviceService.deviceAmount(filter);
		int pageAmount = countPageAmount(devicesAmoount, PER_PAGE_COUNT);
		model.addAttribute("onPage", page);
		model.addAttribute("pageAmount", pageAmount);
		model.addAttribute("alldevices", alldevices);
		return "allDevicesTable";
	}
	
	@RequestMapping(value="/list-online/**/refresh",method=RequestMethod.POST)
	@ResponseBody
	public List<DeviceStatus> refreshStatus(@RequestParam(value="ids[]") String[] ids){
		List<DeviceStatus> status = deviceService.refreshStatus(ids);
		return status;
	}
	
	@RequestMapping(value="/list-all/**/refresh",method=RequestMethod.POST)
	@ResponseBody
	public List<DeviceStatus> refreshStatusTest(@RequestParam(value="ids[]") String[] ids){
		List<DeviceStatus> status = deviceService.refreshStatus(ids);
		return status;
	}

	private int countPageAmount(int amount, int perPage) {
		int rest = amount%perPage;
		if (rest == 0) {
			return amount/perPage == 0 ? 1:amount/perPage;
		}
		return amount/perPage+1;
	}

	private int countBegin(int page) {
		return (page-1)*PER_PAGE_COUNT;
	}

	private String composeFilter(String filter,String value){
		if (StringUtils.isEmpty(value)) {
			filter = "";
		}else{
			filter = filter+"-'"+value+"'";
		}
		return filter;
	}
}
