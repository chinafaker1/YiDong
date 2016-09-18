/*
 * Date: 2015年6月25日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.client;


/**
 * 
 * 
 * @author Peream <br>
 *         Create Time：2015年9月2日 下午1:48:51<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class ApiRequestException extends RuntimeException
{
	private static final long serialVersionUID = -1035562948701925560L;
	private int errCode;

	public ApiRequestException(String message, int errCode)
	{
		super(message + ":" + errCode);
		this.errCode = errCode;
	}

	public ApiRequestException(String message, Throwable cause, int errCode)
	{
		super(message + ":" + errCode, cause);
		this.errCode = errCode;
	}

	public int getErrCode()
	{
		return errCode;
	}

	public void setErrCode(int errCode)
	{
		this.errCode = errCode;
	}

}
