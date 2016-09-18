package cn.com.taiji.tongji.manager.statics;

import java.io.File;

import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.tongji.entity.statics.BitAlertData;
import cn.com.taiji.tongji.model.statics.BitAlertDataModel;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2015年11月21日 下午12:33:57   
* 修改人：王金鑫     
* 修改时间：2015年11月21日 下午12:33:57   
* 修改备注：   实验室管理
* @version    
*    
*/
public interface BitAlertDataManager
{
	public Pagination queryPagn(BitAlertDataModel queryModel);
	
	public BitAlertData findById(Integer id);
	
	public File generateExcel(BitAlertDataModel bitAlertDataModel);
}

