package fishpond.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("loginController")
public class LoginController {
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String getDeviceEditParameter(HttpServletRequest request) {
		String user = request.getParameter("user");
		String psword = request.getParameter("psword");
		if ("admin".equals(user)&&"admin".equals(psword)) {
			return "redirect:main";
		}else{
			return "redirect:/index.jsp";
		}
	}
}
