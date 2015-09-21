package fishpond.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 所有的写指令类集中管理，在线的添加进来，断开连接则删除
 */
public class Application {

	/**
	 * 所有注册设备
	 * Integer deviceId
	 * CommandWriter commandWriter
	 */
	public static final Map<Integer, CommandWriter> MANDATORS =
			Collections.synchronizedMap(new HashMap<Integer, CommandWriter>());
	
	/**
	 * 所有未知设备
	 */
	public static final Map<Integer, CommandWriter> UNKNOWN_DEVICES =
			Collections.synchronizedMap(new HashMap<Integer, CommandWriter>());
	
	public static CommandWriter getCommandWriterByDeviceId(int deviceId){
		return MANDATORS.get(deviceId);
	}
}
