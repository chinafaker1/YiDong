/*
 * Date: 2015年4月9日
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

import cn.com.taiji.common.model.file.HttpFileProtocolModel;
import cn.com.taiji.common.web.BaseFileCommController;
import cn.com.taiji.tongji.manager.comm.BinFileCommHandleManager;

/**
 * 
 * @author Peream <br>
 *         Create Time：2015年4月9日 下午7:08:46<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Controller
public class BinFileServiceController extends BaseFileCommController
{
	@Autowired
	private BinFileCommHandleManager handleManager;

	@RequestMapping(value = "/common/binapi", method = RequestMethod.POST)
	public void fileRequest(@ModelAttribute HttpFileProtocolModel model, HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		logger.info("model:{}", model.toJson());
		super.handleFileComm(model, handleManager, request, response);
	}
}
