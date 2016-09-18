package cn.com.taiji.tongji.manager.tools;

import java.math.BigDecimal;

/**
 * 
 * 类描述： 创建人：王金鑫 创建时间：2015年12月9日 上午9:04:30 修改人：王金鑫 修改时间：2015年12月9日 上午9:04:30
 * 修改备注：
 * 
 * @version
 * 
 */
public class NumberTools
{
	public static double getDoubleScale(double f)
	{
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	public static double getDoubleScale(double f,int scale)
	{
		BigDecimal b = new BigDecimal(f);
		double f1 = b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
}
