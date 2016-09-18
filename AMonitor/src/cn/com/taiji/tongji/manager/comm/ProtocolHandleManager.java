/*
 * Date: 2014年9月16日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import cn.com.taiji.tongji.model.comm.HttpRequestInfo;
import cn.com.taiji.tongji.model.protocol.sample.SampleRequest;
import cn.com.taiji.tongji.model.protocol.sample.SampleResponse;

/**
 * 
 * @author Peream <br>
 *         Create Time：2014年9月16日 下午8:48:10<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public interface ProtocolHandleManager
{
	/**
	 * 处理sample请求
	 * 
	 * @param request
	 * @param requestInfo
	 * @return
	 */
	public SampleResponse handleSample(SampleRequest request, HttpRequestInfo requestInfo);
}
