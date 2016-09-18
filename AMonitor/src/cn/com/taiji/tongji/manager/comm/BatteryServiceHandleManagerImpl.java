/*
 * Date: 2013-7-22
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.common.model.json.AbstractProtocol;
import cn.com.taiji.common.model.json.JsonProtocol;
import cn.com.taiji.mycomm.manager.comm.sso.AbstractHttpSsoServiceHandleManager;
import cn.com.taiji.mycomm.manager.comm.sso.SsoTopicHandler;
import cn.com.taiji.mycomm.model.comm.protocol.ServiceRequestInfo;
import cn.com.taiji.mycomm.model.comm.protocol.mycomm.MycommProtocolType;
import cn.com.taiji.mycomm.model.comm.protocol.mycomm.MycommSampleTopic;
import cn.com.taiji.tongji.model.comm.HttpRequestInfo;
import cn.com.taiji.tongji.model.protocol.sample.BatteryProtocolType;
import cn.com.taiji.tongji.model.protocol.sample.SampleRequest;

/**
 * 当前系统（SAMPLE）用于处理其他系统请求（request & topic）的handler
 * 
 * @author Peream <br>
 *         Create Time：2013-7-22 下午3:32:04<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class BatteryServiceHandleManagerImpl extends AbstractHttpSsoServiceHandleManager implements
		BatteryServiceHandleManager
{
	@Autowired
	private ProtocolHandleManager protocolManager;
	private final String mycommServiceName;

	@Autowired
	public BatteryServiceHandleManagerImpl(CommParamConfig config, SsoTopicHandler topicHandler)
	{
		super(topicHandler);
		this.mycommServiceName = config.getMycommServiceName();
	}

	@Override
	protected void handleAppTopic(JsonProtocol protocol, ServiceRequestInfo requestInfo, HttpServletRequest httpRequest)
	{
		String providerName = requestInfo.getProviderName();
		if (!hasText(providerName))
		{
			logger.error("消息提供者未知");
			return;
		}
		if (providerName.equals(mycommServiceName))
		{
			handleMycommTopic(protocol);
		}
		else
		{
			logger.warn("未处理({})发来的topic信息.", providerName);
		}
	}

	private void handleMycommTopic(JsonProtocol protocol)
	{
		MycommProtocolType type = MycommProtocolType.valueOf(protocol.getType());
		String jsonStr = protocol.getJsonStr();
		switch (type)
		{
		case TOPIC_SAMPLE:
			mycommTopic(MycommSampleTopic.newInstance(jsonStr));
			break;

		default:
			logger.error("topic协议({})未处理.", protocol.getType());
			break;
		}
	}

	private void mycommTopic(MycommSampleTopic topic)
	{
		logger.debug(topic.toJson());
	}

	@Override
	protected AbstractProtocol handleService(JsonProtocol protocol, HttpServletRequest httpRequest) throws IOException
	{
		BatteryProtocolType type = BatteryProtocolType.fromValue(protocol.getType());
		AbstractProtocol request = AbstractProtocol.newInstance(type.getClazz(), protocol.getJsonStr());
		HttpRequestInfo requestInfo = HttpRequestInfo.newInstance(httpRequest);
		switch (type)
		{
		case REQ_SAMPLE:
			return protocolManager.handleSample((SampleRequest) request, requestInfo);
			// TODO other protocol
		default:
			logger.error("request协议({})未处理.", protocol.getType());
			return null;
		}
	}

}
