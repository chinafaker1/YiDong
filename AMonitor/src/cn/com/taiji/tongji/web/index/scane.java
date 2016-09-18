package cn.com.taiji.tongji.web.index;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.com.taiji.tongji.dao.Jdbc;

public class scane extends Thread{
	 public void run(){ 
		while(1>0){
       timer1();
       try {
		Thread.sleep(200000);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("下一轮了"+df.format(new Date()));
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
   }  
	 public static void timer1() {
		 Jdbc j1=new Jdbc();
		 String s2="select * from data where sign=0"; 
		 String s3;
		 int id;
		 String ee;
		 String mrRP="";
	     String mrRQ="";
	     String mrDL="";
		 String mrUL="";
		 String mrSL="";
		 String eUL_SINR="";
		 String eRSRP="";
		 String eRSRQ="";
		 String eUL_PLR="";
		 String eUL="";
		 String eDL="";
		 String eDL_PLR="";
		 int indexRsrp=0;
		 int indexRsrq=0;
		 int indexExpRsrp=0;
		 int indexExpRsrq=0;
		 int indexExpSinrUl=0;
		double[] mrRSRP = new double[48];
		double[] mrRSRQ = new double[18];
		double[] mrPlrUl6 = new double[28];
		double[] mrPlrUl8 = new double[28];
		double[] mrPlrUl9 = new double[28];
		double[] mrPlrDl6 = new double[28];
		double[] mrPlrDl8 = new double[28];
		double[] mrPlrDl9 = new double[28];
		double[] mrSinrUl = new double[37];
		double[] UL = new double[28];
		double[] DL = new double[28];
		 ResultSet  rs=j1.executeQuery(s2); 
		 try {
				while(rs.next()) {				  
					  id=rs.getInt("Id");
					  returnview2 r1=new returnview2(id);
					  boolean ww= r1.jisuan();
					  if(!ww) continue;
					  ee=r1.getEe();
					  eUL_SINR=r1.geteUL_SINR();
					  eRSRP=r1.geteRSRP();
					  eRSRQ=r1.geteRSRQ();
					  eUL_PLR=r1.geteUL_PLR();
					  eUL=r1.geteUL();
					  eDL=r1.geteDL();
					  eDL_PLR=r1.geteDL_PLR();
					  mrRSRP=r1.getMrRSRP();
					  mrRSRQ=r1.getMrRSRQ();
					  mrPlrUl6=r1.getMrPlrUl6();
						 mrPlrUl8=r1.getMrPlrUl8();
						 mrPlrUl9=r1.getMrPlrUl9();
						 mrPlrDl6=r1.getMrPlrDl6();
						 mrPlrDl8=r1.getMrPlrDl8();
						 mrPlrDl9=r1.getMrPlrDl9();
					     mrSinrUl=r1.getMrSinrUl();
					     indexRsrp=r1.getIndexRsrp();
					     indexExpRsrq=r1.getIndexRsrq();
					     indexExpRsrp=r1.getIndexExpRsrp();
					     indexExpRsrq=r1.getIndexExpRsrq();
					     indexExpSinrUl=r1.getIndexExpSinrUl();
					     for(int i=0;i<UL.length;i++)
							{
								UL[i]=mrPlrUl6[i]+mrPlrUl8[i]+mrPlrUl9[i];
								DL[i]=mrPlrDl6[i]+mrPlrDl8[i]+mrPlrDl9[i];
							}
						    for(int j=0;j<mrRSRP.length;j++)
						    {
						    	mrRP=mrRP+mrRSRP[j]+',';
						    }
						    for(int h=0;h<mrRSRQ.length;h++)
						    {
						    	mrRQ=mrRQ+mrRSRQ[h]+',';
						    }
						    for(int t=0;t<UL.length;t++)
						    {
						    	mrUL=mrUL+UL[t]+',';
						    }
						    for(int p=0;p<DL.length;p++)
						    {
						    	mrDL=mrDL+DL[p]+',';
						    }
						    for(int s=0;s<mrSinrUl.length;s++)
						    {
						    	mrSL=mrSL+mrSinrUl[s]+',';
						    }					  
					  s3="update data set e='"+ee+"',sign=1,mrRP='"+mrRP+"',mrRQ='"+mrRQ+"',mrDL='"+mrDL+"',mrUL='"+mrUL+"',mrSL='"+mrSL+"',eUL_SINR='"+eUL_SINR+"',eRSRP='"+eRSRP+"',eRSRQ='"+eRSRQ+"',eUL_PLR='"+eUL_PLR+"',eUL='"+eUL+"',eDL='"+eDL+"',eDL_PLR='"+eDL_PLR+"',indexRsrp="+indexRsrp+",indexRsrq="+indexRsrq+",indexExpRsrp="+indexExpRsrp+",indexExpRsrq="+indexExpRsrq+",indexExpSinrUl="+indexExpSinrUl+" where Id="+id+"";
					  System.out.println(s3);
					  boolean r=j1.executeUpdate(s3);	
					  System.out.println(r+"成功一次"+id);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
}
}