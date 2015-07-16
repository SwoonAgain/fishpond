package fishpond.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fishpond.dao.CommandDao;
import fishpond.entity.Command;

@Repository("commandDaoImpl")
public class CommandDaoImpl implements CommandDao {
	
	private static final String SQL_BASE = "select * from command";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Command> rowMapper;
	
	public CommandDaoImpl() {
		rowMapper = new RowMapper<Command>() {

			@Override
			public Command mapRow(ResultSet rs, int rownumber) throws SQLException {
				Command command  = new Command();
				int position = 1;
				command.set_id(rs.getInt(position++));
				command.setParameterName(rs.getString(position++));
				command.setRdSend(rs.getString(position++));
				command.setRdSendLength(rs.getInt(position++));
				command.setRdReceive(rs.getString(position++));
				command.setRdReceiveLength(rs.getInt(position++));
				command.setMdfySend(rs.getString(position++));
				command.setMdfySendLength(rs.getInt(position++));
				command.setMdfyReceive(rs.getString(position++));
				command.setMdfyReceiveLength(rs.getInt(position++));
				return command;
			}
		};
	}
	
	public List<Command> findAll(){
		return jdbcTemplate.query(SQL_BASE, rowMapper);
	}
	
	@Override
	public Command findByName(String name) {
		String sql = SQL_BASE+" where parameter_name = '"+name+"'";
		return jdbcTemplate.queryForObject(sql, rowMapper);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
