package fishpond.service;

import java.util.List;

import fishpond.entity.User;
import fishpond.entity.Company;
import fishpond.entity.Pond;

public interface ManagementService {

	List<Company> listAllCompanies();

	List<Pond> listAllPonds();

	List<User> listAllUsers();

}
