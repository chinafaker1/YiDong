package cn.com.taiji.tongji.model.statics;

import java.util.Calendar;

import cn.com.taiji.common.model.PaginModel;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月23日 上午11:09:35   
* 修改人：王金鑫     
* 修改时间：2016年1月23日 上午11:09:35   
* 修改备注：   
* @version    
*    
*/
public class BitAlertDataModel extends PaginModel
{
	private int pageSize = 10;
	private String brand;
	
	private Calendar startTime;
	private Calendar endTime;
	private String hour;
	
	//下载的页数
	private String startNo;
	private String endNo;
		
	public int getPageSize()
	{
		return pageSize;
	}
	public PaginModel setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
		return this;
	}
	public String getBrand()
	{
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	public Calendar getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Calendar startTime)
	{
		this.startTime = startTime;
	}
	public Calendar getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Calendar endTime)
	{
		this.endTime = endTime;
	}
	public String getHour()
	{
		return hour;
	}
	public void setHour(String hour)
	{
		this.hour = hour;
	}
	public String getStartNo()
	{
		return startNo;
	}
	public void setStartNo(String startNo)
	{
		this.startNo = startNo;
	}
	public String getEndNo()
	{
		return endNo;
	}
	public void setEndNo(String endNo)
	{
		this.endNo = endNo;
	}
	
	
}

