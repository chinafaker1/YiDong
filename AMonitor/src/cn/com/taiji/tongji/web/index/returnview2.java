package cn.com.taiji.tongji.web.index;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import analysis.Effect;
import analysis.MrData;
import analysis.UeData;
import cn.com.taiji.tongji.dao.Jdbc;

public class returnview2 {
private int id;
private String ee;
private String MemRate;
private String cpuRate;
private String eUL_SINR;
private String eRSRP;
private String eRSRQ;
private String eUL_PLR;
private String eUL;
private String eDL;
private String eDL_PLR;
private int indexRsrp;
private int indexRsrq;
private int indexExpRsrp;
private int indexExpRsrq;
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

public int getIndexExpRsrp() {
	return indexExpRsrp;
}
public void setIndexExpRsrp(int indexExpRsrp) {
	this.indexExpRsrp = indexExpRsrp;
}
public int getIndexExpRsrq() {
	return indexExpRsrq;
}
public void setIndexExpRsrq(int indexExpRsrq) {
	this.indexExpRsrq = indexExpRsrq;
}
public int getIndexExpSinrUl() {
	return indexExpSinrUl;
}
public void setIndexExpSinrUl(int indexExpSinrUl) {
	this.indexExpSinrUl = indexExpSinrUl;
}
public String geteUL_SINR() {
	return eUL_SINR;
}
public void seteUL_SINR(String eUL_SINR) {
	this.eUL_SINR = eUL_SINR;
}
public String geteRSRP() {
	return eRSRP;
}
public void seteRSRP(String eRSRP) {
	this.eRSRP = eRSRP;
}
public String geteRSRQ() {
	return eRSRQ;
}
public void seteRSRQ(String eRSRQ) {
	this.eRSRQ = eRSRQ;
}
public String geteUL_PLR() {
	return eUL_PLR;
}
public void seteUL_PLR(String eUL_PLR) {
	this.eUL_PLR = eUL_PLR;
}
public String geteUL() {
	return eUL;
}
public void seteUL(String eUL) {
	this.eUL = eUL;
}
public String geteDL() {
	return eDL;
}
public void seteDL(String eDL) {
	this.eDL = eDL;
}
public String geteDL_PLR() {
	return eDL_PLR;
}
public void seteDL_PLR(String eDL_PLR) {
	this.eDL_PLR = eDL_PLR;
}
private ResultSet rs;
double[] mrRSRP=new double[48];
double[] mrRSRQ=new double[18];
public double[] getMrRSRP() {
	return mrRSRP;
}
public void setMrRSRP(double[] mrRSRP) {
	this.mrRSRP = mrRSRP;
}
public double[] getMrRSRQ() {
	return mrRSRQ;
}
public void setMrRSRQ(double[] mrRSRQ) {
	this.mrRSRQ = mrRSRQ;
}
public double[] getMrPlrUl6() {
	return mrPlrUl6;
}
public void setMrPlrUl6(double[] mrPlrUl6) {
	this.mrPlrUl6 = mrPlrUl6;
}
public double[] getMrPlrUl8() {
	return mrPlrUl8;
}
public void setMrPlrUl8(double[] mrPlrUl8) {
	this.mrPlrUl8 = mrPlrUl8;
}
public double[] getMrPlrUl9() {
	return mrPlrUl9;
}
public void setMrPlrUl9(double[] mrPlrUl9) {
	this.mrPlrUl9 = mrPlrUl9;
}
public double[] getMrPlrDl6() {
	return mrPlrDl6;
}
public void setMrPlrDl6(double[] mrPlrDl6) {
	this.mrPlrDl6 = mrPlrDl6;
}
public double[] getMrPlrDl8() {
	return mrPlrDl8;
}
public void setMrPlrDl8(double[] mrPlrDl8) {
	this.mrPlrDl8 = mrPlrDl8;
}
public double[] getMrPlrDl9() {
	return mrPlrDl9;
}
public void setMrPlrDl9(double[] mrPlrDl9) {
	this.mrPlrDl9 = mrPlrDl9;
}
public double[] getMrSinrUl() {
	return mrSinrUl;
}
public void setMrSinrUl(double[] mrSinrUl) {
	this.mrSinrUl = mrSinrUl;
}
double[] mrPlrUl6=new double[28];
double[] mrPlrUl8=new double[28];
double[] mrPlrUl9=new double[28];
double[] mrPlrDl6=new double[28];
double[] mrPlrDl8=new double[28];
double[] mrPlrDl9=new double[28];
double[] mrSinrUl=new double[37];
boolean qq=false;
public boolean isQq() {
	return qq;
}
public void setQq(boolean qq) {
	this.qq = qq;
}
public boolean jisuan()
{

	    String ueRSRP="";
	    String ueRSRQ="";
		String[] launtime1=new String[2];
		String[] launtime2=new String[3];
		String stime="";
		String total="";
			 Jdbc j1=new Jdbc();
			 String s2="select * from data1 where ReId="+id+""; 
			 rs=j1.executeQuery(s2);
			
			
			    try {
					if(rs.next()) {
						String launtime=rs.getString("Time");
						String LAC=rs.getString("ENODBID");
						String Cell_Id=rs.getString("CELLID");	
						launtime1=launtime.split(" ");
						launtime2=launtime1[0].split("-");
						for(int i=0;i<launtime2.length;i++)
						{
							if(launtime2[i].charAt(0)>'0'&&i<2)
								stime=stime+launtime2[i]+"/";
							else if(launtime2[i].charAt(0)>'0'&&i==2)
								stime=stime+launtime2[i];
							else if(i<2)
								stime+=launtime2[i].charAt(1)+"/";
							else
								stime+=launtime2[i].charAt(1);		
						}
						total=stime+LAC+Cell_Id;
						//						total="2016/6/1"+"460-00-499228"+"11";
				     System.out.println(total);
					ueRSRP=ueRSRP+rs.getString("RSRP")+" ";
					ueRSRQ=ueRSRQ+rs.getString("RSRQ")+" ";
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return false;
				}
			 String s="select * from data where Id="+id+"";  
			 rs=j1.executeQuery(s);
			
			
			    try {
					while(rs.next()) {
								
					this.MemRate=rs.getString("MemRate");
					this.cpuRate=rs.getString("cpuRate");
					
					
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return false;
				}
			    String s1="select * from rsrp";
				String total1="";  
			    rs=j1.executeQuery(s1);
				 
			    try {
					while(rs.next()) {
					total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
					if(total1.equals(total))
					{
						this.qq=true;
					for(int j=0;j<mrRSRP.length;j++)
					{
						if(j<10)
							mrRSRP[j]=rs.getInt("RSRP_0"+j);
						else
							mrRSRP[j]=rs.getInt("RSRP_"+j);
					}
					break;
					}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return false;
				}
		if(this.qq) this.qq=false;
		else return false;
		String s3="select * from rsrq";
		rs=j1.executeQuery(s3);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrRSRQ.length;j++)
			{
				if(j<10)
					mrRSRQ[j]=rs.getInt("RSRQ_0"+j);
				else
					mrRSRQ[j]=rs.getInt("RSRQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s4="select * from plrdl where QCI=6";
	    rs=j1.executeQuery(s4);
		 
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrDl6.length;j++)
			{
				if(j<10)
					mrPlrDl6[j]=rs.getInt("PacketLRDLQ_0"+j);
				else
					mrPlrDl6[j]=rs.getInt("PacketLRDLQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s5="select * from plrdl where QCI=8";
	    rs=j1.executeQuery(s5);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrDl8.length;j++)
			{
				if(j<10)
					mrPlrDl8[j]=rs.getInt("PacketLRDLQ_0"+j);
				else
					mrPlrDl8[j]=rs.getInt("PacketLRDLQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s6="select * from plrdl where QCI=8";
	    rs=j1.executeQuery(s6);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrDl8.length;j++)
			{
				if(j<10)
					mrPlrDl8[j]=rs.getInt("PacketLRDLQ_0"+j);
				else
					mrPlrDl8[j]=rs.getInt("PacketLRDLQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s7="select * from plrdl where QCI=9";
	    rs=j1.executeQuery(s7);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrDl9.length;j++)
			{
				if(j<10)
					mrPlrDl9[j]=rs.getInt("PacketLRDLQ_0"+j);
				else
					mrPlrDl9[j]=rs.getInt("PacketLRDLQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s8="select * from plrul where QCI=6";
	    rs=j1.executeQuery(s8);
		 
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrUl6.length;j++)
			{
				if(j<10)
					mrPlrUl6[j]=rs.getInt("PacketLRULQ_0"+j);
				else
					mrPlrUl6[j]=rs.getInt("PacketLRULQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s9="select * from plrul where QCI=8";
	    rs=j1.executeQuery(s9);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrUl8.length;j++)
			{
				if(j<10)
					mrPlrUl8[j]=rs.getInt("PacketLRULQ_0"+j);
				else
					mrPlrUl8[j]=rs.getInt("PacketLRULQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s10="select * from plrul where QCI=9";
	    rs=j1.executeQuery(s10);
		
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrPlrUl9.length;j++)
			{
				if(j<10)
					mrPlrUl9[j]=rs.getInt("PacketLRULQ_0"+j);
				else
					mrPlrUl9[j]=rs.getInt("PacketLRULQ_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
	    String s11="select * from sinrul";
	    rs=j1.executeQuery(s11);
		 
	    try {
			while(rs.next()) {
			total1=rs.getString("date")+rs.getString("Enodeb_id")+rs.getInt("Eutrancell_id");
			if(total1.equals(total))
			{
				this.qq=true;
			for(int j=0;j<mrSinrUl.length;j++)
			{
				if(j<10)
					mrSinrUl[j]=rs.getInt("SinrUL_0"+j);
				else
					mrSinrUl[j]=rs.getInt("SinrUL_"+j);
			}
			break;
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	    if(this.qq) this.qq=false;
		else return false;
		MrData mrData = new MrData(mrRSRP,mrRSRQ,mrPlrUl6,mrPlrUl8,mrPlrUl9,mrPlrDl6,mrPlrDl8,mrPlrDl9,mrSinrUl);
	    UeData ueData = new UeData(ueRSRP, ueRSRQ);
	    Effect effect = new Effect(ueData, mrData);
	    DecimalFormat df = new DecimalFormat("#.00"); 
//		BigDecimal bg8 = new BigDecimal(effect.getE()*100); 
//		double ee=bg8.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	    this.ee=df.format(effect.getE()*100);
	    this.eUL_PLR=df.format(effect.geteUlPlr()*100);
	    this.eRSRP=df.format(effect.geteRsrp()*100);
	    this.eRSRQ=df.format(effect.geteRsrq()*100);
	    this.eUL_SINR=df.format(effect.geteUlSinr()*100);
	    this.eUL=df.format(effect.geteUl()*100);
	    this.eDL=df.format(effect.geteDl()*100);
	    this.eDL_PLR=df.format(effect.geteDlPlr()*100);
	    this.indexRsrp=ueData.getIndexRsrp();
	    this.indexRsrq=ueData.getIndexRsrq();
	    this.indexExpRsrp=mrData.getIndexExpRsrp();
	    this.indexExpRsrq=mrData.getIndexExpRsrq();
	    this.indexExpSinrUl=mrData.getIndexExpSinrUl();
	    String[] aa=MemRate.split("%");
	    this.MemRate=aa[0];
	    String[] bb=cpuRate.split("%");
	    this.cpuRate=bb[0];
	    return true;
}
public String getEe() {
	return ee;
}
public void setEe(String ee) {
	this.ee = ee;
}
public String getMemRate() {
	return MemRate;
}
public void setMemRate(String memRate) {
	MemRate = memRate;
}
public String getCpuRate() {
	return cpuRate;
}
public void setCpuRate(String cpuRate) {
	this.cpuRate = cpuRate;
}
public returnview2() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public returnview2(int i)
{
	this.id=i;
}

}
