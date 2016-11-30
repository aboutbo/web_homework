package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库连接与断开操作封装类
 * @author Lx&Xb
 */
public class DataBaseConnection {
	/**
	 * 获取数据库的连接，无形参，返回Connection类对象
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");		//加载驱动
			String url="jdbc:mysql://localhost:3306/db_work";		//数据库连接URL	
			conn=DriverManager.getConnection(url,"root","1111");		//获取数据库连接			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;		//返回Connection类对象
	}
	/**
	 * 关闭数据库连接，需要Connection类形参，无返回对象
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){		//判断conn是否为空
			try{
				conn.close();		//关闭数据库连接
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
