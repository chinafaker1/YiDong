/*
 * Date: 2013-5-29
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.config.manager;

import cn.com.taiji.tongji.model.CronPara;

/**
 * 定时任务在此处配置
 * 
 * @author Peream <br>
 *         Create Time：2013-5-29 上午11:35:05<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 * @see {@link TaskInfo}
 */
public enum TaskInfo
{
	SAMPLE("示例任务", TaskGroup.SAMPLE, "sample", 60, false) {},
	SYS_INFO("系统配置定时更新", TaskGroup.SYSTEM, "sysInfo", -1, true) {},
	SSO_TICKET("清除过期的SSO ticket", TaskGroup.SYSTEM, "ssoTicket", -1, true) {},
	;
	private String info;
	private final String cronParaProperyName;
	private final int maxExecSencods;// <0的任务表示所有节点都要同时运行
	private TaskGroup group;
	private boolean autoStart;

	private TaskInfo(String info, TaskGroup group, String cronParaProperyName, int maxExecSeconds, boolean autoStart)
	{
		this.info = info;
		this.group = group;
		this.cronParaProperyName = cronParaProperyName;
		this.maxExecSencods = maxExecSeconds;
		this.autoStart = autoStart;
	}

	public boolean isAutoStart()
	{
		return autoStart;
	}

	public TaskGroup getGroup()
	{
		return group;
	}

	public String getCron(CronPara para)
	{
		return para.getPropertyValue(String.class, cronParaProperyName);
	}

	public void setCron(CronPara para, String cron)
	{
		para.setPropertyValue(cronParaProperyName, cron);
	}

	public String getCronParaProperyName()
	{
		return cronParaProperyName;
	}

	public int getMaxExecSencods()
	{
		return maxExecSencods;
	}

	public String getInfo()
	{
		return info;
	}

}
