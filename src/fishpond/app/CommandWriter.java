package fishpond.app;

import fishpond.app.CommandMappingHelper.CommandType;
import fishpond.entity.Command;


public interface CommandWriter {
	/**
	 * 写命令
	 * @param command
	 * @return
	 */
	boolean write(byte[] command);
	
	byte[] writeExpectResponse(byte[] command,Command commandEntity,CommandType type);
}
