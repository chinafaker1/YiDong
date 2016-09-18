package cn.com.taiji.tongji.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Jdbc {
	private final static String url = "jdbc:mysql://localhost:3306/android?user=root&password=123&useUnicode=true&characterEncoding=utf-8";
	//	private final static String url = "jdbc:mysql://10.1.0.222:3306/sunmengqi?user=sunmengqi&password=woaini123456&useUnicode=true&characterEncoding=utf-8";
	private final static String dbDriver = "com.mysql.jdbc.Driver";
	    private Connection con = null;
	    // 通过构造方法加载数据库驱动
	    static {
	        try {
	            Class.forName(dbDriver).newInstance();
	            System.out.println(url);
	        } catch (Exception ex) {
	            System.out.println("数据库加载失败");
	        }
	    }
	 
	    // 创建数据库连接
	    public boolean creatConnection() {
	        try {
	            con = DriverManager.getConnection(url);
	            con.setAutoCommit(true);
	 
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            System.out.println("creatConnectionError!");
	        }
	        return true;
	    }
	 
	    // 对数据库的增加、修改和删除的操作
	    public boolean executeUpdate(String sql) {
	        if (con == null) {
	            creatConnection();
	        }
	        try {
	            Statement stmt = con.createStatement();
	            int iCount = stmt.executeUpdate(sql);
	            return true;
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            return false;
	        }
	    }
	 
	    // 对数据库的查询操作
	    public ResultSet executeQuery(String sql) {
	        ResultSet rs;
	        try {
	            if (con == null) {
	                creatConnection();
	            }
	            Statement stmt = con.createStatement();
	            try {
	                rs = stmt.executeQuery(sql);
	            } catch (SQLException e) {
	                System.out.println(e.getMessage());
	                return null;
	            }
	        } catch (SQLException e) {
	            return null;
	        }
	        return rs;
	    }
	    public int executeUpdate1(String sql) {
	    	ResultSet rs;
	    	if (con == null) {
		            creatConnection();
		        }
		        try {
		            Statement stmt = con.createStatement();
		            Statement stmt1 = con.createStatement();
		            int iCount = stmt.executeUpdate(sql);
		            int autoIncKeyFromFunc = -1;  
		            rs = stmt1.executeQuery("SELECT LAST_INSERT_ID()");             // 通过额外查询获取generatedKey  
		            if (rs.next()) {  
		                autoIncKeyFromFunc = rs.getInt(1);  
		            }  else {  
		                // throw an exception from here  
		            }   
		            rs.close();  
		            return autoIncKeyFromFunc;
		        } catch (SQLException e) {
		            System.out.println(e.getMessage());
		            return 0;
		        }
	    }

}
