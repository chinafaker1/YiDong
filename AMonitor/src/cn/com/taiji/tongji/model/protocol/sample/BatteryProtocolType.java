/*
 * Date: 2013-6-17
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.model.protocol.sample;

import cn.com.taiji.common.model.json.AbstractProtocol;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013-6-17 下午4:18:02<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public enum BatteryProtocolType
{
	REQ_SAMPLE("SAMPLE的示例请求", SampleRequest.class) {},
	RES_SAMPLE("SAMPLE的示例返回", SampleResponse.class) {},
	TOPIC_SAMPLE("SAMPLE的TOPIC示例", SampleTopic.class) {},
	UNKNOWN("unknown", null) {},
	;
	private String value;
	private Class<? extends AbstractProtocol> clazz;

	private BatteryProtocolType(String value, Class<? extends AbstractProtocol> clazz)
	{
		this.value = value;
		this.clazz = clazz;
	}

	public static BatteryProtocolType fromValue(String value)
	{
		try
		{
			return valueOf(value);
		}
		catch (Exception e)
		{
			System.err.println(value + " can not convert to BatteryProtocolType's type.");
			return UNKNOWN;
		}
	}

	public String getValue()
	{
		return value;
	}

	public Class<? extends AbstractProtocol> getClazz()
	{
		return clazz;
	}
}
