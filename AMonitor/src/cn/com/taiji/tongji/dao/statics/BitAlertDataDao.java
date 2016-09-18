package cn.com.taiji.tongji.dao.statics;

import java.util.Calendar;

import cn.com.taiji.common.dao.jpa.AbstractJpaDao;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.tongji.entity.statics.BitAlertData;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2015年11月29日 上午11:46:08   
* 修改人：王金鑫     
* 修改时间：2015年11月29日 上午11:46:08   
* 修改备注：   
* @version    
*    
*/
public interface BitAlertDataDao extends AbstractJpaDao<BitAlertData>
{
	public Pagination pagn(String brand,Calendar startTime,Calendar endTime,int pageNo, int pageSize);
	
}

