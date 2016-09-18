/*
 * Date: 2015年7月17日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.com.taiji.common.pub.FileCopyTools;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年7月17日 下午8:37:57<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class Response2FileHandler extends AbstractApiResponseHandler<File>
{
	private final String savePath;

	public Response2FileHandler(String savePath)
	{
		this.savePath = savePath;
	}

	@Override
	protected File handleInternal(int sc, String resName, InputStream in, String errorMsg) throws ApiRequestException
	{
		logger.debug("response filename:{}", resName);
		File rs = new File(savePath + "/" + resName);
		try
		{
			FileCopyTools.copy(in, new FileOutputStream(rs));
			return rs;
		}
		catch (IOException e)
		{
			logger.error("", e);
			throw new ApiRequestException(e.getMessage(), sc);
		}
	}

}
