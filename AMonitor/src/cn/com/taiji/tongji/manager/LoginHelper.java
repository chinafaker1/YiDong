package cn.com.taiji.tongji.manager;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;

import cn.com.taiji.common.pub.SecurityUtil;
import cn.com.taiji.common.pub.SecurityUtil.HashType;
import cn.com.taiji.common.pub.TimeTools;
import cn.com.taiji.tongji.model.MySessionNames;

/**
 * 
 * @author Peream <br>
 *         Create Time：2010-11-15 上午11:03:11<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class LoginHelper
{
	protected static Logger logger = LoggerFactory.getLogger(LoginHelper.class);

	public static boolean hasLogin(HttpServletRequest request)
	{
//		User user = getLoginUser(request);
//		return (user != null && StringTools.hasText(user.getId()));
		return true;
	}

	public static String getLoginIP(HttpServletRequest request)
	{
		return (String) WebUtils.getSessionAttribute(request, MySessionNames.LOGIN_IP);
	}

	public static Calendar getLoginTime(HttpServletRequest request)
	{
		String str = (String) WebUtils.getSessionAttribute(request, MySessionNames.LOGIN_TIME);
		return str == null ? null : TimeTools.getCalendar(str);
	}

//	public static User getLoginUser(HttpServletRequest request)
//	{
//		String str = (String) WebUtils.getSessionAttribute(request, MySessionNames.LOGIN_USER);
//		try
//		{
//			return str == null ? null : JsonTools.json2Object(str, User.class);
//		}
//		catch (IOException e)
//		{
//			logger.error("", e);
//			return null;
//		}
//	}

//	public static AppResource getCurrentResource(HttpServletRequest request)
//	{
//		String str = (String) WebUtils.getSessionAttribute(request, MySessionNames.CURRENT_RESOURCE);
//		try
//		{
//			if (str != null) return JsonTools.json2Object(str, AppResource.class);
//		}
//		catch (IOException e)
//		{
//			logger.error("", e);
//		}
//		return null;
//	}

//	public static List<RoleMenu> getCurrentRoleMenu(HttpServletRequest request)
//	{
//		String str = (String) WebUtils.getSessionAttribute(request, MySessionNames.ROLE_MENU);
//		try
//		{
//			return str == null ? new ArrayList<RoleMenu>() : JsonTools.json2List(str, RoleMenu.class);
//		}
//		catch (IOException e)
//		{
//			logger.error("", e);
//			return new ArrayList<RoleMenu>();
//		}
//	}

//	public static void setSession(HttpServletRequest request, User loginUser, List<RoleMenu> menus)
//	{
//		AssertUtil.notNull(loginUser);
//		String ip = request.getRemoteHost();
//		if ("0:0:0:0:0:0:0:1".equals(ip)) ip = "127.0.0.1";
//		WebUtils.setSessionAttribute(request, MySessionNames.LOGIN_IP, ip);
//		WebUtils.setSessionAttribute(request, MySessionNames.LOGIN_TIME, TimeTools.toTimeStr());
//		WebUtils.setSessionAttribute(request, MySessionNames.LOGIN_USER, loginUser.toJson());
//		WebUtils.setSessionAttribute(request, MySessionNames.CURRENT_LOGIN_NAME, loginUser.getLoginName());
//		try
//		{
//			String menuJson = JsonTools.toJsonStr(menus);
//			WebUtils.setSessionAttribute(request, MySessionNames.ROLE_MENU, menuJson);
//			logger.debug("role menu:{}", menuJson);
//		}
//		catch (IOException e)
//		{
//			logger.error("", e);
//		}
//		logger.debug("Set session attributes after login:{}", loginUser);
//	}

	public static String encryPwd(String pass)
	{
		return SecurityUtil.encryptStr(pass, HashType.SHA_1, true);
	}

//	public static boolean isPassValid(String pass, User user)
//	{
//		if (user == null) return false;
//		String secPasswd = SecurityUtil.encryptStr(pass, HashType.SHA_1, true);
//		return secPasswd.equals(user.getPasswd());
//	}
}
