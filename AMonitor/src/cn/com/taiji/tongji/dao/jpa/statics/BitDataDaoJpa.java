package cn.com.taiji.tongji.dao.jpa.statics;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.StringTools;
import cn.com.taiji.common.pub.dao.HqlBuilder;
import cn.com.taiji.tongji.dao.jpa.MyBaseDao;
import cn.com.taiji.tongji.dao.statics.BitDataDao;
import cn.com.taiji.tongji.entity.statics.BitData;
import cn.com.taiji.tongji.model.statics.BitDataModel;

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
@Repository("bitDataDao")
public class BitDataDaoJpa extends MyBaseDao<BitData> implements BitDataDao
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

	@Override
	public Pagination pagnModel(BitDataModel queryModel)
	{
		String brand=queryModel.getBrand();//手机品牌
		String type=queryModel.getType();//手机型号
		String version=queryModel.getVersion();;//Android版本
		String localIp=queryModel.getLocalIp();//本机IP地址
		String IMEI=queryModel.getIMEI();//IMEI 
		String IMSI=queryModel.getIMSI();//IMSI
		String AppName=queryModel.getAppName();//应用进程名称
		String NetType=queryModel.getNetType();//网络类型
		String cid=queryModel.getCid();//CID
		String LAC=queryModel.getLAC();//LAC
		String excepType=queryModel.getExcepType();
		String addr=queryModel.getAddr();
		//复杂查询
		Calendar startLauntime=queryModel.getStartTime();//启动时间
		Calendar endLauntime=queryModel.getEndTime();//启动时间
		
		String usetime=queryModel.getUsetime();//使用时长
		String cpuRate=queryModel.getCpuRate();//CPU占比
		String TxByte=queryModel.getTxByte();//发送总字节量
		String RxByte=queryModel.getRxByte();//接收总字节量
		String RSRP=queryModel.getRSRP();//RSRP
		String RSRQ=queryModel.getRSRQ();//RSRQ
		String RSSNR=queryModel.getRSSNR();//RSSNR
		String RSRP1=queryModel.getRSRP1();//RSRP1
		String RSRQ1=queryModel.getRSRQ1();//RSRQ1
		String RSSNR1=queryModel.getRSSNR1();//RSSNR1

		int pageNo=queryModel.getPageNo();
		int pageSize=queryModel.getPageSize();
		
		
		HqlBuilder hql = new HqlBuilder("from "+clazz.getName()+" where 1=1 ");
		if(StringTools.hasText(brand))hql.append(" and brand like :brand ","%"+brand+"%");
		if(StringTools.hasText(type))hql.append(" and type like :type ","%"+type+"%");
		if(StringTools.hasText(version))hql.append(" and version like :version ","%"+version+"%");
		if(StringTools.hasText(localIp))hql.append(" and localIp like :localIp ","%"+localIp+"%");
		hql.append(" and IMEI = :IMEI ",IMEI);
		hql.append(" and IMSI = :IMSI ",IMSI);
		if(StringTools.hasText(AppName))hql.append(" and AppName like :AppName ","%"+AppName+"%");
		if(StringTools.hasText(NetType))hql.append(" and NetType like :NetType ","%"+NetType+"%");
		hql.append(" and Cell_Id = :cid ",cid);
		hql.append(" and LAC = :LAC ",LAC);
		hql.append(" and launtime >=:startTime ",startLauntime);
		hql.append(" and launtime <=:endTime ",endLauntime);
		
		hql.append(" and usetime = :usetime ",usetime);
		hql.append(" and cpuRate = :cpuRate ",cpuRate);
		hql.append(" and TxByte = :TxByte ",TxByte);
		hql.append(" and RxByte = :RxByte ",RxByte);
		hql.append(" and excepType = :excepType ",excepType);
		hql.append(" and addr = :addr ",addr);
		hql.append(" and RSRP >= :RSRP ",RSRP);
		hql.append(" and RSRP <= :RSRP1 ",RSRP1);
		hql.append(" and RSRQ >= :RSRQ ",RSRQ);
		hql.append(" and RSRQ <= :RSRQ1 ",RSRQ1);
		hql.append(" and RSSNR >= :RSSNR ",RSSNR);
		hql.append(" and RSSNR <= :RSSNR1 ",RSSNR1);
				
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by launtime desc,id asc ");
//		logger.info("hql.toString====={}",hql.toString());
		return super.pageQuery(hql.toString(), hql.getParams(), countHql, pageNo, pageSize);
	
	}

	@Override
	public List<Object[]> queryList(BitDataModel queryModel)
	{
		String hql = queryModel.getHql();
		return (List<Object[]>) super.queryList(Object[].class,hql, new Object[] {});
	}

}

