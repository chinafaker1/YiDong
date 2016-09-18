/*
 * Date: 2014年9月16日
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.manager.comm;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cn.com.taiji.common.manager.AbstractManager;
import cn.com.taiji.common.model.TimePaginModel;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.json.JsonTools;
import cn.com.taiji.tongji.model.comm.HttpRequestInfo;
import cn.com.taiji.tongji.model.protocol.sample.SampleRequest;
import cn.com.taiji.tongji.model.protocol.sample.SampleResponse;

/**
 * 
 * @author Peream <br>
 *         Create Time：2014年9月16日 下午8:48:35<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
@Service
public class ProtocolHandleManagerImpl extends AbstractManager implements ProtocolHandleManager
{
	@Override
	public SampleResponse handleSample(SampleRequest request, HttpRequestInfo requestInfo)
	{
		SampleResponse res = new SampleResponse(false, request.getName());
		Pagination pg = new Pagination(1, 3, 13);
		pg.setPageCount(Pagination.getPageCount(13, 3));
		List<TimePaginModel> rs = Lists.newArrayList();
		for (int i = 1; i <= 3; i++)
		{
			TimePaginModel tpg = new TimePaginModel();
			tpg.setPageNo(i);
			tpg.setPageSize(i * 3);
			tpg.setStartTime(Calendar.getInstance());
			tpg.setEndTime(Calendar.getInstance());
			rs.add(tpg);
		}
		pg.setResult(rs);
		res.setPagnJson(pg.toJson());
		try
		{
			res.setListJson(JsonTools.toJsonStr(rs));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return res;
	}
}
