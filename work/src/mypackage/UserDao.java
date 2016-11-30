package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * �û����ݿ������װ��
 * @author Lx&Xb
 *
 */
public class UserDao {
	/**
	 * �����û�ע��������������ݿ��ѯָ���û����Ƿ���ڣ���һ��String���βΣ�����boolean���Ͷ���
	 */
	public boolean userIsExist(String username){
		Connection conn=DataBaseConnection.getConnection();		//��ȡ���ݿ�����Connection�����
		String sql="select * from db_work where username = ?";		//����ָ���û�����ѯ�û���Ϣ
		try{
			PreparedStatement ps=conn.prepareStatement(sql);		//��ȡPreparedStatement�����
			ps.setString(1, username);		//���û������Ը�ֵ
			ResultSet rs=ps.executeQuery();		//ִ�в�ѯ�����
			if(!rs.next()){		//������û���������ô���ص�ResultSet������.next()��Ϊboolean���͵�false
				rs.close();		//�ͷ�ResultSet��������ݿ��JDBC��Դ
				ps.close();		//�ͷ�PreparedStatement��������ݿ��JDBC��Դ
				return true;
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(conn);		//�ر����ݿ�����   
		}
		return false;
	}
	/**
	 * �������ݿ⽫��ע���û����棬������String���βΣ�����boolean���Ͷ���
	 */
	public boolean saveUser(String username,String password,String email){
		Connection conn=DataBaseConnection.getConnection();
		String sql="insert into db_work(username,password,email)values(?,?,?)";		//�����û�ע����Ϣ��SQL���
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);		//���û������Ը�ֵ
			ps.setString(2, password);		//���������Ը�ֵ
			ps.setString(3, email);		//��email���Ը�ֵ
			ps.executeUpdate();		//ִ�����ݿ���²���
			ps.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(conn);
		}
		return false;
	}
	/**
	 * ���û���¼�������������ݿ�ȶ��û��������û���-������Ƿ�ƥ�䣬������String���βΣ�����boolean���Ͷ���
	 */
	public boolean login(String username,String password){
		Connection conn=DataBaseConnection.getConnection();
		String sql="select * from db_work where username = ? and password = ?";		//�����û���-����Լ���Ƿ�ƥ��
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				rs.close();
				ps.close();
				return true;
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(conn);
		}
		return false;
	}
}
