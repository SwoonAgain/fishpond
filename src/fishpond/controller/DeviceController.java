package fishpond.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fishpond.entity.ReadableDevice;
import fishpond.service.DeviceService;

@Controller("deviceController")
public class DeviceController {

	private static final int PER_PAGE_COUNT = 10;

	@Resource(name = "deviceServiceImpl")
	private DeviceService deviceService;

	@RequestMapping(value="/list-online/{page}",method=RequestMethod.GET)
	public String listOnlineDevice(@PathVariable Integer page,HttpServletRequest request,ModelMap model) {
		List<ReadableDevice> onlinedevices = deviceService.viewOnlineDevice(null, countBegin(1), PER_PAGE_COUNT);
		int onlineDevicesAmoount = deviceService.onlineDeviceAmount();
		int pageAmount = countPageAmount(onlineDevicesAmoount, PER_PAGE_COUNT);
		request.getSession().setAttribute("pageAmount", pageAmount);
		model.addAttribute("onlinedevices", onlinedevices);
		return "list-online";
	}

	@RequestMapping(value="/list-all/{page}",method=RequestMethod.GET)
	public String listAllDevice(@PathVariable Integer page,HttpServletRequest request,ModelMap model) {
		List<ReadableDevice> alldevices = deviceService.viewAllDevice(null, countBegin(1), PER_PAGE_COUNT);
		int allDevicesAmoount = deviceService.allDeviceAmount();
		int pageAmount = countPageAmount(allDevicesAmoount, PER_PAGE_COUNT);
		request.getSession().setAttribute("pageAmount", pageAmount);
		model.addAttribute("alldevices", alldevices);
		return "list-all";
	}

	@RequestMapping(value="/list-online/table/{page}",method=RequestMethod.GET)
	public String listOnlineDeviceTable(@PathVariable Integer page,HttpServletRequest request,
			@RequestParam(value="sort", required=false) String sort,
			@RequestParam(value="filter", required=false) String filter,
			@RequestParam(value="value", required=false) String value,
			ModelMap model) {
		filter = composeFilter(filter, value);
		List<ReadableDevice> onlinedevices = deviceService.viewOnlineDevice(sort,countBegin(page),PER_PAGE_COUNT,filter);
		int devicesAmoount = deviceService.onlineDeviceAmount(filter);
		int pageAmount = countPageAmount(devicesAmoount, PER_PAGE_COUNT);
		request.getSession().setAttribute("pageAmount", pageAmount);
		model.addAttribute("onlinedevices", onlinedevices);
		return "onlineDevicesTable";
	}

	@RequestMapping(value="/list-all/table/{page}",method=RequestMethod.GET)
	public String listAllDeviceTable(@PathVariable Integer page,HttpServletRequest request,
			@RequestParam(value="sort", required=false) String sort,
			@RequestParam(value="filter", required=false) String filter,
			@RequestParam(value="value", required=false) String value,
			ModelMap model) {
		filter = composeFilter(filter, value);
		List<ReadableDevice> alldevices = deviceService.viewAllDevice(sort,countBegin(page),PER_PAGE_COUNT,filter);
		int devicesAmoount = deviceService.deviceAmount(filter);
		int pageAmount = countPageAmount(devicesAmoount, PER_PAGE_COUNT);
		request.getSession().setAttribute("pageAmount", pageAmount);
		model.addAttribute("alldevices", alldevices);
		return "allDevicesTable";
	}

	@RequestMapping(value="/*/table/{onPage}/update-page-amount",method=RequestMethod.GET)
	@ResponseBody
	public String updatePageAmount(@PathVariable Integer onPage,HttpServletRequest request) {
		int pageAmount = (Integer) request.getSession().getAttribute("pageAmount");
		return "{"+"\"onPage\":\""+onPage+"\",\"pageAmount\":\""+pageAmount+"\"}";
	}

	private int countPageAmount(int amount, int perPage) {
		return amount%perPage == 0 ? amount/perPage : amount/perPage+1;
	}

	private int countBegin(int page) {
		return (page-1)*PER_PAGE_COUNT;
	}

	private String composeFilter(String filter,String value){
		if (StringUtils.isEmpty(value)) {
			filter = "";
		}else{
			try {
				value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			filter = filter+"-'"+value+"'";
		}
		return filter;
	}
}
