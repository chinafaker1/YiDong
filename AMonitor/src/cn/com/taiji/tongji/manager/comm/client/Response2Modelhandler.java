/*
 * Date: 2015年7月17日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.client;

import java.io.InputStream;

import cn.com.taiji.common.entity.BaseEntity;
import cn.com.taiji.common.pub.FileCopyTools;
import cn.com.taiji.common.pub.json.JsonTools;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年7月17日 下午8:52:21<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class Response2Modelhandler<E extends BaseEntity> extends AbstractApiResponseHandler<E>
{
	private final Class<E> clazz;

	public Response2Modelhandler(Class<E> clazz)
	{
		this.clazz = clazz;
	}

	@Override
	protected E handleInternal(int sc, String resName, InputStream in, String errorMsg) throws ApiRequestException
	{
		logger.info("response filename:{}", resName);
		try
		{
			String jsonStr = FileCopyTools.copyToStr(in, "UTF-8");
			return JsonTools.json2Object(jsonStr, clazz);
		}
		catch (Exception e)
		{
			logger.error("", e);
			return null;
		}
	}

}
