package fishpond.job.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import fishpond.app.CommandWriter;
import fishpond.app.DeviceHelper;
import fishpond.app.DeviceHelper.DeviceReadException;
import fishpond.dao.DeviceStatusDao;

/**
 * 读取设备的实时重量，并存入数据库中
 * @author zweiwei1987@gmail.com
 */
@Component("askDeviceForWeight")
public class AskDeviceForWeight {

	@Resource(name="deviceStatusDaoImpl")
	private DeviceStatusDao deviceStatusDao;
	
	@Async
	public void task(int deviceId,CommandWriter commandWriter){
//		System.out.println(Thread.currentThread().getName()+" running task...\t deviceId="+deviceId+"\t"+new Date());
		try {
			int weight= DeviceHelper.queryCurrentWeight(deviceId,commandWriter);
			deviceStatusDao.updateWeight(deviceId,weight);
		} catch (DeviceReadException e) {
			System.out.println("定时任务读取设备出错："+e.getMessage());
		}
//		System.out.println("end task...\t deviceId="+deviceId+"\t"+new Date());
	}
}
