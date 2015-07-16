package fishpond.app;

import java.util.Arrays;

import fishpond.app.CommandMappingHelper.CommandType;
import fishpond.entity.Command;
import fishpond.entity.DeviceEditParameter;
import fishpond.entity.DeviceStatus;
import fishpond.utils.ConvertUtil;

public class DeviceEditParameterHelper {


	/**
	 * @param commandWriter
	 * @param fromUser  从前端提交的值
	 * @param fromdataBase 数据库存储的值
	 * @return 是否写成功
	 */
	public static boolean writeToDevice(CommandWriter commandWriter,
			DeviceEditParameter fromUser,DeviceEditParameter fromdataBase) {
		//抛料时间 无回复
		if(!fromUser.getThrowingTime().equals(fromdataBase.getThrowingTime())){
			String values = fromUser.getThrowingTime();
			Command command = getCommandByName("throwingTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			boolean isSeccess = commandWriter.write(commandBytes);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			if (! isSeccess) {
				return isSeccess;
			}
		}
		//间隔时间 无回复
		if(!fromUser.getIntervalTime().equals(fromdataBase.getIntervalTime())){
			String values = fromUser.getIntervalTime();
			Command command = getCommandByName("intervalTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			boolean isSeccess = commandWriter.write(commandBytes);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			if (! isSeccess) {
				return isSeccess;
			}
		}
		//手动唯料重量 无回复
		if(!fromUser.getManualFeedWeight().equals(fromdataBase.getManualFeedWeight())){
			String values = fromUser.getManualFeedWeight();
			Command command = getCommandByName("manualFeedWeight");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			boolean isSeccess = commandWriter.write(commandBytes);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			}
			if (! isSeccess) {
				return isSeccess;
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
		//第四餐目标量
		if(!fromUser.getFourthMealQuantity().equals(fromdataBase.getFourthMealQuantity())){
			String values = fromUser.getFourthMealQuantity();
			Command command = getCommandByName("fourthMealQuantity");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第四餐目标量回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第一餐开时间
		if(!fromUser.getFirstMealOpenTime().equals(fromdataBase.getFirstMealOpenTime())){
			String[] values = fromUser.getFirstMealOpenTime().split(":");
			Command command = getCommandByName("firstMealOpenTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第一餐开时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第一餐关时间
		if(!fromUser.getFirstMealCloseTime().equals(fromdataBase.getFirstMealCloseTime())){
			String[] values = fromUser.getFirstMealCloseTime().split(":");
			Command command = getCommandByName("firstMealCloseTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第一餐关时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第二餐开时间
		if(!fromUser.getSecondMealOpenTime().equals(fromdataBase.getSecondMealOpenTime())){
			String[] values = fromUser.getSecondMealOpenTime().split(":");
			Command command = getCommandByName("secondMealOpenTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第二餐开时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第二餐关时间
		if(!fromUser.getSecondMealCloseTime().equals(fromdataBase.getSecondMealCloseTime())){
			String[] values = fromUser.getSecondMealCloseTime().split(":");
			Command command = getCommandByName("secondMealCloseTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第二餐关时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第三餐开时间
		if(!fromUser.getThirdMealOpenTime().equals(fromdataBase.getThirdMealOpenTime())){
			String[] values = fromUser.getThirdMealOpenTime().split(":");
			Command command = getCommandByName("thirdMealOpenTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第三餐开时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第三餐关时间
		if(!fromUser.getThirdMealCloseTime().equals(fromdataBase.getThirdMealCloseTime())){
			String[] values = fromUser.getThirdMealCloseTime().split(":");
			Command command = getCommandByName("thirdMealCloseTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第三餐关时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第四餐开时间
		if(!fromUser.getFourthMealOpenTime().equals(fromdataBase.getFourthMealOpenTime())){
			String[] values = fromUser.getFourthMealOpenTime().split(":");
			Command command = getCommandByName("fourthMealOpenTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第四餐开时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		//第四餐关时间
		if(!fromUser.getFourthMealCloseTime().equals(fromdataBase.getFourthMealCloseTime())){
			String[] values = fromUser.getFourthMealCloseTime().split(":");
			Command command = getCommandByName("fourthMealCloseTime");
			byte[] commandBytes = compose(command, CommandType.MODIFY_SEND,values);
			byte[] response = commandWriter.writeExpectResponse(commandBytes,
					command,CommandType.MODIFY_RECEIVE);
			System.out.println("第四餐关时间回复:"+Arrays.toString(response));
			if(response == null || ! CRC16M.checkBuf(response)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param commandWriter
	 * @return
	 */
	public static  DeviceStatus requestDeviceStatus(Integer deviceId,CommandWriter commandWriter) throws DeviceStatusException{
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
		System.out.println("response0"+Arrays.toString(response0));
		byte[] response1 = commandWriter.writeExpectResponse(commandBytes1,
				command1,CommandType.READ_RECEIVE);
		System.out.println("response1"+Arrays.toString(response1));
		byte[] response2 = commandWriter.writeExpectResponse(commandBytes2,
				command2,CommandType.READ_RECEIVE);
		System.out.println("response2"+Arrays.toString(response2));
		byte[] response3 = commandWriter.writeExpectResponse(commandBytes3,
				command3,CommandType.READ_RECEIVE);
		System.out.println("response3"+Arrays.toString(response3));
		byte[] response4 = commandWriter.writeExpectResponse(commandBytes4,
				command4,CommandType.READ_RECEIVE);
		System.out.println("response4"+Arrays.toString(response4));
		byte[] response5 = commandWriter.writeExpectResponse(commandBytes5,
				command5,CommandType.READ_RECEIVE);
		System.out.println("response5"+Arrays.toString(response5));
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
			throw new DeviceStatusException(err);
		}
		DeviceStatus status = new DeviceStatus();
		status.setCurrentWeight(currentWeight);
		status.setManualStop(manualStop);
		status.setLackMaterail(lackMaterail);
		status.setLackPhase(lackPhase);
		return status;
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

	private static Command getCommandByName(String name){
		Command command = Application.getCommands().get(name);
		if (command == null) {  //commandName不对
			return null;
		}
		return command;
	}
	
	public static class DeviceStatusException extends Exception{

		public DeviceStatusException(){
			super();
		}
		
		public DeviceStatusException(String string) {
			super(string);
		}

		private static final long serialVersionUID = 2338557734619487315L;
		
	}
}
