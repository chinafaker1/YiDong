/*
 * Date: 2013年8月26日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm.sso;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.taiji.mycomm.manager.comm.sso.AbstractServletSsoAuthHandler;
import cn.com.taiji.mycomm.model.comm.protocol.sso.SsoLoginResponse;
import cn.com.taiji.tongji.manager.LoginHelper;
import cn.com.taiji.tongji.manager.SessionTicketManager;
import cn.com.taiji.tongji.manager.comm.CommParamConfig;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013年8月26日 下午2:01:39<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class BatteryServletSsoAuthHandler extends AbstractServletSsoAuthHandler
{
//	private UserManager userManager;
//	private RoleResourceManager rrManager;
	private SessionTicketManager ticketManager;
	private CommParamConfig paramConfig;
	private String localWelcomeUri;
	private String ssoErrorUri;
	private String localErrorUri;

	public BatteryServletSsoAuthHandler(ServletContext context)
	{
		super(context);
	}

	@Override
	public boolean hasLogin(HttpServletRequest request)
	{
		return LoginHelper.hasLogin(request);
	}

	@Override
	public boolean appLogin(SsoLoginResponse loginRes, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
	{
//		User loginUser = userManager.saveOrUpdate(loginRes);
//		if (loginUser.getStatus() == UserStatus.INVALID)
//		{
//			response.sendRedirect(localErrorUri + "?reason=" + URLEncoder.encode("用户已经被禁用，无法完成登录", "UTF-8"));
//			return false;
//		}
//		LoginHelper.setSession(request, loginUser, rrManager.getRoleMenu(loginUser.getRole().getId()));
//		// 1.将ticketId放入到session中，并且加入SessionTicketManager，放入session表示本次登陆是通过sso完成的
//		// 2.本地的AclHandlerInterceptor将判断ticketId是否有效
//		WebUtils.setSessionAttribute(request, MySessionNames.SSO_TICKET_ID, loginRes.getTicketId());
//		ticketManager.addTicket(loginRes.getTicketId(), request.getSession().getId());
//		logger.info("通过SSO登录成功:{}", loginUser);
		return true;
	}

	@Override
	public void handleSsoError(HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException
	{
		// 和sso通信失败
		if (paramConfig.isEnableSso() && !paramConfig.isEnableLocalLogin())
			response.sendRedirect(ssoErrorUri);
		else
			response.sendRedirect(localWelcomeUri);
	}

	@Override
	public synchronized void init()
	{
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//		userManager = wac.getBean(UserManager.class);
//		rrManager = wac.getBean(RoleResourceManager.class);
//		ticketManager = wac.getBean(SessionTicketManager.class);
//		paramConfig = wac.getBean(CommParamConfig.class);
		localWelcomeUri = getServletContext().getContextPath() + "/app/common/welcome";
		ssoErrorUri = getServletContext().getContextPath() + "/app/common/ssoerror";
		localErrorUri = getServletContext().getContextPath() + "/app/common/localerror";
//		logger.info("Init StatServletSsoAuthHandler:{}", userManager != null);
	}

}
