package cn.com.taiji.tongji.dao.jpa.statics;

import java.util.Calendar;

import org.springframework.stereotype.Repository;

import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.StringTools;
import cn.com.taiji.common.pub.dao.HqlBuilder;
import cn.com.taiji.tongji.dao.jpa.MyBaseDao;
import cn.com.taiji.tongji.dao.statics.BitAlertDataDao;
import cn.com.taiji.tongji.entity.statics.BitAlertData;

/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2016年1月23日 上午11:02:38   
* 修改人：王金鑫     
* 修改时间：2016年1月23日 上午11:02:38   
* 修改备注：   
* @version    
*    
*/
@Repository("bitAlertDataDao")
public class BitAlertDataDaoJpa extends MyBaseDao<BitAlertData> implements BitAlertDataDao
{

	@Override
	public Pagination pagn(String brand, Calendar startTime,Calendar endTime,int pageNo, int pageSize)
	{
		HqlBuilder hql = new HqlBuilder("from "+clazz.getName()+" where 1=1 ");
		if(StringTools.hasText(brand))hql.append(" and brand like :brand ","%"+brand+"%");
		hql.append(" and launtime >=:startTime ",startTime);
		hql.append(" and launtime <=:endTime ",endTime);
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by launtime desc,id asc ");
		return super.pageQuery(hql.toString(), hql.getParams(), countHql, pageNo, pageSize);
	
	}

}

