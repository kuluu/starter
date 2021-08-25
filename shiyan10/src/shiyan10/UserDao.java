package shiyan10;
import java.sql.*;
public class UserDao {
	Connection conn;
	UserDao(){
		
		conn = DBUtil.getConnection();
	}
	
	void add(User user){
		String sql="select * from userInfo where ID=? and UName=? and UPassword=?";
		
		
		try {
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1,user.getID());
			stmt.setString(2,user.getName());
			stmt.setString(3,user.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(!rs.next())
			{
				sql = "insert into userInfo values(?,?,?)";
				stmt =conn.prepareStatement(sql);
				stmt.setString(1, user.getID());
				stmt.setString(2,user.getName());
				stmt.setString(3,user.getPassword());
				stmt.executeUpdate();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	void queryByName(String Name) {
		String sql="select * from userInfo where UName=?";
		try {
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, Name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){ 
				
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)); 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void deleteByName(String Name) {
		String sql="delete from userInfo where UName=?";
		try {
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, Name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void updatePassword(String Name,String Password) {
		String sql="update userInfo set UPassword=? where UName=?";
		try {
			PreparedStatement stmt =conn.prepareStatement(sql);
			stmt.setString(1, Password);
			stmt.setString(2, Name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 void queryAll() {
		String sql="select * from userInfo";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){ 				
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}