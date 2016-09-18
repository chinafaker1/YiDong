/*
 * Date: 2015年7月1日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.client;

import java.io.InputStream;

import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.manager.net.http.FileProtocolResponseHandler;
import cn.com.taiji.common.model.file.FileProtocolResponse;

/**
 * 出现自定义异常时，返回null
 * 
 * @author Peream <br>
 *         Create Time：2015年7月1日 下午5:56:52<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractApiResponseHandler<T> extends AbstractManager implements FileProtocolResponseHandler<T>
{
	@Override
	public final T handleResponse(int sc, String filename, InputStream in, String errorMsg) throws ApiRequestException
	{
		if (sc >= FileProtocolResponse.MIN_ERROR_CODE) throw new ApiRequestException(errorMsg, sc);
		return handleInternal(sc, filename, in, errorMsg);
	}

	protected abstract T handleInternal(int sc, String filename, InputStream in, String errorMsg)
			throws ApiRequestException;
}
