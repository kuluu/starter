package shiyan10;

import java.sql.*;
public class DBUtil {	
	    //设置数据库参数
	    
	    
	    private static final String URL = "jdbc:mysql://localhost:3306/Information?serverTimezone=UTC";
	    private static final String USER="root";
	    private static final String PASSWORD="";    
	    private static Connection conn=null;
	    
	   //connetcDB方法：连接数据库
	    
	public static void connetcDB() {
		//补充与数据库建立连接的代码
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	    //getConnection方法：返回所建立的数据库连接，即：Connection对象
	public static Connection getConnection(){
	        	return conn;
	}
	static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
