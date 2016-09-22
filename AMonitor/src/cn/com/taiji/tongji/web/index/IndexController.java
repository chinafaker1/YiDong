package cn.com.taiji.tongji.web.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ibm.db2.jcc.a.b;
import com.sun.org.apache.bcel.internal.generic.NEW;

import analysis.Effect;
import analysis.MrData;
import analysis.UeData;
import cn.com.taiji.common.manager.net.http.HttpMimeResponseHelper;
import cn.com.taiji.common.model.dao.Pagination;
import cn.com.taiji.common.pub.StringTools;
import cn.com.taiji.common.pub.dao.HqlBuilder;
import cn.com.taiji.tongji.entity.statics.BitData1;
import cn.com.taiji.tongji.entity.statics.PGG;
import cn.com.taiji.tongji.manager.statics.BitAlertDataManager;
import cn.com.taiji.tongji.manager.statics.BitDataManager;
import cn.com.taiji.tongji.model.MySystemParam;
import cn.com.taiji.tongji.model.enums.BitDataEnum;
import cn.com.taiji.tongji.model.statics.BitAlertDataModel;
import cn.com.taiji.tongji.model.statics.BitDataModel;
import cn.com.taiji.tongji.model.statics.BitDataView;
import cn.com.taiji.tongji.web.BaseLogController;
import model.BitData;
import model.send;
import cn.com.taiji.tongji.dao.Jdbc;
import cn.com.taiji.tongji.dao.jpa.statics.BitDataDaoJpa;
/**   
*      
* 类描述：   
* 创建人：王金鑫  
* 创建时间：2015年11月21日 下午9:52:05   
* 修改人：王金鑫     
* 修改时间：2015年11月21日 下午9:52:05   
* 修改备注：   
* @version    
*    
*/
@Controller("indexWebController")
public class IndexController extends BaseLogController
{
	@Autowired
	private BitDataManager bitDataManager;
	@Autowired
	private BitAlertDataManager bitAlertDataManager;
	private List<BitData1> list;
	private ResultSet rs;
	private BitData1 data1;
	private BitDataModel b1=new BitDataModel();
	private BitData data=new BitData();
	public List<BitData1> getList() {
		return list;
	}
	public void setList(List<BitData1> list) {
		this.list = list;
	}
	@RequestMapping(value = "/common/bitData/index", method = RequestMethod.GET)
	public String bitDataGet(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{
	
		if(StringTools.hasText(queryModel.getHour())){
			switch(queryModel.getHour())
			{
			case MySystemParam.NOW:
				break;
			case MySystemParam.ONEHOUR:
				Calendar now=Calendar.getInstance();
				now.add(Calendar.HOUR_OF_DAY, -1);
				model.addAttribute("endTime",now);
				break;
			case MySystemParam.HOUR24:
				Calendar endTime=Calendar.getInstance();
				endTime.add(Calendar.HOUR_OF_DAY, -24);
				model.addAttribute("endTime",endTime);
				break;
			}
		}
		return "web/bitData/index";
	}
	@RequestMapping(value = "/common/bitData/index", method = RequestMethod.POST)
	public String bitDataPost(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{
		
		
		model.addAttribute("pagn",this.bitDataManager.queryPagn(queryModel));
		return "web/bitData/queryResult";
	}
	@RequestMapping(value = "/common/bitData/index/tongji", method = RequestMethod.GET)
	public String bitDataPost2(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{ 	
		return "web/bitData/22";
	}
	@RequestMapping(value = "/common/bitData/index/test", method = RequestMethod.POST)
	public void test(HttpServletRequest request,PrintWriter printWriter)
	{   
	    String aString=JSON.toJSONString("eeeeeeeeeee");
	    printWriter.write(aString);
        printWriter.flush();
        printWriter.close();
	
	}
	@RequestMapping(value = "/common/bitData/index/test/{id}")
	public String analysisview(HttpServletRequest request,@PathVariable("id")Integer id,HttpServletResponse response,Model model)
	{   
	
    returnview1 r1=new returnview1();
    boolean ww=r1.jisuan(id);
    if(!ww)
    {
    	return "web/bitData/false";
    }
    String cpuRate=r1.getCpuRate();
    String MemRate=r1.getMemRate();
    String ee=r1.getEe();
    String mrRP=r1.getMrRP();
	String mrRQ=r1.getMrRQ();
	String mrDL=r1.getMrDL();
	String mrUL=r1.getMrUL();
	String mrSL=r1.getMrSL();
	String eUL_SINR=r1.geteUL_SINR();
	String eRSRP=r1.geteRSRP();
	String eRSRQ=r1.geteRSRQ();
	String eUL_PLR=r1.geteUL_PLR();
	String eUL=r1.geteUL();
	String eDL=r1.geteDL();
	String eDL_PLR=r1.geteDL_PLR();
	int indexRsrp=r1.getIndexRsrp();
	int indexRsrq=r1.getIndexRsrq();
	int indexExpRsrp=r1.getIndexExpRsrp();
	int indexExpRsrq=r1.getIndexExpRsrq();
	int indexExpSinrUl=r1.getIndexExpSinrUl();
    model.addAttribute("cpuRate",cpuRate);
    model.addAttribute("MemRate",MemRate);
	model.addAttribute("ee",ee);
	model.addAttribute("mrRP",mrRP);
	model.addAttribute("mrRQ",mrRQ);
	model.addAttribute("mrDL",mrDL);
	model.addAttribute("mrUL",mrUL);
	model.addAttribute("mrSL",mrSL);
	model.addAttribute("eUL_SINR",eUL_SINR);
	model.addAttribute("eRSRP",eRSRP);
	model.addAttribute("eRSRQ",eRSRQ);
	model.addAttribute("eUL_PLR",eUL_PLR);
	model.addAttribute("eUL",eUL);
	model.addAttribute("eDL",eDL);
	model.addAttribute("eDL_PLR",eDL_PLR);
	model.addAttribute("indexRsrp",indexRsrp);
	model.addAttribute("indexRsrq",indexRsrq);
	model.addAttribute("indexExpRsrp",indexExpRsrp);
	model.addAttribute("indexExpRsrq",indexExpRsrq);
	model.addAttribute("indexExpSinrUl",indexExpSinrUl);
	return "web/bitData/view2";
	}
	@RequestMapping(value = "/common/bitData/download.jsp")
	public String bitDataPost1(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{         
		return "web/bitData/download";
	}
	@RequestMapping(value = "/common/bitData/downloadhelp.jsp")
	public String downhelp(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{         
		return "web/bitData/downloadhelp";
	}
	@RequestMapping(value = "/common/bitData/view/{id}")
	public String view(HttpServletRequest request,@PathVariable("id")Integer id,HttpServletResponse response,Model model)
	{  
		String Rsrp="";
		String Sinr="";
		int sign=0;
		int sign1=0;
		list = new LinkedList<BitData1>();
        Jdbc j1=new Jdbc();
        String s="select * from data1 where ReId="+id+"";   
        rs=j1.executeQuery(s);
        try {
		while(rs.next()) {
		data1=new BitData1();
		data1.setId(rs.getInt("Id"));			
		data1.setTimeStamp(rs.getString("Time"));
		data1.setRsrp(rs.getString("RSRP"));			
	    data1.setRsrq(rs.getString("RSRQ"));
		data1.setRssinr(rs.getString("RSSINR"));
		data1.setTxByte(rs.getString("TxByte"));
		data1.setRxByte(rs.getString("RxByte"));
		data1.setPci(rs.getString("PCI"));
		data1.setCi(rs.getString("CI"));
		data1.setEnodbId(rs.getString("ENODBID"));
		data1.setCellId(rs.getString("CELLID"));
		data1.setTac(rs.getString("TAC"));
		data1.setNetType(rs.getString("NetType"));
		Rsrp=Rsrp+rs.getString("RSRP")+" ";
		Sinr=Sinr+rs.getString("RSSINR")+" ";
		list.add(data1);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
   
    PGG pg=new PGG();
    pg.setList(list);
	model.addAttribute("pg",pg);
	model.addAttribute("vo",this.bitDataManager.findById(id));
		 returnview1 r1=new returnview1();
		    boolean ww=r1.jisuan(id);
		    String cpuRate=r1.getCpuRate();
		    String MemRate=r1.getMemRate();
		    model.addAttribute("cpuRate",cpuRate);
		    model.addAttribute("MemRate",MemRate);
		   
		    
		    	 UeData ueData=new UeData();
		    	    ueData.UeData1(Rsrp, Sinr);
		    	    String txtRsrp="";
		    	    String txtCpuRate="";
		    	    String txtMemRate="";
		    	    String other="";
		    	    
		    	    java.text.DecimalFormat df =new   java.text.DecimalFormat("#.00");  
		    	    model.addAttribute("expRsrp",ueData.getExpRsrp());
		    	    model.addAttribute("expSinr", df.format(ueData.getExpSinr()));
		    	    if(ueData.getExpRsrp()<=-105&&ueData.getExpSinr()<=3)
				    {
				    	txtRsrp="网络覆盖较弱";
				    	sign=1;
				    }
				    else if(ueData.getExpRsrp()>-105&&ueData.getExpSinr()<=3)
				    {
				    	txtRsrp="网络覆盖较强";
				    	sign=1;
				    }
				    if( Double.valueOf(cpuRate)>=90)
				    {
				    	txtCpuRate="终端CPU使用率过高";
				    	sign=1;
				    	sign1=1;
				    }
				    if( Double.valueOf(MemRate)>=90)
				    {
				    	txtMemRate="终端内存使用率过高";
				    	sign=1;
				    	sign1=1;
				    }
				    if(sign==0)
				    {
				    	other="是";
				    }
				    else {
						other="否";
					}
				model.addAttribute("txtRsrp",txtRsrp);
			    model.addAttribute("txtCpuRate",txtCpuRate);
				model.addAttribute("txtMemRate",txtMemRate);
				model.addAttribute("other",other);
				if(!ww)
			    {
		    	return "web/bitData/false";
		    }
		   
		    String ee=r1.getEe();
		    String mrRP=r1.getMrRP();
			String mrRQ=r1.getMrRQ();
			String mrDL=r1.getMrDL();
			String mrUL=r1.getMrUL();
			String mrSL=r1.getMrSL();
			String eUL_SINR=r1.geteUL_SINR();
			String eRSRP=r1.geteRSRP();
			String eRSRQ=r1.geteRSRQ();
			String eUL_PLR=r1.geteUL_PLR();
			String eUL=r1.geteUL();
			String eDL=r1.geteDL();
			String eDL_PLR=r1.geteDL_PLR();
			int indexRsrp=r1.getIndexRsrp();
			int indexRsrq=r1.getIndexRsrq();
			int indexExpRsrp=r1.getIndexExpRsrp();
			int indexExpRsrq=r1.getIndexExpRsrq();
			int indexExpSinrUl=r1.getIndexExpSinrUl();	
			String txte="";
			model.addAttribute("ee",ee);
			if(Double.valueOf(ee)>=50)
			{
			txte="无线环境影响较大";
			sign1=1;
			}
			model.addAttribute("txte",txte);
			String other1="";
			if(sign1==0) other1="其它因素影响";
			model.addAttribute("other1",other1);
			model.addAttribute("mrRP",mrRP);
			model.addAttribute("mrRQ",mrRQ);
			model.addAttribute("mrDL",mrDL);
			model.addAttribute("mrUL",mrUL);
			model.addAttribute("mrSL",mrSL);
			model.addAttribute("eUL_SINR",eUL_SINR);
			model.addAttribute("eRSRP",eRSRP);
			model.addAttribute("eRSRQ",eRSRQ);
			model.addAttribute("eUL_PLR",eUL_PLR);
			model.addAttribute("eUL",eUL);
			model.addAttribute("eDL",eDL);
			model.addAttribute("eDL_PLR",eDL_PLR);
			String compareE="RSRP";
			double comE=Double.valueOf(eRSRP);
			if(Double.valueOf(eRSRQ)>comE) {compareE="RSRQ";comE=Double.valueOf(eRSRQ);}
			if(Double.valueOf(eUL)>comE) {compareE="PacketLossRateUL";comE=Double.valueOf(eUL);}
			if(Double.valueOf(eDL)>comE) {compareE="PacketLossRateDL";comE=Double.valueOf(eDL);}
			if(Double.valueOf(eUL_SINR)>comE) {compareE="SinrUL";comE=Double.valueOf(eUL_SINR);}
			model.addAttribute("compareE",compareE);
			model.addAttribute("indexRsrp",indexRsrp);
			model.addAttribute("indexRsrq",indexRsrq);
			model.addAttribute("indexExpRsrp",indexExpRsrp);
			model.addAttribute("indexExpRsrq",indexExpRsrq);
			model.addAttribute("indexExpSinrUl",indexExpSinrUl);		
		return "web/bitData/view3";
	}
	//3.业务异常信息查询
	@RequestMapping(value = "/common/exceptQueryData/index", method = RequestMethod.GET)
	public String exceptQueryDataGet(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{
		return "web/exceptQueryData/index";
	}
	
	@RequestMapping(value = "/common/exceptQueryData/index/tongji")
	public String exceptQueryDataPost1(HttpServletRequest request ,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
{     
//		HqlBuilder hql = new HqlBuilder("from BitData where 1=1 ");
//		if(StringTools.hasText(queryModel.getBrand()))hql.append(" and brand like :brand ","%"+b1.getBrand()+"%");
//		hql.append(" and launtime >=:startTime ",b1.getStartTime());
//		hql.append(" and launtime <=:endTime ",b1.getEndTime());
//		hql.append(" order by launtime desc,id asc ");
//		System.out.println(b1.getBrand()+"tttttttttttttttt");
//		Configuration cfg = new Configuration();
//		SessionFactory sf = cfg.configure().buildSessionFactory();
//	    Session session = sf.openSession();
//	    Transaction trans=session.beginTransaction();
//	    List<BitData> list= session.createQuery(hql.toString()).list();
//	    for(BitData bitData:list)
//	    {
//	    	System.out.println(bitData.getAppName());
//	    }
//	    trans.commit();
//	    session.close();
//	    sf.close();
		 Jdbc j1=new Jdbc();
		 String s;
		 java.util.Date sdate =b1.getStartTime().getTime();
		 java.util.Date edate =b1.getEndTime().getTime();
		 DateFormat  sdf2=new SimpleDateFormat("yyyy-MM-dd");
		 String sDate=sdf2.format(sdate);
		 String eDate=sdf2.format(edate);

//		 if(b1.getBrand()==null)
//		 {
//		  s="select * from data where brand like '%%'";
//		 }
//		 else
//			 s="select * from data where brand like '%"+b1.getBrand()+"%'";
		 s="select * from data where brand like '%"+b1.getBrand()+"%' and excepType like '%"+b1.getExcepType()+"%' and addr like '%"+b1.getAddr()+"%' and  version like '%"+b1.getVersion()+"%' and type like '%"+b1.getType()+"%' and localIp like '%"+b1.getLocalIp()+"%' and AppName like '%"+b1.getAppName()+"%' and IMEI like '%"+b1.getIMEI()+"%' and IMSI like '%"+b1.getIMSI()+"%' and  Cell_Id like '%"+b1.getCid()+"%' and LAC like '%"+b1.getLAC()+"%' and launtime > '"+sDate+"' and launtime < '"+eDate+"' and sign=1";

		 double a=0;
	     double b=0;
	     double c=0;
		 int[] aa=new int[10];
		 int[] bb=new int[10];
		 int[] cc=new int[10];
		 for(int i=0;i<aa.length;i++)
		 {
			 aa[i]=0;
			 bb[i]=0;
			 cc[i]=0;
		 }
         int t=0;
		    rs=j1.executeQuery(s);
		    try {
				while(rs.next()) {
				String s4=rs.getString("MemRate");
				String[] ww=s4.split("%");
				double s6=Double.valueOf(ww[0]);
				
				if(s6>=0 && s6<10)
					cc[0]+=1;
				else if(s6>=10 && s6<20)
					cc[1]+=1;
				else if(s6>=20 && s6<30)
					cc[2]+=1;
				else if(s6>=30 && s6<40)
					cc[3]+=1;
				else if(s6>=40 && s6<50)
					cc[4]+=1;
				else if(s6>=50 && s6<60)
					cc[5]+=1;
				else if(s6>=60 && s6<70)
					cc[6]+=1;
				else if(s6>=70 && s6<80)
					cc[7]+=1;
				else if(s6>=80 && s6<90)
					cc[8]+=1;
				else if(s6>=90 && s6<100)
					cc[9]+=1;
				c+=s6;
				String s2=rs.getString("cpuRate");
				String[] tt=s2.split("%");
				double s3=Double.valueOf(tt[0]);
				if(s3>=0 && s3<10)
					bb[0]+=1;
				else if(s3>=10 && s3<20)
					bb[1]+=1;
				else if(s3>=20 && s3<30)
					bb[2]+=1;
				else if(s3>=30 && s3<40)
					bb[3]+=1;
				else if(s3>=40 && s3<50)
					bb[4]+=1;
				else if(s3>=50 && s3<60)
					bb[5]+=1;
				else if(s3>=60 && s3<70)
					bb[6]+=1;
				else if(s3>=70 && s3<80)
					bb[7]+=1;
				else if(s3>=80 && s3<90)
					bb[8]+=1;
				else if(s3>=90 && s3<100)
					bb[9]+=1;
				b+=s3;
				double s1=Double.valueOf(rs.getString("e").toString());
				if(s1>=0 && s1<10)
					aa[0]+=1;
				else if(s1>=10 && s1<20)
					aa[1]+=1;
				else if(s1>=20 && s1<30)
					aa[2]+=1;
				else if(s1>=30 && s1<40)
					aa[3]+=1;
				else if(s1>=40 && s1<50)
					aa[4]+=1;
				else if(s1>=50 && s1<60)
					aa[5]+=1;
				else if(s1>=60 && s1<70)
					aa[6]+=1;
				else if(s1>=70 && s1<80)
					aa[7]+=1;
				else if(s1>=80 && s1<90)
					aa[8]+=1;
				else if(s1>=90 && s1<100)
					aa[9]+=1;
				a+=s1;
				t+=1;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
        a=a/t;
        b=b/t;
        c=c/t;
        String txte="";
        String txtCpu="";
        String txtMem="";
        if(a>=50) txte="高";
        else if(a>=30 && a<50) txte="中";
        else txte="低";
        if(b>=90) txtCpu="高";
        else if(b>=70 && b<90) txtCpu="中";
        else txtCpu="低";
        if(c>=90) txtMem="高";
        else if(c>=70 && c<90) txtMem="中";
        else txtMem="低";
        model.addAttribute("txte",txte);
        model.addAttribute("txtCpu",txtCpu);
        model.addAttribute("txtMem",txtMem);
        if(a>=0 && a<10)
			a=0;
		else if(a>=10 && a<20)
			a=1;
		else if(a>=20 && a<30)
			a=2;
		else if(a>=30 && a<40)
			a=3;
		else if(a>=40 && a<50)
			a=4;
		else if(a>=50 && a<60)
			a=5;
		else if(a>=60 && a<70)
			a=6;
		else if(a>=70 && a<80)
			a=7;
		else if(a>=80 && a<90)
			a=8;
		else if(a>=90 && a<100)
			a=9;
        if(b>=0 && b<10)
			b=0;
		else if(b>=10 && b<20)
			b=1;
		else if(b>=20 && b<30)
			b=2;
		else if(b>=30 && b<40)
			b=3;
		else if(b>=40 && b<50)
			b=4;
		else if(b>=50 && b<60)
			b=5;
		else if(b>=60 && b<70)
			b=6;
		else if(b>=70 && b<80)
			b=7;
		else if(b>=80 && b<90)
			b=8;
		else if(b>=90 && b<100)
			b=9;
        if(c>=0 && c<10)
			c=0;
		else if(c>=10 && c<20)
			c=1;
		else if(c>=20 && c<30)
			c=2;
		else if(c>=30 && c<40)
			c=3;
		else if(c>=40 && c<50)
			c=4;
		else if(c>=50 && c<60)
			c=5;
		else if(c>=60 && c<70)
			c=6;
		else if(c>=70 && c<80)
			c=7;
		else if(c>=80 && c<90)
			c=8;
		else if(c>=90 && c<100)
			c=9;
        
		model.addAttribute("aa0",aa[0]);
		model.addAttribute("aa1",aa[1]);
		model.addAttribute("aa2",aa[2]);
		model.addAttribute("aa3",aa[3]);
		model.addAttribute("aa4",aa[4]);
		model.addAttribute("aa5",aa[5]);
		model.addAttribute("aa6",aa[6]);
		model.addAttribute("aa7",aa[7]);
		model.addAttribute("aa8",aa[8]);
		model.addAttribute("aa9",aa[9]);
		model.addAttribute("bb0",bb[0]);
		model.addAttribute("bb1",bb[1]);
		model.addAttribute("bb2",bb[2]);
		model.addAttribute("bb3",bb[3]);
		model.addAttribute("bb4",bb[4]);
		model.addAttribute("bb5",bb[5]);
		model.addAttribute("bb6",bb[6]);
		model.addAttribute("bb7",bb[7]);
		model.addAttribute("bb8",bb[8]);
		model.addAttribute("bb9",bb[9]);
		model.addAttribute("cc0",cc[0]);
		model.addAttribute("cc1",cc[1]);
		model.addAttribute("cc2",cc[2]);
		model.addAttribute("cc3",cc[3]);
		model.addAttribute("cc4",cc[4]);
		model.addAttribute("cc5",cc[5]);
		model.addAttribute("cc6",cc[6]);
		model.addAttribute("cc7",cc[7]);
		model.addAttribute("cc8",cc[8]);
		model.addAttribute("cc9",cc[9]);
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("c",c);
		return "web/exceptQueryData/view2";
		//return "web/exceptQueryData/11";
	}
	@RequestMapping(value = "/common/exceptQueryComplexData/index", method = RequestMethod.GET)
	public String exceptQueryDataComplexGet(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{
		return "web/exceptQueryData/complexIndex";
	}
	@RequestMapping(value = "/common/uploaddata", method = RequestMethod.POST)
	public void uploaddata(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		//手机信息
		String msg=null;
	
		
    	String launtime=request.getParameter("launtime");
    	
    	String exittime=request.getParameter("exittime");
   	
    	String usetime=request.getParameter("usetime");
   
    	
    	String excepTime=request.getParameter("excepTime");
    	
    	int uploadNum=Integer.parseInt(request.getParameter("uploadNum"));
    	
    	String uploadTime=request.getParameter("uploadTime");
    	
        String brand=request.getParameter("brand");
    
        String type=request.getParameter("type");
      
        String version=request.getParameter("version");
       
        String corporation=request.getParameter("corporation");
       
        String Cell_Id=request.getParameter("Cell_Id");
    
        String cpuRate=request.getParameter("cpuRate");
      
        String localIp=request.getParameter("localIp");
    
        String AppName=request.getParameter("AppName");
       
        String uid=request.getParameter("uid");
      
        String pid=request.getParameter("pid");
       
        String pidNumber=request.getParameter("pidNumber");
     
        String MemRate=request.getParameter("MemRate");
   
       
   
       
 
        //基站信息
        String IMEI=request.getParameter("IMEI");
      
        String IMSI=request.getParameter("IMSI");
      
        String LAC=request.getParameter("LAC");
       
        String gid=request.getParameter("gid");
        
        String excepType=request.getParameter("excepType");
        String longitude=request.getParameter("longitude");
        String latutide=request.getParameter("latutide");
        String addr=request.getParameter("addr");
       
//        String id=String.valueOf(UUID.randomUUID());//构造函数生成唯一外键
//        System.out.print(id);
        if(launtime.equals(null)) return;
    	String s1="insert into data(excepType,launtime,exittime,usetime,brand,type,version,corporation,Cell_Id,cpuRate,localIp,AppName,uid,pid,pidNumber,MemRate,IMEI,IMSI,LAC,gid,excepTime,uploadNum,uploadTime,longitude,latutide,addr) values('"+excepType+"','"+launtime+"','"+exittime+"','"+usetime+"','"+brand+"','"+type+"','"+version+"','"+corporation+"','"+Cell_Id+"','"+cpuRate+"','"+localIp+"','"+AppName+"','"+uid+"','"+pid+"','"+pidNumber+"','"+MemRate+"','"+IMEI+"','"+IMSI+"','"+LAC+"','"+gid+"','"+excepTime+"',"+uploadNum+",'"+uploadTime+"','"+longitude+"','"+latutide+"','"+addr+"')";
    	Jdbc jdbc=new Jdbc();
    	int b2=jdbc.executeUpdate1(s1);
    	System.out.println(b2);

    	
    	String slist=request.getParameter("signalInfo");
    	System.out.println(slist);
    	String[] aa=slist.split("\\|");
        String[] bb;
        String s3=null; 
    	for(int i=0;i<aa.length;i++)
    	{
    		bb=aa[i].split(",");
    		String RSRP=bb[0];
    		String RSRQ=bb[1];
    		String RSSINR=bb[2];
    		String TxByte=bb[3];
    		String RxByte=bb[4];
    		String netType=bb[5];
    		
    		String PCI=bb[6];
    		String CI=bb[7];
    		String ENODBID=bb[8];
    		String CellId=bb[9];
    		String TAC=bb[10];
    		String Time=bb[11];
    		if(netType.equals("GSM"))
    		{
    			RSRP="N/A";
        		RSRQ="N/A";
        		RSSINR="N/A";
        		PCI="N/A";
            	CI="N/A";
            	ENODBID="N/A";
            	CellId="N/A";
            	TAC="N/A";
    		}
    		s3="insert into data1(RSRP,RSRQ,RSSINR,TxByte,RxByte,NetType,PCI,CI,ENODBID,CELLID,TAC,Time,ReId) values('"+RSRP+"','"+RSRQ+"','"+RSSINR+"','"+TxByte+"','"+RxByte+"','"+netType+"','"+PCI+"','"+CI+"','"+ENODBID+"','"+CellId+"','"+TAC+"','"+Time+"','"+b2+"')";
    	    jdbc.executeUpdate(s3);
    	}
        msg="上传成功";
		
    	response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.flush();
		out.close();
	}
	@RequestMapping(value = "/common/exceptQueryData/index", method = RequestMethod.POST)
	public String exceptQueryDataPost(HttpServletRequest request,@ModelAttribute("queryModel")BitDataModel queryModel,HttpServletResponse response,Model model)
	{   if(queryModel.getBrand()==null)
		b1.setBrand("");
	    else
		b1.setBrand(queryModel.getBrand());
	    if(queryModel.getAppName()==null)
		b1.setAppName("");
	    else 
	    b1.setAppName(queryModel.getAppName());
	    if(queryModel.getCid()==null)
		b1.setCid("");
	    else
	    b1.setCid(queryModel.getCid());
	    if(queryModel.getLAC()==null)
		b1.setLAC("");
	    else
	    b1.setLAC(queryModel.getLAC());
	    if(queryModel.getExcepType()==null)
			b1.setExcepType("");
		    else
		    b1.setExcepType(queryModel.getExcepType());
	    if(queryModel.getAddr()==null)
			b1.setAddr("");
		    else
		    b1.setAddr(queryModel.getAddr());
	    if(queryModel.getVersion()==null)
		b1.setVersion("");
	    else
	    b1.setVersion(queryModel.getVersion());
	    if(queryModel.getLocalIp()==null)
		b1.setLocalIp("");
	    else
	    b1.setLocalIp(queryModel.getLocalIp());	
	    if(queryModel.getIMEI()==null)
		b1.setIMEI("");
	    else
	    b1.setIMEI(queryModel.getIMEI());
	    if(queryModel.getIMSI()==null)
		b1.setIMSI("");
	    else
	    b1.setIMSI(queryModel.getIMSI());
	    if(queryModel.getType()==null)
		b1.setType("");
	    else
	    b1.setType(queryModel.getType()); 
//	    if(queryModel.getNetType()==null)
//		b1.setNetType("");
//	    else
//	    b1.setNetType(queryModel.getNetType());
	    Calendar cal1 = Calendar.getInstance();
	    cal1.set(2000, 7, 1, 0, 0, 0);
	    Calendar cal2 = Calendar.getInstance();
	    cal2.set(2030, 7, 1, 0, 0, 0);
	    if(queryModel.getStartTime()==null)
		b1.setStartTime(cal1);
	    else
	    b1.setStartTime(queryModel.getStartTime());	
	    if(queryModel.getEndTime()==null)
		b1.setEndTime(cal2);
	    else
	    b1.setEndTime(queryModel.getEndTime());	
		model.addAttribute("pagn",this.bitDataManager.pagnModel(queryModel));
		return "web/exceptQueryData/queryResult";
	}
	
	@RequestMapping(value = "/common/bitAlertData/index", method = RequestMethod.GET)
	public String bitAlertDataGet(HttpServletRequest request,@ModelAttribute("queryModel")BitAlertDataModel queryModel,HttpServletResponse response,Model model)
	{
		if(StringTools.hasText(queryModel.getHour())){
			switch(queryModel.getHour())
			{
			case MySystemParam.NOW:
				break;
			case MySystemParam.ONEHOUR:
				Calendar now=Calendar.getInstance();
				now.add(Calendar.HOUR_OF_DAY, -1);
				model.addAttribute("endTime",now);
				break;
			case MySystemParam.HOUR24:
				Calendar endTime=Calendar.getInstance();
				endTime.add(Calendar.HOUR_OF_DAY, -24);
				model.addAttribute("endTime",endTime);
				break;
			}
		}
		return "web/bitAlertData/index";
	}
	@RequestMapping(value = "/common/bitAlertData/index", method = RequestMethod.POST)
	public String bitAlertDataPost(HttpServletRequest request,@ModelAttribute("queryModel")BitAlertDataModel queryModel,HttpServletResponse response,Model model)
	{
		model.addAttribute("pagn",this.bitAlertDataManager.queryPagn(queryModel));
		return "web/bitAlertData/queryResult";
	}
	@RequestMapping(value = "/common/bitAlertData/view/{id}")
	public String bitAlertDataView(HttpServletRequest request,@PathVariable("id")Integer id,HttpServletResponse response,Model model)
	{
		model.addAttribute("vo",this.bitAlertDataManager.findById(id));
		return "web/bitAlertData/view";
	}
	@RequestMapping(value = "/common/bitData/static", method = RequestMethod.GET)
	public String bitDataStaticGET(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		model.addAttribute("values",BitDataEnum.values());
		return "web/static/index";
	}
	@RequestMapping(value = "/common/bitData/static", method = RequestMethod.POST)
	public String bitDataStaticPOST(HttpServletRequest request,@RequestParam("type") BitDataEnum condition,HttpServletResponse response,Model model)
	{
		BitDataModel queryModel=new BitDataModel();
		queryModel.setDataType(condition);
		List<BitDataView> views=this.bitDataManager.getDataViews(queryModel);
		model.addAttribute("type",condition);
		model.addAttribute("lists",views);
		String datas=this.bitDataManager.getDataViewsForCharts(views);
		model.addAttribute("datas",datas);
		return "web/static/queryResult";
	}
	@RequestMapping(value = "/common/bitdata/export")
	public void export(@ModelAttribute("queryModel")BitDataModel queryModel, Model model,HttpServletResponse response,HttpServletRequest request)throws Exception
	{
//		logger.info("startNo==={}",queryModel.getStartNo());
//		logger.info("endNo==={}",queryModel.getEndNo());
		File file = bitDataManager.generateExcel(queryModel);
		String filename="experiment";
		try
		{
			filename = URLEncoder.encode(file.getName(),"UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		HttpMimeResponseHelper.doDownLoad(request, response, new FileInputStream(file), filename);
	}
	@RequestMapping(value = "/common/bitAlertData/export")
	public void exportAlertData(@ModelAttribute("queryModel")BitAlertDataModel queryModel, Model model,HttpServletResponse response,HttpServletRequest request)throws Exception
	{
//		logger.info("startNo==={}",queryModel.getStartNo());
//		logger.info("endNo==={}",queryModel.getEndNo());
		File file = bitAlertDataManager.generateExcel(queryModel);
		String filename="业务异常报警数据";
		try
		{
			filename = URLEncoder.encode(file.getName(),"UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		HttpMimeResponseHelper.doDownLoad(request, response, new FileInputStream(file), filename);
	}
	@RequestMapping(value = "/common/bitStaticData/export")
	public void exportStaticData(@RequestParam("type") BitDataEnum condition, Model model,HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		BitDataModel queryModel=new BitDataModel();
		queryModel.setDataType(condition);
		File file = bitDataManager.generateStaticDataExcel(queryModel);
		String filename="业务异常统计排名";
		try
		{
			filename = URLEncoder.encode(file.getName(),"UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		HttpMimeResponseHelper.doDownLoad(request, response, new FileInputStream(file), filename);
	}
	@RequestMapping(value = "/common/bitData/help", method = RequestMethod.GET)
	public String help(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		return "web/help";
	}
}

