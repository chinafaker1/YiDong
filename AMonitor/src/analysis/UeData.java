package analysis;

public class UeData {
	private double[] iRsrp;
	private	double[] iRsrq;
	private	double[] iSinr;
	private	double expRsrp;
	private double expRsrq;
	private double expSinr;
	private	int indexRsrp;
	private	int indexRsrq;
	
	public UeData(String rsrp ,String rsrq)
	{
		/**
		 * 数据初始化
		 */
		String[] srsrp=rsrp.split(" ");
		String[] srsrq=rsrq.split(" ");
		iRsrp=new double[srsrp.length];
		iRsrq=new double[srsrq.length];
		for(int i=0;i<srsrp.length;i++)
		{   try {
			iRsrp[i]=Double.parseDouble(srsrp[i]);
			iRsrq[i]=Double.parseDouble(srsrq[i]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(rsrp+" dddd"+rsrq);
			System.out.println(srsrp[i]+"我错啦 "+srsrq[i]);
		}
			finally{
				continue;
			}
		}
		/**
		 * 数据初始化
		 */
		
		
		expRsrp=Util.calExp(iRsrp);
		expRsrq=Util.calExp(iRsrq);
		indexRsrp=Util.getRsrpIndex(expRsrp);
		indexRsrq=Util.getRsrqIndex(expRsrq);
		
	}
	public UeData()
	{
		
	}
	public double[] getiSinr() {
		return iSinr;
	}
	public void setiSinr(double[] iSinr) {
		this.iSinr = iSinr;
	}
	public double getExpSinr() {
		return expSinr;
	}
	public void setExpSinr(double expSinr) {
		this.expSinr = expSinr;
	}
	public void UeData1(String rsrp ,String sinr)
	{
		/**
		 * 数据初始化
		 */
		String[] srsrp=rsrp.split(" ");
		String[] ssinr=sinr.split(" ");
		iRsrp=new double[srsrp.length];
		iSinr=new double[ssinr.length];
		for(int i=0;i<srsrp.length;i++)
		{   try {
			iRsrp[i]=Double.parseDouble(srsrp[i]);
			iSinr[i]=Double.parseDouble(ssinr[i]);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(rsrp+" dddd"+sinr);
			System.out.println(srsrp[i]+"我错啦 "+ssinr[i]);
		}
			finally{
				continue;
			}
		}
		/**
		 * 数据初始化
		 */
		
		
		expRsrp=Util.calExp(iRsrp);
		expSinr=Util.calExp(iSinr);
		
	}
	
	public String toString()
	{
		StringBuilder sBuilder=new StringBuilder();
		sBuilder.append("UE_RSRP平均值"+expRsrp+"\n");
		sBuilder.append("UE_RSRP平均值区间"+indexRsrp+"\n");
		sBuilder.append("UE_RSRQ平均值"+expRsrq+"\n");
		sBuilder.append("UE_RSRQ平均值区间"+indexRsrq+"\n");
		return sBuilder.toString();
		
	}
	
	
	
	
	public double getExpRsrp() {
		return expRsrp;
	}
	public void setExpRsrp(double expRsrp) {
		this.expRsrp = expRsrp;
	}
	public double getExpRsrq() {
		return expRsrq;
	}
	public void setExpRsrq(double expRsrq) {
		this.expRsrq = expRsrq;
	}
	public int getIndexRsrp() {
		return indexRsrp;
	}
	public void setIndexRsrp(int indexRsrp) {
		this.indexRsrp = indexRsrp;
	}
	public int getIndexRsrq() {
		return indexRsrq;
	}
	public void setIndexRsrq(int indexRsrq) {
		this.indexRsrq = indexRsrq;
	}
	
	public double[] getiRsrp() {
		return iRsrp;
	}
	public void setiRsrp(double[] iRsrp) {
		this.iRsrp = iRsrp;
	}
	public double[] getiRsrq() {
		return iRsrq;
	}
	public void setiRsrq(double[] iRsrq) {
		this.iRsrq = iRsrq;
	}
	
	
	
}
