/*
 * Date: 2014年5月13日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.common.manager.net.http.AbstractHttpJsonCommHandleManager;
import cn.com.taiji.common.manager.net.http.HttpJsonCommHandleManager;
import cn.com.taiji.common.model.json.AbstractProtocol;
import cn.com.taiji.common.model.json.JsonProtocol;
import cn.com.taiji.tongji.model.comm.HttpRequestInfo;
import cn.com.taiji.tongji.model.protocol.sample.BatteryProtocolType;
import cn.com.taiji.tongji.model.protocol.sample.SampleRequest;

/**
 * 
 * @author Peream <br>
 *         Create Time：2014年5月13日 下午12:05:16<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class ApiCommHandleManager extends AbstractHttpJsonCommHandleManager implements HttpJsonCommHandleManager
{
	@Autowired
	private ProtocolHandleManager protocolManager;

	@Override
	protected JsonProtocol handleRequest(JsonProtocol protocol, HttpServletRequest httpRequest) throws IOException
	{
		BatteryProtocolType type = BatteryProtocolType.fromValue(protocol.getType());
		AbstractProtocol request = AbstractProtocol.newInstance(type.getClazz(), protocol.getJsonStr());
		// ip之类信息封装好直接给业务用,以后还可以扩展别的
		HttpRequestInfo requestInfo = HttpRequestInfo.newInstance(httpRequest);
		// 1.对于需要进行身份认证的请求【if (request instanceof
		// AbstractTicketProtocol)】统一进行安全验证，安全验证不通过返回SessionInvalidResponse,
		// app在接收返回时，对于SessionInvalidResponse这个返回也统一处理， 直接跳转回首页并记得清除app客户端中的ticketId【可参考HZ.apply】
		// 2.一般提供给其他服务器使用的，因为认为对方是可信任的，此处只要加个ip校验防止其他人访问就行//TODO
		AbstractProtocol res = handleRequest(type, request, requestInfo);// 业务功能不再关心安全验证，只考虑业务场景就行
		if (res == null) throw new IOException("还未实现该协议的处理:" + protocol.getType());
		// ****如果有需要，可以对返回结果统一进行校验，此处校验的目的是对返回结果做归属性校验，加强安全【参考HZ.apply】
		logger.debug("res------------{}", res.toJsonProtocol());
		return res.toJsonProtocol();
	}

	/**
	 * 此处处理具体的协议，只关心业务
	 * 
	 * @param type
	 * @param request
	 * @param requestInfo
	 * @return
	 * @throws IOException
	 */
	private AbstractProtocol handleRequest(BatteryProtocolType type, AbstractProtocol request,
			HttpRequestInfo requestInfo) throws IOException
	{
		switch (type)
		{
		case REQ_SAMPLE:
			return protocolManager.handleSample((SampleRequest) request, requestInfo);
			// TODO
		default:
			return null;
		}
	}

}
