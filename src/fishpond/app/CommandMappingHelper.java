package fishpond.app;

import fishpond.entity.Command;


public class CommandMappingHelper {

	/**
	 * @param command
	 * @param type
	 * @return
	 */
	public static String expect(Command command,CommandType type){
		switch (type) {
		case READ_SEND:
			return command.getRdSend();
		case READ_RECEIVE:
			return command.getRdReceive();
		case MODIFY_SEND:
			return command.getMdfySend();
		case MODIFY_RECEIVE:
			return command.getMdfyReceive();
		default:
			return "";
		}
	}
	
	public static int expectLength(Command command,CommandType type){
		switch (type) {
		case READ_SEND:
			return command.getRdSendLength();
		case READ_RECEIVE:
			return command.getRdReceiveLength();
		case MODIFY_SEND:
			return command.getMdfySendLength();
		case MODIFY_RECEIVE:
			return command.getMdfyReceiveLength();
		default:
			return 0;
		}
	}

	public enum CommandType{
		READ_SEND,READ_RECEIVE,MODIFY_SEND,MODIFY_RECEIVE
	}
}
