/*
 * Date: 2013-5-2
 * author: Peream  (peream@gmail.com)
 *
 */
package cn.com.taiji.tongji.model.protocol.sample;

import java.util.List;

import cn.com.taiji.common.entity.BaseEntity;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.model.json.AbstractProtocol;

/**
 * 
 * @author Peream <br>
 *         Create Time：2013-5-2 上午11:44:22<br>
 *         <a href="mailto:peream@gmail.com">peream@gmail.com</a>
 * @since 1.0
 * @version 1.0
 */
public class SampleResponse extends AbstractProtocol
{
	private boolean ok;
	private String name;
	private String pagnJson;
	private String listJson;

	public SampleResponse(boolean ok, String name)
	{
		super(BatteryProtocolType.RES_SAMPLE.name());
		this.ok = ok;
		this.name = name;
	}

	public SampleResponse()
	{
		this(false, null);
	}

	public boolean isOk()
	{
		return ok;
	}

	public void setOk(boolean ok)
	{
		this.ok = ok;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPagnJson()
	{
		return pagnJson;
	}

	public String getListJson()
	{
		return listJson;
	}

	public void setPagnJson(String pagnJson)
	{
		this.pagnJson = pagnJson;
	}

	public void setListJson(String listJson)
	{
		this.listJson = listJson;
	}

	public static SampleResponse newInstance(String jsonStr)
	{
		return newInstance(SampleResponse.class, jsonStr);
	}

	public <E extends BaseEntity> Pagination extractPagn(Class<E> resultEleClass)
	{
		return super.extractPagn(pagnJson, resultEleClass);
	}

	public <E extends BaseEntity> List<E> extractSampleList(Class<E> eleClass)
	{
		return super.extractList(listJson, eleClass);
	}
}
