package fishpond.dao;

import fishpond.entity.Command;

public interface CommandDao {

	Command findByName(String name);
	
}
