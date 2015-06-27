package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.ReadableDeviceDao;
import fishpond.entity.ReadableDevice;

@Repository("readableDeviceDaoImpl")
public class ReadableDeviceDaoImpl implements ReadableDeviceDao {
	
	private static final String SQL_FIND_ALL = "SELECT _id,dtu_code,company_name,fish_pond_name,fish_pond_no,platform_id,online_status"
			+ " FROM view_device_c_p order by _id";

	private static final String SQL_FIND_ONLINE = "SELECT _id,dtu_code,company_name,fish_pond_name,fish_pond_no,platform_id,online_status"
			+ " FROM view_device_c_p where online_status = true order by _id";
	
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
	public List<ReadableDevice> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL,rowMapper);
	}

	@Override
	public List<ReadableDevice> findOnline() {
		return jdbcTemplate.query(SQL_FIND_ONLINE,rowMapper);
	}
}
