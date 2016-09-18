/*
 * Date: 2013-5-2
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.model.protocol.sample;

import cn.com.taiji.common.model.json.AbstractProtocol;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013-5-2 上午11:44:22<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class SampleTopic extends AbstractProtocol
{
	private String name;

	public SampleTopic()
	{
		super(BatteryProtocolType.TOPIC_SAMPLE.name());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static SampleTopic newInstance(String jsonStr)
	{
		return newInstance(SampleTopic.class, jsonStr);
	}
}
