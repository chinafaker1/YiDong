package model;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.batch.spi.BatchObserver;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import analysis.Effect;
import analysis.MrData;
import analysis.UeData;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
public class tongji extends ActionSupport{
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String rsrp = "-95 -87 -102 -99 -88 -89 -73 -65 -102 -101";
		String rsrq = "-15 -12 -9 -10 -16 -14 -12 -11 -8 -6";
		UeData ueData = new UeData(rsrp, rsrq);
		MrData mrData = new MrData();
		Effect effect = new Effect(ueData, mrData);
		double[] ee=new double[9];
		ee[0]=effect.geteRsrp();
		ee[1]=effect.geteRsrq();
		ee[2]=effect.getePrb();
		ee[3]=effect.geteDlPlr();
		ee[4]=effect.geteUlPlr();
		ee[5]=effect.geteUlSinr();
		ee[6]=effect.geteUl();
		ee[7]=effect.geteDl();
		ee[8]=effect.getE();
		for(int i=0;i<ee.length;i++)
       System.out.println(ee[i]);
	}
private String[] aStrings;
private  String[] bStrings;
private int  indexRsrp;
private int  indexRsrq;
private int indexExpPrbNum;
public int getIndexExpPrbNum() {
	return indexExpPrbNum;
}
public void setIndexExpPrbNum(int indexExpPrbNum) {
	this.indexExpPrbNum = indexExpPrbNum;
}
private int  meanRsrp;
private int  meanRsrq;
private int indexExpSinrUl;
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
public int getMeanRsrp() {
	return meanRsrp;
}
public void setMeanRsrp(int meanRsrp) {
	this.meanRsrp = meanRsrp;
}
public int getMeanRsrq() {
	return meanRsrq;
}
public void setMeanRsrq(int meanRsrq) {
	this.meanRsrq = meanRsrq;
}
private String[] ULQi6;
private String[] ULQi8;
private String[] ULQi9;
private String[] DLQi6;
private String[] DLQi8;
private String[] DLQi9;
private String[] ULQ=new String[28];
private String[] DLQ=new String[28];
private List<String> listRSRP;
private List<String> listRSRQ;
private List<String> listPDSCHPRBNum;
private List<String> listPacketLossRateULQ;
private List<String> listPacketLossRateDLQ;
private List<String> listSinrUL;
private List<double[]> listee;
public List<double[]> getListee() {
	return listee;
}
public void setListee(List<double[]> listee) {
	this.listee = listee;
}
public List<String> getListPDSCHPRBNum() {
	return listPDSCHPRBNum;
}
public void setListPDSCHPRBNum(List<String> listPDSCHPRBNum) {
	this.listPDSCHPRBNum = listPDSCHPRBNum;
}
public List<String> getListPacketLossRateULQ() {
	return listPacketLossRateULQ;
}
public void setListPacketLossRateULQ(List<String> listPacketLossRateULQ) {
	this.listPacketLossRateULQ = listPacketLossRateULQ;
}
public List<String> getListPacketLossRateDLQ() {
	return listPacketLossRateDLQ;
}
public void setListPacketLossRateDLQ(List<String> listPacketLossRateDLQ) {
	this.listPacketLossRateDLQ = listPacketLossRateDLQ;
}
public List<String> getListSinrUL() {
	return listSinrUL;
}
public void setListSinrUL(List<String> listSinrUL) {
	this.listSinrUL = listSinrUL;
}
public List<String> getListRSRP() {
	return listRSRP;
}
public void setListRSRP(List<String> listRSRP) {
	this.listRSRP = listRSRP;
}
public List<String> getListRSRQ() {
	return listRSRQ;
}
public void setListRSRQ(List<String> listRSRQ) {
	this.listRSRQ = listRSRQ;
}
public String tongji() 
{  	  	
		try {
			 CSVFileUtil csvFileUtil2=new CSVFileUtil(tongji.class.getClassLoader().getResource("")  
					   .getFile().replaceAll("/WEB-INF/classes/", "").replaceAll("%20", " ").substring(1) +"/selected.csv");		
			    String string;
			    int j=0;
			    while((string=csvFileUtil2.readLine())!=null)
			    {   if(j==1){
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			        String[] bStrings=aStrings[9].split(" ");
			        listRSRP= Arrays.asList(bStrings);
			    }
			    else if(j==2)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			        String[] bStrings=aStrings[9].split(" ");
			        listRSRQ= Arrays.asList(bStrings);
			    }
			    else if(j==3)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			        String[] bStrings=aStrings[9].split(" ");
			       
			        listPDSCHPRBNum= Arrays.asList(bStrings);
			    }
			    else if(j==4)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	ULQi6=aStrings[9].split(" ");
			    	
			    }
			    else if(j==5)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	ULQi8=aStrings[9].split(" ");
			   
			    }
               
			    else if(j==6)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	ULQi9=aStrings[9].split(" ");
			    	
			    }
			    else if(j==7)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	DLQi6=aStrings[9].split(" ");
			    	
			    }
			    else if(j==8)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	DLQi8=aStrings[9].split(" ");
			    	
			    }
			    else if(j==9)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			    	DLQi9=aStrings[9].split(" ");
			    	
			    }
			    else if(j==10)
			    {
			    	String[] aStrings=csvFileUtil2.fromCSVLine(string, 10); 
			        String[] bStrings=aStrings[9].split(" ");
			        listSinrUL= Arrays.asList(bStrings);
			    }
			    j++;
			    continue;
			    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			for(int i=0;i<28;i++)
			{    
				 ULQ[i]=Integer.toString(Integer.parseInt(ULQi6[i])+Integer.parseInt(ULQi8[i])+Integer.parseInt(ULQi9[i]));
				 DLQ[i]=Integer.toString(Integer.parseInt(DLQi6[i])+Integer.parseInt(DLQi8[i])+Integer.parseInt(DLQi9[i]));
				 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 listPacketLossRateULQ=Arrays.asList(ULQ);
		 listPacketLossRateDLQ=Arrays.asList(DLQ);
		 String[] rsrp = {"-76 -76 -74 -74 -74 -74 -74 -74 -74 -74 -75 -74 -74 -77 -77 -75 -75 -75 -75 -75 -75 -75 -75 -75 -81 -81 -81 -81 -81 -77 -77 -77 -77 -76 -76 -76 -76 -76 -76 -76 -76 -76 -74 -74 -74 -74 -74 -74 -74 -75 -74 -74 -74 -77 -77 -75 -75 -75 -75 -75 -75 -75 -75 -75 -81 -81 -81 -81 -81 -77 -77 -77 -77 -76 -76 -76 -76 -76 -76 -76 -74 -74 -74 -77 -77 -75 -75 -75 -75 -75 -75 -75 -75 -75 -81 -81 -81 -81 -81 -77"
					,"-107 -107 -109 -109 -109 -109 -108 -108 -108 -108"
					,"-111 -111 -110 -110 -110 -113 -113 -113 -111 -111"
			
	};
	String[] rsrq = {"-9 -9 -7 -7 -8 -8 -8 -8 -8 -10 -8 -10 -10 -8 -8 -8 -8 -8 -8 -8 -8 -8 -7 -7 -8 -8 -8 -8 -8 -8 -8 -8 -8 -9 -9 -9 -9 -9 -9 -9 -9 -9 -7 -7 -8 -8 -8 -8 -8 -8 -10 -10 -10 -8 -8 -8 -8 -8 -8 -8 -8 -8 -7 -7 -8 -8 -8 -8 -8 -8 -8 -8 -8 -9 -9 -9 -9 -9 -9 -9 -10 -10 -10 -8 -8 -8 -8 -8 -8 -8 -8 -8 -7 -7 -8 -8 -8 -8 -8 -8"
					,"-11 -11 -12 -12 -12 -12 -13 -13 -12 -12 -12 -12"
					,"-12 -12 -13 -13 -13 -15 -15 -15 -15 -13"
			
	};
	UeData ueData = new UeData(rsrp[2], rsrq[2]);
	MrData mrData = new MrData();
	Effect effect = new Effect(ueData, mrData);
			DecimalFormat df = new DecimalFormat("#.00");  
			double[] ee=new double[9];
			 BigDecimal bg0 = new BigDecimal(effect.geteRsrp()*100); 
			ee[0]=bg0.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			 BigDecimal bg1 = new BigDecimal(effect.geteRsrq()*100); 
			ee[1]=bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//			 BigDecimal bg2 = new BigDecimal(effect.getePrb()*100); 
			ee[2]=bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			 BigDecimal bg3 = new BigDecimal(effect.geteDlPlr()*100); 
			ee[3]=bg3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			 BigDecimal bg4 = new BigDecimal(effect.geteUlPlr()*100); 
			ee[4]=bg4.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			BigDecimal bg5 = new BigDecimal(effect.geteUlSinr()*100); 
			ee[5]=bg5.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			BigDecimal bg6 = new BigDecimal(effect.geteUl()*100); 
			ee[6]=bg6.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			BigDecimal bg7 = new BigDecimal(effect.geteDl()*100); 
			ee[7]=bg7.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			BigDecimal bg8 = new BigDecimal(effect.getE()*100); 
			ee[8]=bg8.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			listee=Arrays.asList(ee);
			indexRsrp= mrData.getIndexExpRsrp();
			indexRsrq= mrData.getIndexExpRsrq();
			meanRsrp=ueData.getIndexRsrp();
			meanRsrq=ueData.getIndexRsrq();
			indexExpSinrUl=mrData.getIndexExpSinrUl();
			indexExpPrbNum=mrData.getIndexExpPrbNum();
	return SUCCESS;
}
public int getIndexExpSinrUl() {
	return indexExpSinrUl;
}
public void setIndexExpSinrUl(int indexExpSinrUl) {
	this.indexExpSinrUl = indexExpSinrUl;
}
public String[] getaStrings() {
	return aStrings;
}
public void setaStrings(String[] aStrings) {
	this.aStrings = aStrings;
}
public String[] getbStrings() {
	return bStrings;
}
public void setbStrings(String[] bStrings) {
	this.bStrings = bStrings;
}
}
