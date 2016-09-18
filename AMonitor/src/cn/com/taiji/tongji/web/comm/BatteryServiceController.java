/*
 * Date: 2013-6-17
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
import cn.com.taiji.mycomm.model.comm.protocol.ServiceRequestInfo;
import cn.com.taiji.mycomm.web.BaseServiceController;
import cn.com.taiji.tongji.manager.comm.BatteryServiceHandleManager;

/**
 * sample bus service
 * 
 * @author Peream <br>
 *         Create Time：2013-6-17 下午3:31:09<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Controller
public class BatteryServiceController extends BaseServiceController
{
	@Autowired
	private BatteryServiceHandleManager handleManager;

	@RequestMapping(value = "/common/service", method = RequestMethod.POST)
	public void handleJsonComm(@ModelAttribute JsonProtocol protocol, @ModelAttribute ServiceRequestInfo requestInfo,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		super.handleComm(protocol, requestInfo, handleManager, request, response);
	}
}
