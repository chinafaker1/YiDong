/*
 * Date: 2014年10月15日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.web.acl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hsqldb.rights.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.collect.Lists;

import cn.com.taiji.common.pub.json.JsonTools;
import cn.com.taiji.tongji.manager.LoginHelper;
import cn.com.taiji.tongji.model.acl.HasButtonModel;
import cn.com.taiji.tongji.web.MyBaseController;

/**
 * 
 * @author Peream <br>
 *         Create Time：2014年10月15日 下午6:19:44<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Controller
public class RoleResourceController extends MyBaseController
{

	@RequestMapping("/acl/hasbutton")
	public void hasButton(@RequestParam("uri") String uri, HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
//		User user = LoginHelper.getLoginUser(request);
		HasButtonModel rs = new HasButtonModel();
		responseJson(rs.toJson(), request, response);
	}

	@RequestMapping("/acl/hasbuttons")
	public void hasButtons(@RequestParam("uris") String[] uris, HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		List<HasButtonModel> rs = Lists.newArrayList();
		responseJson(JsonTools.toJsonStr(rs), request, response);
	}
}
