package fishpond.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import fishpond.entity.Company;
import fishpond.entity.Pond;
import fishpond.entity.User;
import fishpond.service.ManagementService;

@Controller("managementController")
public class ManagementController {
	
	@Resource(name = "managementServiceImpl")
	private ManagementService managementService;

	public String viewManagement(ModelMap model) {
		List<Company> companies = managementService.listAllCompanies();
		List<Pond> ponds = managementService.listAllPonds();
		List<User> users = managementService.listAllUsers();
		model.addAttribute("companies", companies);
		model.addAttribute("ponds", ponds);
		model.addAttribute("users", users);
		return "management";
	}
}
