package fishpond.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import fishpond.dao.ReadUserDao;
import fishpond.entity.User;
import fishpond.service.LoginService;
import fishpond.utils.EncriptUtil;

@Service("loginServiceImpl")
public class LoginServiceImpl implements LoginService{

	@Resource(name = "readUserDaoImpl")
	private ReadUserDao readUserDao;
	
	@Override
	public boolean checkLoginUser(String username, String password) {
		password = EncriptUtil.MD5(password);
		return readUserDao.getCheckLogin(username, password);
	}

	@Override
	public void addUser(User user,int userid) {
		readUserDao.add(user,userid);
	}

	@Override
	public void updateUser(User user) {
		readUserDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		readUserDao.delete(user);
	}

	@Override
	public int checkUserDB(User user) {
		return readUserDao.getCheckUserDB(user);
	}

	@Override
	public int getUserId(String username) {
		return readUserDao.getUserId(username);
	}
	
	@Override
	public int allUserAmount(String username) {
		return readUserDao.getUserAmount(username);
	}
	
	@Override
	public List<User> viewAllUser(String orderBy,int begin,int count,String username) {
		return readUserDao.findUser(orderBy,begin,count,username);
	}
	
}
