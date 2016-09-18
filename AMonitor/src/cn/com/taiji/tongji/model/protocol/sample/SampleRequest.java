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
public class SampleRequest extends AbstractProtocol
{
	private String name;

	public SampleRequest()
	{
		super(BatteryProtocolType.REQ_SAMPLE.name());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static SampleRequest newInstance(String jsonStr)
	{
		return newInstance(SampleRequest.class, jsonStr);
	}
}
