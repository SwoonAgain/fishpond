package fishpond.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.ReadUserDao;
import fishpond.entity.User;
import fishpond.utils.SQLUtil;

@Repository("readUserDaoImpl")
public class ReadUserDaoImpl implements ReadUserDao{
	
	private static final String SQL_COUNT_LOGIN = "select count(_id) from f_user";
	
	private static final String SQL_USERID = "select _id from f_user";
	
	private static final String SQL_USER = "select * from f_user";
	
	private static final String UPDATE = "update f_user set username=?,psword=?,phone=?,email=?,belong=? where _id = ?";
	
	private static final String SQL_INSERT = "insert into f_user ("
			+ "username,psword,phone,email,belong) values (?,?,?,?,?)";
	
	private static final String SQL_DELETE = "delete from f_user where _id = ? or belong = ? ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<User> rowUser;
	
	public ReadUserDaoImpl() {
		rowUser = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {
				User user  = new User();
				int position = 1;
				user.set_id(rs.getInt(position++));
				user.setUsername(rs.getString(position++));
				user.setPsword(rs.getString(position++));
				user.setPhone(rs.getString(position++));
				user.setEmail(rs.getString(position++));
				user.setBelong(rs.getInt(position++));
				return user;
			}
		};
		
	}
	
	@Override
	public boolean getCheckLogin(String username, String password) {
		String where = " where username = '"+username;
		String sql = SQL_COUNT_LOGIN + where;
		User user =  jdbcTemplate.queryForObject(sql, User.class);
		if (user != null && password.equals(user.getPsword())) {
			return true;
		}
		return false;
	}

	
	@Override
	public int getUserAmount(String username) {
		String where = " where belong = '"+username+"'";
		String sql = SQL_COUNT_LOGIN + where;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public List<User> findUser(String orderBy,int begin,int count,String username) {
		String order = SQLUtil.orderClause(orderBy,"_id");
		String where = " where belong = '"+username+"'";
		String limit = SQLUtil.limitClaus(begin,count);
		String sql = SQL_USER+where+order+limit;
		return jdbcTemplate.query(sql,rowUser);
	}
	
	@Override
	public void add(User user,int userid){
		jdbcTemplate.update(SQL_INSERT,user.getUsername(),user.getPsword(),user.getPhone(),user.getEmail(),userid);
	}
	
	@Override
	public void update(User user){
		jdbcTemplate.update(UPDATE,user.getUsername(),user.getPsword(),user.getPhone(),user.getEmail(),user.getBelong(),user.get_id());
	}
	
	@Override
	public void delete(User user){
		jdbcTemplate.update(SQL_DELETE,user.get_id(),user.get_id());
	}

	@Override
	public int getCheckUserDB(User user) {
		String where = " where username = '"+user.getUsername()+"' ";
		String sql = SQL_COUNT_LOGIN + where;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public int getUserId(String username) {
		String where = " where username = '"+username+"'";
		String sql = SQL_USERID + where;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
}
