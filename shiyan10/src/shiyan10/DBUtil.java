package shiyan10;

import java.sql.*;
public class DBUtil {	
	    //�������ݿ����
	    
	    
	    private static final String URL = "jdbc:mysql://localhost:3306/Information?serverTimezone=UTC";
	    private static final String USER="root";
	    private static final String PASSWORD="";    
	    private static Connection conn=null;
	    
	   //connetcDB�������������ݿ�
	    
	public static void connetcDB() {
		//���������ݿ⽨�����ӵĴ���
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

	    //getConnection���������������������ݿ����ӣ�����Connection����
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
