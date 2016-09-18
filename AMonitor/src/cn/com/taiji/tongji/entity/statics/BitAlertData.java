package cn.com.taiji.tongji.entity.statics;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.taiji.common.entity.BaseEntity;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月24日 上午7:47:14   
* 修改人：王金鑫     
* 修改时间：2016年1月24日 上午7:47:14   
* 修改备注：   
* @version    
*    
*/
@Entity
@Table(name = "alertdata")
public class BitAlertData extends BaseEntity
{
	private int id;
	private Calendar launtime;//启动时刻
	private String exittime;//退出时间
	private String usetime;//使用时长
	private String excepTime;//异常时间
	private String uploadTime;//上报时间
	private String uploadNum;
	private String PCI;//PCI
	public String getExcepTime() {
		return excepTime;
	}

	public void setExcepTime(String excepTime) {
		this.excepTime = excepTime;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUploadNum() {
		return uploadNum;
	}

	public void setUploadNum(String uploadNum) {
		this.uploadNum = uploadNum;
	}

	public String getPCI() {
		return PCI;
	}

	public void setPCI(String pCI) {
		PCI = pCI;
	}

	public String getCI() {
		return CI;
	}

	public void setCI(String cI) {
		CI = cI;
	}

	public String getENODBID() {
		return ENODBID;
	}

	public void setENODBID(String eNODBID) {
		ENODBID = eNODBID;
	}

	public String getCELLID() {
		return CELLID;
	}

	public void setCELLID(String cELLID) {
		CELLID = cELLID;
	}

	public String getTAC() {
		return TAC;
	}

	public void setTAC(String tAC) {
		TAC = tAC;
	}

	private String CI;//CI
	private String ENODBID;//ENODBID
	private String CELLID;//CELLID
	private String TAC;//TAC
	private String brand;//品牌
	private String type;//型号
	private String version;//版本
	private String corporation;//运营商
	private String Cid;//cell-id号
	private String localIp;//本机IP
	private String AppName;//应用名称
	private String NetType;//网络类型 (LTE)
	private String IMEI;//IMEI
	private String IMSI;//IMSI
	private String LAC;//LAC号
	private String RSRP;//RSRP
	private String RSRQ;//RSRQ
	private String cpuRate;
	private String uid;//uid
	private String pid;//pid(多个)
	private String pidNumber;//进程数
	private String MemRate;//内存占用率
	private String TxByte;//发送字节量
	private String RxByte;//接收字节量
	private String RSSNR;//SNR
	private String Flag;
	private String gid;
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
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

	public String getCorporation()
	{
		return corporation;
	}

	public void setCorporation(String corporation)
	{
		this.corporation = corporation;
	}
	
	@Column(name="Cell_Id")
	public String getCid()
	{
		return Cid;
	}

	public void setCid(String cid)
	{
		Cid = cid;
	}

	public String getLocalIp()
	{
		return localIp;
	}

	public void setLocalIp(String localIp)
	{
		this.localIp = localIp;
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

	public String getLAC()
	{
		return LAC;
	}

	public void setLAC(String lAC)
	{
		LAC = lAC;
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

	public String getCpuRate()
	{
		return cpuRate;
	}

	public void setCpuRate(String cpuRate)
	{
		this.cpuRate = cpuRate;
	}

	public String getUid()
	{
		return uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getPid()
	{
		return pid;
	}

	public void setPid(String pid)
	{
		this.pid = pid;
	}

	public String getPidNumber()
	{
		return pidNumber;
	}

	public void setPidNumber(String pidNumber)
	{
		this.pidNumber = pidNumber;
	}

	public String getMemRate()
	{
		return MemRate;
	}

	public void setMemRate(String memRate)
	{
		MemRate = memRate;
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

	public String getRSSNR()
	{
		return RSSNR;
	}

	public void setRSSNR(String rSSNR)
	{
		RSSNR = rSSNR;
	}

	public String getFlag()
	{
		return Flag;
	}

	public void setFlag(String flag)
	{
		Flag = flag;
	}

	public String getGid()
	{
		return gid;
	}

	public void setGid(String gid)
	{
		this.gid = gid;
	}
	
}

