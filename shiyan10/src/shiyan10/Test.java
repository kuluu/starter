package shiyan10;
import java.sql.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao userDao=new UserDao();
		//��ѯ�����û�
		userDao.queryAll();
		
		//ͨ������ɾ���û�
		userDao.deleteByName("����");	
		userDao.queryAll();	
		
		//���һ���û�
		User user=new User();
		user.setID("007");
		user.setName("����");
		user.setPassword("abcde");
		userDao.add(user);
				
		//ͨ��������ѯ�û�
		userDao.queryByName("����");
		
		//�޸����û�������
		userDao.updatePassword("����","56789");
		userDao.queryByName("����");		
		
		//�ر����ݿ�����
		DBUtil.closeConnection();          

	}

}
