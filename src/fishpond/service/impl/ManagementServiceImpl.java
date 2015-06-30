package fishpond.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fishpond.entity.Company;
import fishpond.entity.Pond;
import fishpond.entity.User;
import fishpond.service.ManagementService;

@Service("managementServiceImpl")
public class ManagementServiceImpl implements ManagementService {

	@Override
	public List<Company> listAllCompanies() {
		return null;
	}

	@Override
	public List<Pond> listAllPonds() {
		return null;
	}

	@Override
	public List<User> listAllUsers() {
		return null;
	}

}
