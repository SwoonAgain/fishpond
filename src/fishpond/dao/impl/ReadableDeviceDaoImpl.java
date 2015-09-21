package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.ReadableDeviceDao;
import fishpond.entity.ReadableDevice;
import fishpond.utils.SQLUtil;

@Repository("readableDeviceDaoImpl")
public class ReadableDeviceDaoImpl implements ReadableDeviceDao {
	
	private static final String SQL_BASE = "SELECT * FROM view_device_c_p";
	
	private static final String SQL_COUNT_BASE = "select count(_id) from view_device_c_p";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<ReadableDevice> rowMapper;
	
	public ReadableDeviceDaoImpl() {
		rowMapper = new RowMapper<ReadableDevice>() {

			@Override
			public ReadableDevice mapRow(ResultSet rs, int rownumber) throws SQLException {
				ReadableDevice device  = new ReadableDevice();
				int position = 1;
				device.set_id(rs.getInt(position++));
				device.setDtuCode(rs.getString(position++));
				device.setCompanyName(rs.getString(position++));
				device.setFishPondName(rs.getString(position++));
				device.setFishPondNo(rs.getString(position++));
				device.setPlatformId(rs.getString(position++));
				device.setOnlineStatus(rs.getBoolean(position++));
				return device;
			}
		};
	}
	
	@Override
	public List<ReadableDevice> find(String orderBy,int begin,int count,Map<String,Object> filters) {
		String order = SQLUtil.orderClause(orderBy,"_id");
		String where = SQLUtil.whereClause(filters);
		String limit = SQLUtil.limitClaus(begin,count);
		String sql = SQL_BASE+where+order+limit;
		return jdbcTemplate.query(sql,rowMapper);
	}

	@Override
	public int getDeviceAmount(Map<String,Object> filters) {
		String where = SQLUtil.whereClause(filters);
		String sql = SQL_COUNT_BASE + where;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
