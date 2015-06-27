package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.DeviceEditParameterDao;
import fishpond.entity.DeviceEditParameter;

@Repository("deviceEditParameterDaoImpl")
public class DeviceEditParameterDaoImpl implements DeviceEditParameterDao {
	
	private static final String SELECTALL_COLUMN = "select * from device_edit_parameter";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<DeviceEditParameter> rowMapper;
	
	public DeviceEditParameterDaoImpl() {
		rowMapper = new RowMapper<DeviceEditParameter>() {
			
			@Override
			public DeviceEditParameter mapRow(ResultSet rs, int rownumber) throws SQLException {
				DeviceEditParameter parameter = new DeviceEditParameter();
				int position = 1;
				parameter.setDeviceId(rs.getInt(position++));
				parameter.setThrowingTime(rs.getString(position++));
				parameter.setIntervalTime(rs.getString(position++));
				parameter.setManualFeedWeight(rs.getString(position++));
				parameter.setFirstMealQuantity(rs.getString(position++));
				parameter.setFirstMealOpenTime(rs.getString(position++));
				parameter.setFirstMealCloseTime(rs.getString(position++));
				parameter.setSecondMealQuantity(rs.getString(position++));
				parameter.setSecondMealOpenTime(rs.getString(position++));
				parameter.setSecondMealCloseTime(rs.getString(position++));
				parameter.setThirdMealQuantity(rs.getString(position++));
				parameter.setThirdMealOpenTime(rs.getString(position++));
				parameter.setThirdMealCloseTime(rs.getString(position++));
				parameter.setFourthMealQuantity(rs.getString(position++));
				parameter.setFourthMealCloseTime(rs.getString(position++));
				parameter.setFourthMealCloseTime(rs.getString(position++));
				return parameter;
			}
		};
	}
	
	@Override
	public DeviceEditParameter findByDeviceId(int deviceId){
		String sql = SELECTALL_COLUMN+" where device_id = ?";
		return  jdbcTemplate.queryForObject(sql, rowMapper,deviceId);
	}
}
