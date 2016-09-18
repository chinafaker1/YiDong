package cn.com.taiji.tongji.web.index;

import java.sql.ResultSet;

import cn.com.taiji.tongji.dao.Jdbc;

public class returnview1 {
	private ResultSet rs;
	private String ee;
	private String MemRate;
	private String cpuRate;
	private String mrRP;
	private String mrRQ;
	private String mrDL;
	private String mrUL;
	private String mrSL;
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
	public String getMrRP() {
		return mrRP;
	}
	public void setMrRP(String mrRP) {
		this.mrRP = mrRP;
	}
	public String getMrRQ() {
		return mrRQ;
	}
	public void setMrRQ(String mrRQ) {
		this.mrRQ = mrRQ;
	}
	public String getMrDL() {
		return mrDL;
	}
	public void setMrDL(String mrDL) {
		this.mrDL = mrDL;
	}
	public String getMrUL() {
		return mrUL;
	}
	public void setMrUL(String mrUL) {
		this.mrUL = mrUL;
	}
	public String getMrSL() {
		return mrSL;
	}
	public void setMrSL(String mrSL) {
		this.mrSL = mrSL;
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
	public boolean  jisuan(int id) 
	{
		Jdbc j1=new Jdbc();
		 String s="select * from data where Id="+id+"";  
		 rs=j1.executeQuery(s);
		    try {
				while(rs.next()) {
					this.MemRate=rs.getString("MemRate");
					this.cpuRate=rs.getString("cpuRate");
					String[] aa=MemRate.split("%");
					this.MemRate=aa[0];
					String[] bb=cpuRate.split("%");
					this.cpuRate=bb[0];
					if (rs.getInt("sign")==0) {
						return false;
					}
					
					this.eUL_SINR=rs.getString("eUL_SINR");
					this.eRSRP=rs.getString("eRSRP");
					this.eRSRQ=rs.getString("eRSRQ");
					this.eUL_PLR=rs.getString("eUL_PLR");
					this.eUL=rs.getString("eUL");
					this.eDL=rs.getString("eDL");
					this.eDL_PLR=rs.getString("eDL_PLR");
					this.mrRP=rs.getString("mrRP");
					this.mrRQ=rs.getString("mrRQ");
					this.mrDL=rs.getString("mrDL");
					this.mrUL=rs.getString("mrUL");
					this.mrSL=rs.getString("mrSL");
					this.indexRsrp=rs.getInt("indexRsrp");
					this.indexRsrq=rs.getInt("indexRsrq");
					this.indexExpRsrp=rs.getInt("indexExpRsrp");
					this.indexExpRsrq=rs.getInt("indexExpRsrq");
					this.indexExpSinrUl=rs.getInt("indexExpSinrUl");
					this.ee=rs.getString("e");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		   
		    return true;
	}
	 
}
