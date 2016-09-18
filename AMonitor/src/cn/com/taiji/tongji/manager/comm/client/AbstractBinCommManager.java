/*
 * Date: 2015年9月18日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.com.taiji.common.entity.BaseEntity;
import cn.com.taiji.common.manager.net.http.AbstractFileCommManager;
import cn.com.taiji.common.model.file.FileProtocolRequest;
import cn.com.taiji.common.pub.SecurityUtil;
import cn.com.taiji.common.pub.SecurityUtil.HashType;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年9月18日 下午5:00:57<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractBinCommManager extends AbstractFileCommManager
{
	private final String url;
	private int connTimeout = 10000;
	private int soTimeout = -1;

	protected AbstractBinCommManager(String url)
	{
		super();
		this.url = url;
	}

	/**
	 * 设置连接超时毫秒数，默认10000
	 * 
	 * @param connTimeout
	 */
	public void setConnTimeout(int connTimeout)
	{
		this.connTimeout = connTimeout;
	}

	/**
	 * 设置响应超时毫秒数，默认-1（不超时）
	 * 
	 * @param soTimeout
	 */
	public void setSoTimeout(int soTimeout)
	{
		this.soTimeout = soTimeout;
	}

	protected <T> T filePost(String reqName, BaseEntity queryRequest, AbstractApiResponseHandler<T> handler)
			throws IOException, ApiRequestException
	{
		return filePost(reqName, true, queryRequest, handler);
	}

	protected <T> T filePost(String reqName, boolean enableGzip, BaseEntity queryRequest,
			AbstractApiResponseHandler<T> handler) throws IOException, ApiRequestException
	{
		return filePost(reqName, enableGzip, queryRequest, true, handler);
	}

	protected <T> T filePost(String reqName, boolean enableGzip, BaseEntity queryRequest, boolean enableMd5,
			AbstractApiResponseHandler<T> handler) throws IOException, ApiRequestException
	{
		FileProtocolRequest request = newRequest(reqName, enableGzip, queryRequest, enableMd5);
		return super.filePost(url, connTimeout, request, soTimeout, handler);
	}

	protected FileProtocolRequest newRequest(String filename, boolean enableGzip, BaseEntity queryRequest,
			boolean enableMd5) throws IOException
	{
		return newRequest(filename, enableGzip, result2Input(queryRequest), enableMd5);
	}

	protected FileProtocolRequest newRequest(String filename, boolean enableGzip,
			List<? extends BaseEntity> queryRequest, boolean enableMd5) throws IOException
	{
		return newRequest(filename, enableGzip, data2Input(queryRequest), enableMd5);
	}

	/**
	 * 组装请求
	 * 
	 * @param filename
	 *            文件名
	 * @param enableGzip
	 *            是否启用gzip压缩 {@link FileProtocolRequest#isEnableGzip()}
	 * @param in
	 *            二进制流
	 * @param enableMd5
	 *            是否启用MD5校验{@link FileProtocolRequest#setMd5(String)}
	 * @return
	 * @throws IOException
	 */
	protected FileProtocolRequest newRequest(String filename, boolean enableGzip, ByteArrayInputStream in,
			boolean enableMd5) throws IOException
	{
		FileProtocolRequest rs = new FileProtocolRequest();
		rs.setFilename(filename);
		rs.setEnableGzip(enableGzip);
		if (enableMd5)
		{
			String md5 = SecurityUtil.hash(in, HashType.MD5, true);
			rs.setMd5(md5);
			in.reset();
		}
		rs.setBinFile(in);
		return rs;
	}

	/**
	 * 响应结果转成inputstream
	 * 
	 * @param result
	 * @return
	 */
	protected final ByteArrayInputStream result2Input(BaseEntity result)
	{
		try
		{
			return new ByteArrayInputStream(result.toJson().getBytes("UTF-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 集合类型的数据转成inputstrem，每个元素一行
	 * 
	 * @param list
	 * @return
	 */
	protected final ByteArrayInputStream data2Input(List<? extends BaseEntity> list)
	{
		try
		{
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			for (BaseEntity entity : list)
			{
				out.write(entity.toJson().getBytes("UTF-8"));
				out.write('\n');
			}
			return new ByteArrayInputStream(out.toByteArray());
		}
		catch (Exception e)
		{
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 返回当前时间的<code>yyyyMMddHHmmss</code>格式字符串
	 * 
	 * @return
	 */
	protected String getTimeStr()
	{
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * 返回当前时间的<code>yyyyMMddHH</code>格式字符串
	 * 
	 * @return
	 */
	protected String getHourStr()
	{
		return new SimpleDateFormat("yyyyMMddHH").format(new Date());
	}
}
