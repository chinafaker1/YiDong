package cn.com.taiji.tongji.model.enums;
/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月24日 下午1:54:09   
* 修改人：王金鑫     
* 修改时间：2016年1月24日 下午1:54:09   
* 修改备注：   
* @version    
*    
*/
public enum BitDataEnum
{
	BRAND("手机品牌"),TYPE("手机型号"),VERSION("Android版本"),
	LOCALIP("本机IP地址"),IMEI("IMEI"),IMSI("IMSI"),APPNAME("应用进程名称"),
	Enodeb_id("基站号"),cell_id("小区号"),TAC("跟踪区域码");
	private String value;
	private BitDataEnum(String value)
	{
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	
}

