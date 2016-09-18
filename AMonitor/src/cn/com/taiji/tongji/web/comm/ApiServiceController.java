/*
 * Date: 2014年5月13日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.web.comm;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.taiji.common.model.json.JsonProtocol;
import cn.com.taiji.common.web.BaseJsonCommController;
import cn.com.taiji.tongji.manager.comm.ApiCommHandleManager;

/**
 * 对外提供API服务
 * 
 * @author Peream <br>
 *         Create Time：2014年9月17日 下午3:50:49<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Controller
public class ApiServiceController extends BaseJsonCommController
{
	@Autowired
	private ApiCommHandleManager handleManager;

	@RequestMapping(value = "/common/api", method = RequestMethod.POST)
	public void appRequest(@ModelAttribute JsonProtocol protocol, HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		// response.setHeader("Access-Control-Allow-Origin","*");
		super.handleJsonComm(protocol, handleManager, request, response);
	}
	
	
}
