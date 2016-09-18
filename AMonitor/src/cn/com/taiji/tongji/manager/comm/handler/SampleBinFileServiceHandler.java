/*
 * Date: 2015年9月22日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.handler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.com.taiji.common.manager.pub.FileHelper;
import cn.com.taiji.common.model.file.FileProtocolConstant;
import cn.com.taiji.common.model.file.FileProtocolResponse;
import cn.com.taiji.common.pub.FileCopyTools;
import cn.com.taiji.tongji.model.comm.protocol.SampleServiceType;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年9月22日 下午3:01:24<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class SampleBinFileServiceHandler extends AbstractBinFileServiceHandler
{
	public SampleBinFileServiceHandler()
	{
		super(SampleServiceType.SAMPLE);
	}

	@Override
	protected FileProtocolResponse handleInternal(String filename, InputStream fs, HttpServletRequest request)
			throws ServiceHandleException
	{
		int ran = new Random().nextInt(10);
		if (ran > 8) return new FileProtocolResponse(ran * 100, "错误示例");
		FileProtocolResponse rs = new FileProtocolResponse();
		// 服务端处理程序决定是否要生成临时文件，生成临时文件时记得设置response中的tmpFile属性
		try
		{
			int size = fs.available();
			logger.info("the request size is:{},parse the request here..(in sample,just save it at tmp path)", size);
			File reqFile = generateTmpFile(filename);
			FileCopyTools.copy(fs, new FileOutputStream(reqFile));
			ran = new Random().nextInt(2);
			String resFileName = ran > 0 ? "lib/ojdbc6.jar" : "jsp/welcome.jsp";
			File resFile = new File(FileHelper.getWebappPath() + "/WEB-INF/" + resFileName);
			long resSize = resFile.length();
			rs.setFilename("RESPONSE_" + filename + resFileName.replace("/", "_"));
			if (resSize > 0 && resSize < FileProtocolConstant.IN_MEM_MAXSIZE.getSize())
			{
				byte[] bytes = FileCopyTools.copyToByteArray(resFile);
				rs.setBinFile(new ByteArrayInputStream(bytes));
			}
			else
			{
				File file = generateTmpFile(filename);
				FileCopyTools.copy(new FileInputStream(resFile), new FileOutputStream(file));
				rs.setBinFile(new FileInputStream(file));
				rs.setTmpFile(file);// 设置临时文件，父类中会自动删除
			}
		}
		catch (IOException e)
		{
			logger.error("", e);
			throw new RuntimeException(e.getMessage());
		}
		return rs;
	}

}
