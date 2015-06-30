package fishpond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("mainPageController")
public class MainPageController {

	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String index(ModelMap model) {
		//TODO
		return "main";
	}
	
	@RequestMapping(value="/management",method=RequestMethod.GET)
	public String management(ModelMap model) {
		//TODO
		return "management";
	}
	
	@RequestMapping(value="/setting",method=RequestMethod.GET)
	public String setting(ModelMap model) {
		//TODO
		return "setting";
	}
}
