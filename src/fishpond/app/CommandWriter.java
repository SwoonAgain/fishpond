package fishpond.app;


public interface CommandWriter {
	/**
	 * 写命令
	 * @param command
	 * @return
	 */
	boolean write(byte[] command);
}
