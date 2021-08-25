package shiyan10;
import java.sql.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		//查询所有用户
		userDao.queryAll();
		
		//通过姓名删除用户
		userDao.deleteByName("张三");	
		userDao.queryAll();	
		
		//添加一个用户
		User user=new User();
		user.setID("007");
		user.setName("张三");
		user.setPassword("abcde");
		userDao.add(user);
				
		//通过姓名查询用户
		userDao.queryByName("张三");
		
		//修改新用户的密码
		userDao.updatePassword("张三","56789");
		userDao.queryByName("张三");		
		
		//关闭数据库连接
		DBUtil.closeConnection();          

	}

}
