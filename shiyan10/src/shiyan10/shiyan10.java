package shiyan10;
import java.sql.*;
public class shiyan10 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�������ݿ����ƺ͵�¼�û���Ϣ
		String URL="jdbc:mysql://localhost:3306/Information?serverTimezone=UTC";
		String USER="root";	      //���ݿ��û�
		String PASSWORD="";  
		Connection conn = null;
		try{ 
			conn = DriverManager.getConnection (URL, USER, PASSWORD);
		} catch(SQLException e){  }
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "select * from person"; 
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){ 
				String number = rs.getString("id");
				String name = rs.getString("name"); 
				System.out.println(number+","+name); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
	}

}
