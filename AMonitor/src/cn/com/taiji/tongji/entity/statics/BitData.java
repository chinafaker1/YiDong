package cn.com.taiji.tongji.entity.statics;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.taiji.common.entity.BaseEntity;
import cn.com.taiji.common.entity.IntAutoIdEntity;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月23日 上午10:38:53   
* 修改人：王金鑫     
* 修改时间：2016年1月23日 上午10:38:53   
* 修改备注：   
* @version    
*    
*/
@Entity
@Table(name = "data")
public class BitData extends BaseEntity
{
	private int id;
	private Calendar launtime;//启动时间
	private String exittime;//退出时间
	private String usetime;//使用时长
	private String excepTime;//异常时间
	private String uploadTime;//上报时间
	private String uploadNum;
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

	private String brand;//手机品牌
	private String type;//手机型号
	private String version;//Android版本
	private String corporation;//运营商
	private String cId;//CID
	private String localIp;//本机IP地址
	private String appName;//应用进程名称
	
	private String IMEI;//IMEI 
	private String IMSI;//IMSI
	private String lac;//LAC
	private String cpuRate;//CPU占比
	private String uid;
	private String pid;
	private String pidNumber;
	private String memRate;
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
	public String getcId()
	{
		return cId;
	}

	public void setcId(String cId)
	{
		this.cId = cId;
	}

	public String getLocalIp()
	{
		return localIp;
	}

	public void setLocalIp(String localIp)
	{
		this.localIp = localIp;
	}
	@Column(name="AppName")
	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
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
	@Column(name="LAC")
	public String getLac()
	{
		return lac;
	}

	public void setLac(String lac)
	{
		this.lac = lac;
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
	@Column(name="MemRate")
	public String getMemRate()
	{
		return memRate;
	}

	public void setMemRate(String memRate)
	{
		this.memRate = memRate;
	}
	public String getGid()
	{
		return gid;
	}

	public void setGid(String gid)
	{
		this.gid = gid;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof IntAutoIdEntity)) return false;
		IntAutoIdEntity other = (IntAutoIdEntity) obj;
		return super.equals(id, other.getId());
	}

	@Override
	public int hashCode()
	{
		return super.hashCode(id);
	}
}

