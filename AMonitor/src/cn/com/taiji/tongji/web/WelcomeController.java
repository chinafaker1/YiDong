package cn.com.taiji.tongji.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.com.taiji.tongji.manager.comm.CommParamConfig;

/**
 * 
 * @author Peream <br>
 *         Create Time：2009-6-5 下午05:39:04<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Controller
public class WelcomeController extends BaseLogController
{
//	@Autowired
//	private UserManager userManager;
//	@Autowired
//	private RoleResourceManager rrManager;
	@Autowired
	private CommParamConfig paramConfig;

//	@RequestMapping(value = "/common/welcome")
//	public String setupForm(HttpServletRequest request, @ModelAttribute("userModel") UserModel user,
//			BindingResult result, SessionStatus status, Model model)
//	{
//		logger.info("-----{}---", user.getUsername());
//		// sso前置校验
//		if (paramConfig.isEnableSso() && !paramConfig.isEnableLocalLogin())
//		{
//			model.addAttribute(MySessionNames.ERROR_MSG, "本地登录已经关闭,请使用SSO登录");
//			return "welcome";
//		}
//		// 使用cookie自动登录
//		boolean loginSucess = LoginHelper.hasLogin(request) || autoLogin(request);
//		if (!loginSucess)
//		{
//			if (!StringTools.hasText(user.getUsername()) && !StringTools.hasText(user.getPassword())) return "welcome";
//			WebUtils.setSessionAttribute(request, MySessionNames.ERROR_MSG, null);
//			new LoginValidator().validate(user, result, userManager, model);
//			if (result.hasErrors()) return "welcome";
//
//			User loginUser = userManager.findByLoginName(user.getUsername());
//			LoginHelper.setSession(request, loginUser, rrManager.getRoleMenu(loginUser.getRole().getId()));
//			logger.info("用户通过本地登录界面登录成功:{}", loginUser);
//		}
//		super.addLoginLog(request, "用户({})登录成功.", user.getUsername());
//		String uri = (String) WebTools.getSessionAttribute(request, SessionNames.LAST_URI);
//		if (!StringTools.hasText(uri) || uri.startsWith("/app/common/welcome"))
//			return "redirect:/app/index?myMenuId=index";
//		WebTools.setSessionAttribute(request, SessionNames.LAST_URI, null);
//		return "redirect:" + uri;
//	}
//
//	private boolean autoLogin(HttpServletRequest request)
//	{
//		User sessionUser = LoginHelper.getLoginUser(request);
//		if (sessionUser != null && StringTools.hasText(sessionUser.getId())) return true;
//		Cookie[] cookies = request.getCookies();
//		if (isEmpty(cookies)) return false;
//		String user = null;
//		String pass = null;
//		for (Cookie cookie : cookies)
//		{
//			if (MyFinals.COOKIE_USER.equals(cookie.getName()))
//			{
//				user = cookie.getValue();
//			}
//			else if (MyFinals.COOKIE_PASS.equals(cookie.getName()))
//			{
//				pass = cookie.getValue();
//			}
//		}
//		if (!StringTools.hasText(user) || !StringTools.hasText(pass)) return false;
//		try
//		{
//			user = URLDecoder.decode(user, UTF8);
//		}
//		catch (UnsupportedEncodingException e)
//		{
//			logger.error("", e);
//			return false;
//		}
//		user = user.replace('#', '@');
//		pass = pass.replace('#', '@');
//		logger.debug("cookie user,pass:{}\t{}", user, pass);
//		User loginUser = userManager.findByLoginName(user);
//		if (loginUser == null || loginUser.getStatus() != UserStatus.NORMAL) return false;
//		if (!LoginHelper.isPassValid(pass, loginUser)) return false;
//		WebUtils.setSessionAttribute(request, MySessionNames.ERROR_MSG, null);
//		LoginHelper.setSession(request, loginUser, rrManager.getRoleMenu(loginUser.getRole().getId()));
//		return true;
//	}
//
//	@RequestMapping(value = "/modPasswd", method = { RequestMethod.GET })
//	public String modPasswdView(@ModelAttribute("passwdModel") User passwdModel, HttpServletResponse response,
//			Model model) throws IOException
//	{
//		model.addAttribute("enableSso", paramConfig.isEnableSso());
//		if (paramConfig.isEnableSso())
//			model.addAttribute("ssoIndexUrl", SsoClientFactory.getSsoClient().getConfig().getSsoIndexUrl());
//		return "modPasswd";
//	}
//
//	@RequestMapping(value = "/modPasswd", method = { RequestMethod.POST })
//	public void modPasswdSubmit(@ModelAttribute("passwdModel") User passwdModel, HttpServletRequest request,
//			HttpServletResponse response) throws IOException
//	{
//		User user = LoginHelper.getLoginUser(request);
//		// 先验证字段的有效性
//		if (!StringTools.hasText(passwdModel.getOldPasswd()))
//		{
//			responseJson(new NoteModel(false, "原始密码不能为空").toJson(), response);
//			return;
//		}
//		if (!StringTools.hasText(passwdModel.getPasswd()))
//		{
//			responseJson(new NoteModel(false, "新密码不能为空").toJson(), response);
//			return;
//		}
//		if (!StringTools.hasText(passwdModel.getConfirm_pw()))
//		{
//			responseJson(new NoteModel(false, "确认密码不能为空").toJson(), response);
//			return;
//		}
//		else if (!passwdModel.getConfirm_pw().equals(passwdModel.getPasswd()))
//		{
//			responseJson(new NoteModel(false, "两次密码不一致").toJson(), response);
//			return;
//		}
//		String oldPasswd = passwdModel.getOldPasswd();
//		if (!LoginHelper.isPassValid(oldPasswd, user))
//		{
//			responseJson(new NoteModel(false, "原始密码错误").toJson(), response);
//			return;
//		}
//		try
//		{
//			user = userManager.modPasswd(passwdModel.getPasswd(), user.getId());
//			WebUtils.setSessionAttribute(request, SessionNames.LOGIN_USER, user.toJson());
//			responseJson(new NoteModel(true, "密码修改成功").toJson(), response);
//		}
//		catch (ManagerException e)
//		{
//			responseJson(new NoteModel(false, e.getMessage()).toJson(), response);
//			logger.error("", e);
//		}
//	}
//
//	@RequestMapping("/validatePasswd")
//	public void validatePasswd(@RequestParam("oldPasswd") String oldPasswd, HttpServletRequest request,
//			HttpServletResponse response) throws IOException
//	{
//		User user = LoginHelper.getLoginUser(request);
//		response.getWriter().print(LoginHelper.isPassValid(oldPasswd, user));
//	}
//
//	@RequestMapping(value = "/modMyself", method = { RequestMethod.GET })
//	public String modMyselfForm(HttpServletRequest request, HttpServletResponse response, Model model)
//	{
//		User user = LoginHelper.getLoginUser(request);
//		model.addAttribute("user", userManager.findById(user.getId()));
//		return "modMyself";
//	}
//
//	@RequestMapping(value = "/modMyself", method = { RequestMethod.POST })
//	public void modMyselfSubmit(HttpServletRequest request, @ModelAttribute("user") User user,
//			HttpServletResponse response) throws IOException
//	{
//		try
//		{
//
//			user.setRoleId(userManager.findById(user.getId()).getRoleId());
//			user = userManager.update(user);
//			WebUtils.setSessionAttribute(request, SessionNames.LOGIN_USER, user.toJson());
//			responseJson(new NoteModel(true, "修改个人信息成功").toJson(), response);
//		}
//		catch (JsonManagerException e)
//		{
//			responseJson(new NoteModel(false, e.getMessage()).toJson(), response);
//			logger.error("", e);
//		}
//		catch (ConstraintViolationException e)
//		{
//			responseJson(new NoteModel(false, "手机号为空或格式不正确").toJson(), response);
//			// logger.error("", e);
//		}
//	}
//
//	@RequestMapping(value = "/changeSkin", method = { RequestMethod.GET })
//	public String changeSkinForm(HttpServletRequest request, HttpServletResponse response, Model model)
//	{
//		String skin = "-blue";
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies)
//		{
//			if ("skin".equals(cookie.getName()))
//			{
//				skin = cookie.getValue();
//			}
//		}
//
//		model.addAttribute("skin", skin);
//		return "changeSkin";
//	}
//
//	@RequestMapping(value = "/changeSkin", method = { RequestMethod.POST })
//	public void changeSkinSubmit(HttpServletRequest request, @RequestParam("skin") String skin,
//			HttpServletResponse response) throws IOException
//	{
//		Cookie cookie = new Cookie("skin", skin);
//		if ("https".equalsIgnoreCase(request.getScheme())) cookie.setSecure(true);
//		response.addCookie(cookie);
//		addSuccess(response, "换肤成功");
//	}
}
