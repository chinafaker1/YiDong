package cn.com.taiji.tongji.model.statics;
/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月24日 下午3:29:58   
* 修改人：王金鑫     
* 修改时间：2016年1月24日 下午3:29:58   
* 修改备注：   
* @version    
*    
*/
public class PieModel
{
	private long value;
	private String name;
	
	public PieModel(String name,long value)
	{
		this.name=name;
		this.value=value;
	}
	public long getValue()
	{
		return value;
	}
	public void setValue(long value)
	{
		this.value = value;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	
}

