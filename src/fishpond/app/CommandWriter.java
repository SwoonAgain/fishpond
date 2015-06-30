package fishpond.app;


public interface CommandWriter {
	/**
	 * 写命令
	 * @param command
	 * @return
	 */
	boolean write(byte[] command);
	
	//TODO 每个由httprequest请求引起的写命令都在此定义方法，在service中以同步方法的方式实现。
}
