package fishpond.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fishpond.entity.User;

public interface ReadUserDao {

	int getUserAmount(String username);

	List<User> findUser(String orderBy, int begin, int count,
			String username);

	boolean getCheckLogin(String username, String password);

	void add(User user, int userid);

	void update(User user);

	void delete(User user);

	int getCheckUserDB(User user);

	int getUserId(String username);

}
