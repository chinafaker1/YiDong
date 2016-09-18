/*
 * Date: 2013年10月12日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.quartz;

import org.springframework.stereotype.Service;

import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.manager.quartz.TaskListener;
import cn.com.taiji.common.model.quartz.TaskEvent;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013年10月12日 下午7:11:00<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class TaskListenerImpl extends AbstractManager implements TaskListener
{
//	@Autowired
//	private ScheduleLogRepo logRepo;

	@Override
	public void taskBegin(TaskEvent event)
	{
		logger.debug("task ({}) begin", event.toJson());
	}

	@Override
	public void taskFinish(TaskEvent event)
	{
//		ScheduleLog log = new ScheduleLog();
//		log.setStartTime(event.getBeginTime());
//		log.setEndTime(event.getFinishTime());
//		log.setBySystem(event.isBySystem());
//		log.setCurrentCron(event.getCurrentCron());
//		log.setTaskName( event.getTaskName());
//		log.setExecTime(event.getFinishTime().getTimeInMillis() - event.getBeginTime().getTimeInMillis());
//		logRepo.save(log);
		logger.debug("task ({}) finished", event.toJson());
	}

}
