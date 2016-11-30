package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ���ݿ�������Ͽ�������װ��
 * @author Lx&Xb
 */
public class DataBaseConnection {
	/**
	 * ��ȡ���ݿ�����ӣ����βΣ�����Connection�����
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");		//��������
			String url="jdbc:mysql://localhost:3306/db_work";		//���ݿ�����URL	
			conn=DriverManager.getConnection(url,"root","1111");		//��ȡ���ݿ�����			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;		//����Connection�����
	}
	/**
	 * �ر����ݿ����ӣ���ҪConnection���βΣ��޷��ض���
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){		//�ж�conn�Ƿ�Ϊ��
			try{
				conn.close();		//�ر����ݿ�����
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
