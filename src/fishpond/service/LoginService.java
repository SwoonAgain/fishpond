package fishpond.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fishpond.entity.User;

public interface LoginService {
	
	boolean checkLoginUser(String username,String password);
	
	void addUser(User user, int userid);

	void updateUser(User user);
	
	void deleteUser(User user);
	
	int checkUserDB(User user);

	int getUserId(String username);
	
	int allUserAmount(String username);

	List<User> viewAllUser(String orderBy, int begin, int count,
			String username);
}
