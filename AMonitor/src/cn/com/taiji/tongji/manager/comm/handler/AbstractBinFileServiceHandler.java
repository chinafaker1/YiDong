/*
 * Date: 2015年6月25日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.com.taiji.common.entity.BaseEntity;
import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.manager.pub.FileHelper;
import cn.com.taiji.common.manager.pub.ZipHelper;
import cn.com.taiji.common.model.dao.ResultConverter;
import cn.com.taiji.common.model.file.FileProtocolResponse;
import cn.com.taiji.common.pub.CollectionTools;
import cn.com.taiji.common.pub.FileCopyTools;
import cn.com.taiji.common.pub.file.FileTools;
import cn.com.taiji.common.pub.json.JsonTools;
import cn.com.taiji.tongji.model.comm.FileProtocolError;
import cn.com.taiji.tongji.model.comm.protocol.SampleServiceType;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年6月25日 下午8:31:06<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractBinFileServiceHandler extends AbstractManager implements BinFileServiceHandler
{
	protected static final String ENCODING = "UTF-8";
	protected final SampleServiceType serviceType;

	protected AbstractBinFileServiceHandler(SampleServiceType serviceType)
	{
		this.serviceType = serviceType;
	}

	protected <F, T> List<T> convertList(List<F> fromList, ResultConverter<F, T> converter)
	{
		return CollectionTools.convertList(fromList, converter);
	}

	protected <E> List<List<E>> subList(List<E> list, int pageSize)
	{
		return CollectionTools.subList(list, pageSize);
	}

	protected final void generateZipFile(File zipFile, String resPrefix, List<List<String>> lists)
	{
		generateZipFile(zipFile, resPrefix, lists, ".json");
	}

	protected final void generateZipFile(File zipFile, String resPrefix, List<List<String>> lists, String suffix)
	{
		String sourcePath = FileHelper.getTmpPath() + "/" + UUID.randomUUID().toString();
		FileHelper.mkdirs(sourcePath);
		try
		{
			for (int i = 0; i < lists.size(); i++)
			{
				File file = new File(sourcePath + "/" + resPrefix + "_" + i + suffix);
				FileCopyTools.writeLines(new FileOutputStream(file), lists.get(i), ENCODING);
			}
			File source = new File(sourcePath);
			ZipHelper.zip(source, zipFile);
			FileHelper.deleteDirectory(sourcePath);
		}
		catch (IOException e)
		{
			logger.error("", e);
			if (zipFile.exists() && !zipFile.delete())
				logger.error("delete zip file error:{}", zipFile.getAbsolutePath());
		}
	}

	@Override
	public final FileProtocolResponse handleRequest(String filename, InputStream fs, HttpServletRequest request)
	{
		try
		{
			boolean b = serviceType.getReqNamePattern().matcher(filename).matches();
			if (!b) return FileProtocolError.REQ_NAME_ERR.newResponse(filename);
			return handleInternal(filename, fs, request);
		}
		catch (ServiceHandleException e)
		{
			logger.error("", e);
			return e.toResponse();
		}
	}

	/**
	 * 实现请求的具体响应
	 * 
	 * @param filename
	 * @param fs
	 * @param request
	 * @return
	 * @throws ServiceHandleException
	 */
	protected abstract FileProtocolResponse handleInternal(String filename, InputStream fs, HttpServletRequest request)
			throws ServiceHandleException;

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
			return new ByteArrayInputStream(result.toJson().getBytes(ENCODING));
		}
		catch (UnsupportedEncodingException e)
		{
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 集合类型的响应结果转成inputstrem，每个元素一行
	 * 
	 * @param list
	 * @return
	 */
	protected final ByteArrayInputStream result2Input(List<? extends BaseEntity> list)
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

	protected <T extends BaseEntity> T toRequest(Class<T> clazz, InputStream in) throws ServiceHandleException
	{
		try
		{
			String jsonStr = FileCopyTools.copyToStr(in, "UTF-8");
			return JsonTools.json2Object(jsonStr, clazz);
		}
		catch (Exception e)
		{
			logger.error("", e);
			throw new ServiceHandleException("请求的JSON格式不正确.", e, FileProtocolError.REQ_DATA_ERR);
		}
	}

	/**
	 * 生成响应结果
	 * 
	 * @param filename
	 * @param result
	 * @return
	 */
	protected FileProtocolResponse newSuccessResponse(String filename, BaseEntity result)
	{
		FileProtocolResponse rs = new FileProtocolResponse();
		rs.setFilename(filename);
		rs.setBinFile(result2Input(result));
		return rs;
	}

	/**
	 * 根据响应文件反馈结果(默认删除临时文件)
	 * 
	 * @param resFile
	 *            响应文件
	 * @param filename
	 *            文件名，如果为空，使用resFile的名字
	 * @return
	 * @throws ServiceHandleException
	 */
	protected FileProtocolResponse newSuccessResponse(File resFile, String filename) throws ServiceHandleException
	{
		return newSuccessResponse(resFile, filename, true);
	}

	/**
	 * 根据响应文件反馈结果(使用resFile的名字)
	 * 
	 * @param resFile
	 *            响应文件
	 * @param deleteTmpFile
	 *            是否删除临时文件
	 * @return
	 * @throws ServiceHandleException
	 */
	protected FileProtocolResponse newSuccessResponse(File resFile, boolean deleteTmpFile)
			throws ServiceHandleException
	{
		return newSuccessResponse(resFile, null, deleteTmpFile);
	}

	/**
	 * 根据响应文件反馈结果
	 * 
	 * @param resFile
	 *            响应文件
	 * @param filename
	 *            文件名，如果为空，使用resFile的名字
	 * @param deleteTmpFile
	 *            是否删除临时文件
	 * @return
	 * @throws ServiceHandleException
	 */
	protected FileProtocolResponse newSuccessResponse(File resFile, String filename, boolean deleteTmpFile)
			throws ServiceHandleException
	{
		try
		{
			FileProtocolResponse rs = new FileProtocolResponse();
			String myFilename = hasText(filename) ? filename : resFile.getName();
			rs.setFilename(myFilename);
			rs.setBinFile(new FileInputStream(resFile));
			rs.setTmpFile(resFile);//
			rs.setDeleteTmpFile(deleteTmpFile);
			return rs;
		}
		catch (IOException e)
		{
			logger.error("", e);
			return FileProtocolError.RES_FILE_NOT_EXIST.newResponse(resFile.getAbsolutePath());
		}
	}

	/**
	 * 使用UUID在临时目录下生成一个文件
	 * 
	 * @param filename
	 * @return
	 */
	protected File generateTmpFile(String filename)
	{
		File rs = new File(FileHelper.getTmpPath() + "/" + FileTools.generateUUIDName(filename));
		return rs;
	}

	/**
	 * 每行一条记录生成input（ByteArrayInputStream）
	 * 
	 * @param filename
	 * @param list
	 * @return
	 */
	protected FileProtocolResponse newSuccessResponse(String filename, List<? extends BaseEntity> list)
	{
		FileProtocolResponse rs = new FileProtocolResponse();
		rs.setFilename(filename);
		rs.setBinFile(result2Input(list));
		return rs;
	}

	/**
	 * 取得当前时间<code>yyyyMMddHHmmss</code>格式的字符串
	 * 
	 * @return
	 */
	protected String getTimeStr()
	{
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	/**
	 * 取得当前时间<code>yyyyMMddHH</code>格式的字符串
	 * 
	 * @return
	 */
	protected String getHourStr()
	{
		return new SimpleDateFormat("yyyyMMddHH").format(new Date());
	}

	/**
	 * 取得当前时间<code>yyyyMM</code>格式的字符串
	 * 
	 * @return
	 */
	protected String getMonthStr()
	{
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
}
