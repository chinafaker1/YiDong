/*
 * Date: 2015年6月25日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.handler;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import cn.com.taiji.common.model.file.FileProtocolResponse;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年6月25日 下午8:30:42<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public interface BinFileServiceHandler
{
	/**
	 * 
	 * @param filename
	 * @param fs
	 * @param request
	 * @return
	 */
	public FileProtocolResponse handleRequest(String filename, InputStream fs, HttpServletRequest request);
}
