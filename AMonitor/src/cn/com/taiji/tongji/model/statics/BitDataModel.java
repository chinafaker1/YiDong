package cn.com.taiji.tongji.model.statics;

import java.util.Calendar;

import cn.com.taiji.common.model.PaginModel;
import cn.com.taiji.tongji.model.enums.BitDataEnum;

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
public class BitDataModel extends PaginModel
{
	private int pageSize = 10;
	
	private Calendar startTime;
	private Calendar endTime;
	private String hour;
	//下面的简单查询的条件
	private String brand;//手机品牌
	private String type;//手机型号
	private String version;//Android版本
	private String localIp;//本机IP地址
	private String AppName;//应用进程名称
	private String IMEI;//IMEI 
	private String IMSI;//IMSI
	private String NetType;//网络类型
	private String cid;//CID
	private String LAC;//LAC
	//复杂查询
	private Calendar launtime;//启动时间
	private String exittime;//退出时间
	private String usetime;//使用时长
	private String cpuRate;//CPU占比
	private String TxByte;//发送总字节量
	private String RxByte;//接收总字节量
	private String RSRP;//RSRP
	private String RSRQ;//RSRQ
	private String RSSNR;//RSSNR
	private String RSRP1;//RSRP
	private String RSRQ1;//RSRQ
	private String RSSNR1;//RSSNR
	public String getRSRP1() {
		return RSRP1;
	}
	public void setRSRP1(String rSRP1) {
		RSRP1 = rSRP1;
	}
	public String getRSRQ1() {
		return RSRQ1;
	}
	public void setRSRQ1(String rSRQ1) {
		RSRQ1 = rSRQ1;
	}
	public String getRSSNR1() {
		return RSSNR1;
	}
	public void setRSSNR1(String rSSNR1) {
		RSSNR1 = rSSNR1;
	}
	//查询统计,根据哪个字段来统计
	private BitDataEnum dataType;
	private String hql;
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
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getVersion()
	{
		return version;
	}
	public void setVersion(String version)
	{
		this.version = version;
	}
	public String getLocalIp()
	{
		return localIp;
	}
	public void setLocalIp(String localIp)
	{
		this.localIp = localIp;
	}
	public String getIMEI()
	{
		return IMEI;
	}
	public void setIMEI(String iMEI)
	{
		IMEI = iMEI;
	}
	public String getIMSI()
	{
		return IMSI;
	}
	public void setIMSI(String iMSI)
	{
		IMSI = iMSI;
	}
	public String getAppName()
	{
		return AppName;
	}
	public void setAppName(String appName)
	{
		AppName = appName;
	}
	public String getNetType()
	{
		return NetType;
	}
	public void setNetType(String netType)
	{
		NetType = netType;
	}
	
	public String getCid()
	{
		return cid;
	}
	public void setCid(String cid)
	{
		this.cid = cid;
	}
	public String getLAC()
	{
		return LAC;
	}
	public void setLAC(String lAC)
	{
		LAC = lAC;
	}
	public Calendar getLauntime()
	{
		return launtime;
	}
	public void setLauntime(Calendar launtime)
	{
		this.launtime = launtime;
	}
	public String getExittime()
	{
		return exittime;
	}
	public void setExittime(String exittime)
	{
		this.exittime = exittime;
	}
	public String getUsetime()
	{
		return usetime;
	}
	public void setUsetime(String usetime)
	{
		this.usetime = usetime;
	}
	public String getCpuRate()
	{
		return cpuRate;
	}
	public void setCpuRate(String cpuRate)
	{
		this.cpuRate = cpuRate;
	}
	public String getTxByte()
	{
		return TxByte;
	}
	public void setTxByte(String txByte)
	{
		TxByte = txByte;
	}
	public String getRxByte()
	{
		return RxByte;
	}
	public void setRxByte(String rxByte)
	{
		RxByte = rxByte;
	}
	public String getRSRP()
	{
		return RSRP;
	}
	public void setRSRP(String rSRP)
	{
		RSRP = rSRP;
	}
	public String getRSRQ()
	{
		return RSRQ;
	}
	public void setRSRQ(String rSRQ)
	{
		RSRQ = rSRQ;
	}
	public String getRSSNR()
	{
		return RSSNR;
	}
	public void setRSSNR(String rSSNR)
	{
		RSSNR = rSSNR;
	}
	public BitDataEnum getDataType()
	{
		return dataType;
	}
	public void setDataType(BitDataEnum dataType)
	{
		this.dataType = dataType;
	}
	public String getHql()
	{
		return hql;
	}
	public void setHql(String hql)
	{
		this.hql = hql;
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

