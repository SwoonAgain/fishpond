package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.DeviceDao;
import fishpond.entity.Device;
import fishpond.utils.SQLUtil;

@Repository("deviceDaoImpl")
public class DeviceDaoImpl  implements DeviceDao{

	private static final String SQL_COUNT = "select count(_id) from device";

	private static final String SQL_FIND_BY_FIELDS = "select _id,dtu_code,company_code,fish_pond_code,fish_pond_no,platform_id,online_status from device "
			+ "where dtu_code = ?";

	private static final String SQL_INSERT_DEVICE = "insert into device ("
			+ "company_code,fish_pond_code,fish_pond_no,platform_id) values (?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Device> rowMapper;
	
	public DeviceDaoImpl() {
		rowMapper = new RowMapper<Device>() {

			@Override
			public Device mapRow(ResultSet rs, int rownumber) throws SQLException {
				Device device  = new Device();
				int position = 1;
				device.set_id(rs.getInt(position++));
				device.setDtuCode(rs.getString(position++));
				device.setCompanyCode(rs.getString(position++));
				device.setFishPondCode(rs.getString(position++));
				device.setFishPondNo(rs.getString(position++));
				device.setPlatformId(rs.getString(position++));
				device.setOnlineStatus(rs.getBoolean(position++));
				return device;
			}
		};
	}

	public void add(Device device){
		jdbcTemplate.update(SQL_INSERT_DEVICE, 
				device.getCompanyCode(),device.getFishPondCode(),device.getFishPondNo(),device.getPlatformId());
	}

	@Override
	public Device findByDtuCode(String dtuCode) {
		return  jdbcTemplate.queryForObject(SQL_FIND_BY_FIELDS, rowMapper,dtuCode);
	}

	@Override
	public void update(String sql) {
		jdbcTemplate.update(sql);
	}
	
	/**
	 * don't use it before you know why it is here!
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
}
