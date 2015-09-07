package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.DeviceStatusDao;
import fishpond.entity.DeviceStatus;

@Repository("deviceStatusDaoImpl")
public class DeviceStatusDaoImpl implements DeviceStatusDao {
	
	private static final String SELECT_BASE = "select * from device_status";
	
	private static final String UPDATE_WEIGHT = "update device_status set current_weight = ?,update_time = now() where device_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<DeviceStatus> rowMapper;
	
	public DeviceStatusDaoImpl(){
		rowMapper = new RowMapper<DeviceStatus>() {
			
			@Override
			public DeviceStatus mapRow(ResultSet rs, int rownumber) throws SQLException {
				DeviceStatus deviceStatus = new DeviceStatus();
				int position = 1;
				deviceStatus.setDeviceId(rs.getInt(position++));
				deviceStatus.setCurrentWeight(rs.getInt(position++));
				deviceStatus.setDissolvedOxygen(rs.getInt(position++));
				deviceStatus.setWaterTemperature(rs.getInt(position++));
				deviceStatus.setUpdateTime(rs.getTimestamp(position++));
				return deviceStatus;
			}
		};
	}
	
	@Override
	public DeviceStatus findByDeviceId(int deviceId) {
		String sql = SELECT_BASE+" where device_id = ?";
		return  jdbcTemplate.queryForObject(sql, rowMapper,deviceId);
	}

	@Override
	public void updateWeight(int deviceId, int weight) {
		jdbcTemplate.update(UPDATE_WEIGHT, weight, deviceId);
	}

}
