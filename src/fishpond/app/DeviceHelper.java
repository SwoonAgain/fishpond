package fishpond.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import fishpond.app.CommandMappingHelper.CommandType;
import fishpond.dao.impl.CommandDaoImpl;
import fishpond.entity.Command;
import fishpond.entity.DeviceEditParameter;
import fishpond.entity.DeviceStatus;
import fishpond.utils.ConvertUtil;
import fishpond.utils.SpringApplicationContextProvider;

/**
 *发送指令给设备，获取设备反馈值
 * </br>
 * @author zweiwei1987@gmail.com
 */
public class DeviceHelper {


	/**
	 * @param commandWriter
	 * @param fromUser  从前端提交的值
	 * @param fromdataBase 数据库存储的值
	 * @return 是否写成功
	 */
	public static boolean writeToDevice(CommandWriter commandWriter,
			DeviceEditParameter fromUser,DeviceEditParameter fromdataBase) {
		//抛料时间
		if(!fromUser.getThrowingTime().equals(fromdataBase.getThrowingTime())){
			String values = fromUser.getThrowingTime();
			Command command = getCommandByName("throwingTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("抛料时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//间隔时间
		if(!fromUser.getIntervalTime().equals(fromdataBase.getIntervalTime())){
			String values = fromUser.getIntervalTime();
			Command command = getCommandByName("intervalTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("间隔时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//手动喂料重量
		if(!fromUser.getManualFeedWeight().equals(fromdataBase.getManualFeedWeight())){
			String values = fromUser.getManualFeedWeight();
			Command command = getCommandByName("manualFeedWeight");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("手动喂料重量回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第一餐目标量
		if(!fromUser.getFirstMealQuantity().equals(fromdataBase.getFirstMealQuantity())){
			String values = fromUser.getFirstMealQuantity();
			Command command = getCommandByName("firstMealQuantity");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第一餐目标量回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第二餐目标量
		if(!fromUser.getSecondMealQuantity().equals(fromdataBase.getSecondMealQuantity())){
			String values = fromUser.getSecondMealQuantity();
			Command command = getCommandByName("secondMealQuantity");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第二餐目标量回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第三餐目标量
		if(!fromUser.getThirdMealQuantity().equals(fromdataBase.getThirdMealQuantity())){
			String values = fromUser.getThirdMealQuantity();
			Command command = getCommandByName("thirdMealQuantity");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第三餐目标量回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第一餐开时间
		if(!fromUser.getFirstMealOpenTime().equals(fromdataBase.getFirstMealOpenTime())){
			String[] values = fromUser.getFirstMealOpenTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("firstMealOpenTimeH");
				Command commandM = getCommandByName("firstMealOpenTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第一餐开时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		//第一餐关时间
		if(!fromUser.getFirstMealCloseTime().equals(fromdataBase.getFirstMealCloseTime())){
			String[] values = fromUser.getFirstMealCloseTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("firstMealCloseTimeH");
				Command commandM = getCommandByName("firstMealCloseTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第一餐关时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		//第二餐开时间
		if(!fromUser.getSecondMealOpenTime().equals(fromdataBase.getSecondMealOpenTime())){
			String[] values = fromUser.getSecondMealOpenTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("secondMealOpenTimeH");
				Command commandM = getCommandByName("secondMealOpenTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第二餐开时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		//第二餐关时间
		if(!fromUser.getSecondMealCloseTime().equals(fromdataBase.getSecondMealCloseTime())){
			String[] values = fromUser.getSecondMealCloseTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("secondMealCloseTimeH");
				Command commandM = getCommandByName("secondMealCloseTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第二餐关时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		//第三餐开时间
		if(!fromUser.getThirdMealOpenTime().equals(fromdataBase.getThirdMealOpenTime())){
			String[] values = fromUser.getThirdMealOpenTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("thirdMealOpenTimeH");
				Command commandM = getCommandByName("thirdMealOpenTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第三餐开时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		//第三餐关时间
		if(!fromUser.getThirdMealCloseTime().equals(fromdataBase.getThirdMealCloseTime())){
			String[] values = fromUser.getThirdMealCloseTime().split(":");
			boolean isValid =  checkValues(values);
			if (isValid) {
				Command commandH = getCommandByName("thirdMealCloseTimeH");
				Command commandM = getCommandByName("thirdMealCloseTimeM");
				byte[] commandBytesH = compose(commandH, CommandType.MODIFY_SEND,values[0]);
				byte[] responseH = commandWriter.writeExpectResponse(commandBytesH,
						commandH,CommandType.MODIFY_RECEIVE);
				byte[] commandBytesM = compose(commandM, CommandType.MODIFY_SEND,values[1]);
				byte[] responseM = commandWriter.writeExpectResponse(commandBytesM,
						commandM,CommandType.MODIFY_RECEIVE);
				System.out.println("第三餐关时间回复:"+Arrays.toString(responseH)+"\n"+Arrays.toString(responseM));
				if(responseH == null || responseM == null || ! CRC16M.checkBuf(responseH) || ! CRC16M.checkBuf(responseM)){
					return false;
				}
			}
		}
		return true;
	}

	private static boolean checkValues(String[] values) {
		if (values == null || values.length != 2) {
			return false;
		}
		try {
			Integer.valueOf(values[0]);
			Integer.valueOf(values[1]);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param commandWriter
	 * @return
	 */
	public static  DeviceStatus requestDeviceStatus(Integer deviceId,CommandWriter commandWriter) throws DeviceReadException{
		Command command0 = getCommandByName("currentWeight");
		Command command1 = getCommandByName("WorkStatusCollection1");
		Command command2 = getCommandByName("WorkStatusCollection2");
		Command command3 = getCommandByName("manualStop");
		Command command4 = getCommandByName("lackMaterail");
		Command command5 = getCommandByName("lackPhase");
		byte[] commandBytes0 = compose(command0, CommandType.READ_SEND);
		byte[] commandBytes1 = compose(command1, CommandType.READ_SEND);
		byte[] commandBytes2 = compose(command2, CommandType.READ_SEND);
		byte[] commandBytes3 = compose(command3, CommandType.READ_SEND);
		byte[] commandBytes4 = compose(command4, CommandType.READ_SEND);
		byte[] commandBytes5 = compose(command5, CommandType.READ_SEND);
		byte[] response0 = commandWriter.writeExpectResponse(commandBytes0,
				command0,CommandType.READ_RECEIVE);
		System.out.println("response0（实时重量）"+ConvertUtil.bytesToHexString(response0));
		byte[] response1 = commandWriter.writeExpectResponse(commandBytes1,
				command1,CommandType.READ_RECEIVE);
		System.out.println("response1（集合1）"+(response1==null ?"no response":ConvertUtil.bytesToHexString(response1)));
		byte[] response2 = commandWriter.writeExpectResponse(commandBytes2,
				command2,CommandType.READ_RECEIVE);
		System.out.println("response2（集合2）"+(response2==null ?"no response":ConvertUtil.bytesToHexString(response2)));
		byte[] response3 = commandWriter.writeExpectResponse(commandBytes3,
				command3,CommandType.READ_RECEIVE);
		System.out.println("response3（手动停止）"+(response3==null ?"no response":ConvertUtil.bytesToHexString(response3)));
		byte[] response4 = commandWriter.writeExpectResponse(commandBytes4,
				command4,CommandType.READ_RECEIVE);
		System.out.println("response4（缺料）"+(response4==null ?"no response":ConvertUtil.bytesToHexString(response4)));
		byte[] response5 = commandWriter.writeExpectResponse(commandBytes5,
				command5,CommandType.READ_RECEIVE);
		System.out.println("response5（缺相）"+(response5==null ?"no response":ConvertUtil.bytesToHexString(response5)));
		int currentWeight = 0;
		boolean manualStop = false;
		boolean lackMaterail = false;
		boolean lackPhase = false;
		String err = "DTU:"+deviceId;
		boolean isErr = false;
		if (response0 != null &&CRC16M.checkBuf(response0)) {
			byte[] result = new byte[2];
			System.arraycopy(response0, 3, result, 0, result.length);
			currentWeight = Integer.valueOf(ConvertUtil.bytesToHexString(result), 16);
		}else{
			err += "\t读取实时重量出错！";
			isErr = true;
		}
		//TODO response1 response2
		if (response3 != null &&CRC16M.checkBuf(response3)) {
		}else{
			err += "\t读取手动停止出错！";
			isErr = true;
		}
		if (response4 != null &&CRC16M.checkBuf(response4)) {
		}else{
			err += "\t读取缺料出错！";
			isErr = true;
		}
		if (response5 != null &&CRC16M.checkBuf(response5)) {
		}else{
			err += "\t读取缺相出错！";
			isErr = true;
		}
		if (isErr) {
			throw new DeviceReadException(err);
		}
		DeviceStatus status = new DeviceStatus();
		status.setCurrentWeight(currentWeight);
		status.setManualStop(manualStop);
		status.setLackMaterail(lackMaterail);
		status.setLackPhase(lackPhase);
		return status;
	}

	/**
	 * 
	 * @param deviceId
	 * @param commandWriter
	 * @return currentWeight
	 * @throws DeviceReadException
	 */
	public static int queryCurrentWeight(Integer deviceId,CommandWriter commandWriter) throws DeviceReadException {
		Command command = getCommandByName("currentWeight");
		byte[] commandBytes = compose(command, CommandType.READ_SEND);
		byte[] response = commandWriter.writeExpectResponse(commandBytes,
				command,CommandType.READ_RECEIVE);
		int currentWeight = 0;
		String err = "DTU:"+deviceId;
		if (response != null &&CRC16M.checkBuf(response)) {
			byte[] result = new byte[2];
			System.arraycopy(response, 3, result, 0, result.length);
			currentWeight = Integer.valueOf(ConvertUtil.bytesToHexString(result), 16);
		}else{
			err += "\t读取实时重量出错！";
			throw new DeviceReadException(err);
		}
		return currentWeight;
	}

	/**
	 * 针对不带值的，读指令
	 * @param commandName
	 * @param type
	 * @return commandName不对返回null
	 */
	private static byte[] compose(Command command,CommandType type){
		String hexValue = "";
		String pre = CommandMappingHelper.expect(command,type);
		hexValue = pre + hexValue;
		byte[] bytesValue = CRC16M.getSendBuf(hexValue);
		return bytesValue;
	}

	/**
	 * 针对带值的，用于发送修改指令
	 * @param commandName
	 * @param type
	 * @param values
	 * @return commandName,value有误将返回null
	 */
	private static byte[] compose(Command command,CommandType type,String ...values){
		String hexValue = "";
		try{
			for (String string : values) {
				int intValue = Integer.parseInt(string);
				String tempHexValue = Integer.toHexString(intValue);
				switch(tempHexValue.length()){
				case 1: tempHexValue = "000"+tempHexValue;
				break;
				case 2: tempHexValue = "00"+tempHexValue;
				break;
				case 3: tempHexValue = "0"+tempHexValue;
				break;
				case 4:
					break;
				default:
					return null; //值不对
				}
				hexValue += tempHexValue;
			}
		}catch(NumberFormatException e){
			return null;
		}

		String pre = CommandMappingHelper.expect(command,type);
		hexValue = pre + hexValue;
		byte[] bytesValue = CRC16M.getSendBuf(hexValue);
		return bytesValue;
	}

	private static byte[] compose(Command command,CommandType type,String value){
		String hexValue = "";
		int intValue = Integer.parseInt(value);
		String tempHexValue = Integer.toHexString(intValue);
		switch(tempHexValue.length()){
		case 1: tempHexValue = "000"+tempHexValue;
		break;
		case 2: tempHexValue = "00"+tempHexValue;
		break;
		case 3: tempHexValue = "0"+tempHexValue;
		break;
		case 4:
			break;
		default:
			return null; //值不对
		}
		hexValue += tempHexValue;
		String pre = CommandMappingHelper.expect(command,type);
		hexValue = pre + hexValue;
		byte[] bytesValue = CRC16M.getSendBuf(hexValue);
		return bytesValue;
	}

	private static Command getCommandByName(String name){
		Command command = CommandHelper.getCommands().get(name);
		if (command == null) {  //commandName不对
			return null;
		}
		return command;
	}

	public static class CommandHelper{
		public static final Map<String,Command> getCommands(){
			if (commands == null) {
				commands = new HashMap<String, Command>();
				JdbcTemplate jdbcTemplate = SpringApplicationContextProvider.getApplicationContext().getBean(JdbcTemplate.class);
				CommandDaoImpl commandDaoImpl = new CommandDaoImpl();
				commandDaoImpl.setJdbcTemplate(jdbcTemplate);
				List<Command> commandList = commandDaoImpl.findAll();
				for (Command command : commandList) {
					commands.put(command.getParameterName(), command);
				}
			} 
			return commands;
		}

		private static Map<String,Command> commands;
	}


	public static class DeviceReadException extends Exception{

		public DeviceReadException(){
			super();
		}

		public DeviceReadException(String string) {
			super(string);
		}

		private static final long serialVersionUID = 2338557734619487315L;

	}
}
