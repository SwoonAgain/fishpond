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
	public int checkLoginUser(String username, String password) {
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
	public int getUserId(HttpServletRequest request) {
		return readUserDao.getUserId(request);
	}
	
	@Override
	public int allUserAmount(HttpServletRequest request) {
		return readUserDao.getUserAmount(request);
	}
	
	@Override
	public List<User> viewAllUser(String orderBy,int begin,int count,HttpServletRequest request) {
		return readUserDao.findUser(orderBy,begin,count,request);
	}
	
}
