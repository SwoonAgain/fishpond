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
	
	private static final String SELECT_BASE = "select * from device_edit_parameter";
	
	private static final String UPDATE = "update device_edit_parameter set"
			+ " throwing_time = ? ,interval_time=?,manual_feed_weight=?,"
			+ "first_meal_quantity=?,first_meal_open_time=?,first_meal_close_time=?,"
			+ "second_meal_quantity=?,second_meal_open_time=?,second_meal_close_time=?,"
			+ "third_meal_quantity=?,third_meal_open_time=?,third_meal_close_time=?,"
			+ "fourth_meal_quantity=?,fourth_meal_open_time=?,fourth_meal_close_time=?"
			+ " where device_id = ?";

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
				parameter.setFourthMealOpenTime(rs.getString(position++));
				parameter.setFourthMealCloseTime(rs.getString(position++));
				return parameter;
			}
		};
	}
	
	@Override
	public DeviceEditParameter findByDeviceId(int deviceId){
		String sql = SELECT_BASE+" where device_id = ?";
		return  jdbcTemplate.queryForObject(sql, rowMapper,deviceId);
	}

	@Override
	public void update(DeviceEditParameter editParameter) {
		jdbcTemplate.update(UPDATE, editParameter.getThrowingTime(),editParameter.getIntervalTime(),editParameter.getManualFeedWeight(),
				editParameter.getFirstMealQuantity(),editParameter.getFirstMealOpenTime(),editParameter.getFirstMealCloseTime(),
				editParameter.getSecondMealQuantity(),editParameter.getSecondMealOpenTime(),editParameter.getSecondMealCloseTime(),
				editParameter.getThirdMealQuantity(),editParameter.getThirdMealOpenTime(),editParameter.getThirdMealCloseTime(),
				editParameter.getFourthMealQuantity(),editParameter.getFourthMealOpenTime(),editParameter.getFourthMealCloseTime(),
				editParameter.getDeviceId());
	}
}
