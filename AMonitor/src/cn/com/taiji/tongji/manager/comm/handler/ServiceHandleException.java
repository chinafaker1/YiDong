/*
 * Date: 2015年6月25日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.handler;

import cn.com.taiji.common.manager.ManagerException;
import cn.com.taiji.common.model.file.FileProtocolResponse;
import cn.com.taiji.tongji.model.comm.FileProtocolError;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年6月25日 下午8:46:43<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class ServiceHandleException extends ManagerException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3039557903232247146L;
	private int errCode;

	public ServiceHandleException(String message, int errCode)
	{
		super(message);
		this.errCode = errCode;
	}

	public ServiceHandleException(String message, Throwable cause, FileProtocolError error)
	{
		this(message, cause, error.getCode());
	}

	public ServiceHandleException(String message, Throwable cause, int errCode)
	{
		super(message, cause);
		this.errCode = errCode;
	}

	/**
	 * @see {@link FileProtocolError#getCode()}
	 * @return
	 */
	public int getErrCode()
	{
		return errCode;
	}

	public void setErrCode(int errCode)
	{
		this.errCode = errCode;
	}

	public FileProtocolResponse toResponse()
	{
		return new FileProtocolResponse(errCode, getMessage());
	}
}
