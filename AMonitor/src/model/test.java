package model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.util.Calendar;
import java.util.List;
public class test extends ActionSupport{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction trans=session.beginTransaction();
	    String hql="from BitData";
	    List<BitData> list= session.createQuery(hql).list();
	    for(BitData bitData:list)
	    {
	    	System.out.println(bitData.getAppName());
	    }
	    trans.commit();
	    session.close();
	    sf.close();
	}
private String result;
private String brand;
private Calendar stime;
private Calendar etime;

public Calendar getStime() {
	return stime;
}
public void setStime(Calendar stime) {
	this.stime = stime;
}
public Calendar getEtime() {
	return etime;
}
public void setEtime(Calendar etime) {
	this.etime = etime;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
private List<BitData> list;
   public String haha()
   {  
	   try {
	   Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction trans=session.beginTransaction();
	    String hql="from BitData where brand='"+brand+"' ";
	    list= session.createQuery(hql).list();
	    for(BitData bitData:list)
	    {
	    	System.out.println(bitData.getAppName());
	    }
	    trans.commit();
	    session.close();
	    sf.close();
	    System.out.println("tttttttttttt");
	   result="错啦";
} catch (Exception e) {
	e.printStackTrace();
}
		
	   return SUCCESS;
   }
   public List<BitData> getList() {
	return list;
}
public void setList(List<BitData> list) {
	this.list = list;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String rr()
   {
	   return SUCCESS; 
   }
}
