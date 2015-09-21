package fishpond.job;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fishpond.app.Application;
import fishpond.app.CommandWriter;
import fishpond.job.task.AskDeviceForWeight;

@Component
public class RefreshWeightJob {
	
	@Autowired
	private AskDeviceForWeight askDeviceForWeight;

	/**
	 * 20秒固定刷新
	 */
	@Scheduled(initialDelayString="${task.initial_delay}",fixedRateString="${task.fixed_rate}")
	public void refresh(){
//		System.out.println("refreshing...\t"+new Date());
		Map<Integer, CommandWriter> map = Application.MANDATORS;
		Set<Entry<Integer, CommandWriter>> set = map.entrySet();
		for (Entry<Integer, CommandWriter> entry : set) {
			askDeviceForWeight.task(entry.getKey(), entry.getValue());
		}
	}
}
