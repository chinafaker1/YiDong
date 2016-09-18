package cn.com.taiji.tongji.manager.statics;

import java.io.File;
import java.util.List;

import cn.com.taiji.common.manager.JsonManagerException;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.tongji.entity.statics.BitData;
import cn.com.taiji.tongji.model.statics.BitDataModel;
import cn.com.taiji.tongji.model.statics.BitDataView;

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
public interface BitDataManager
{
	public Pagination queryPagn(BitDataModel queryModel);
	
	public Pagination pagnModel(BitDataModel queryModel);
	
	public BitData add(BitData vo) throws JsonManagerException;

	public BitData update(BitData vo) throws JsonManagerException;

	public void detele(String id) throws JsonManagerException; 
	
	public BitData findById(Integer id);
	
	public List<BitDataView> getDataViews(BitDataModel queryModel);
	
	public String getDataViewsForCharts(List<BitDataView> views);
	
	public File generateExcel(BitDataModel bitDataModel);
	
	/**
	 * 导出统计的数据到文件
	 * @param queryModel
	 * @return
	 */
	public File generateStaticDataExcel(BitDataModel queryModel);
}

