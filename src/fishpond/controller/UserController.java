package fishpond.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fishpond.entity.User;
import fishpond.service.LoginService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	
	private static final int PER_PAGE_COUNT = 10;
	
	@Resource(name="loginServiceImpl")
	private LoginService loginService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String getDeviceEditParameter(HttpServletRequest request) {
		String user = request.getParameter("user");
		String psword = request.getParameter("psword");
		boolean result = loginService.checkLoginUser(user, psword);
		if (result) {
			request.getSession().setAttribute("username",user);
			return "redirect:main";
		}else{
			return "redirect:/index.jsp";
		}
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void addUser(User user,HttpServletRequest request){
		int result = loginService.checkUserDB(user);
		if(result == 0){
			String username = (String) request.getAttribute("username");
			int userid = loginService.getUserId(username);
			loginService.addUser(user,userid);
		}else{
			
		}
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public void updateUser(User user){
		int result = loginService.checkUserDB(user);
		if(result == 0){
			loginService.updateUser(user);
		}else{
			
		}
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public void deleteUser(User user){
		loginService.deleteUser(user);
	}
	
	@RequestMapping(value="/list-user/{page}",method=RequestMethod.GET)
	public String listUser(@PathVariable Integer page,ModelMap model,HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		List<User> alldevices = loginService.viewAllUser(null, countBegin(1), PER_PAGE_COUNT,username);
		int allDevicesAmoount = loginService.allUserAmount(username);
		int pageAmount = countPageAmount(allDevicesAmoount, PER_PAGE_COUNT);
		model.addAttribute("onPage", page);
		model.addAttribute("pageAmount", pageAmount);
		model.addAttribute("alldevices", alldevices);
		return "list-user";
	}
	
	private int countBegin(int page) {
		return (page-1)*PER_PAGE_COUNT;
	}
	
	private int countPageAmount(int amount, int perPage) {
		int rest = amount%perPage;
		if (rest == 0) {
			return amount/perPage == 0 ? 1:amount/perPage;
		}
		return amount/perPage+1;
	}
	
}
