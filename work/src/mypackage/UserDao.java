package mypackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 用户数据库操作封装类
 * @author Lx&Xb
 *
 */
public class UserDao {
	/**
	 * 在新用户注册操作中连接数据库查询指定用户名是否存在，有一个String类形参，返回boolean类型对象
	 */
	public boolean userIsExist(String username){
		Connection conn=DataBaseConnection.getConnection();		//获取数据库连接Connection类对象
		String sql="select * from db_work where username = ?";		//根据指定用户名查询用户信息
		try{
			PreparedStatement ps=conn.prepareStatement(sql);		//获取PreparedStatement类对象
			ps.setString(1, username);		//对用户名属性赋值
			ResultSet rs=ps.executeQuery();		//执行查询结果集
			if(!rs.next()){		//如果该用户名可用那么返回的ResultSet类对象的.next()将为boolean类型的false
				rs.close();		//释放ResultSet对象的数据库和JDBC资源
				ps.close();		//释放PreparedStatement对象的数据库和JDBC资源
				return true;
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DataBaseConnection.closeConnection(conn);		//关闭数据库连接   
		}
		return false;
	}
	/**
	 * 连接数据库将新注册用户保存，有两个String类形参，返回boolean类型对象
	 */
	public boolean saveUser(String username,String password,String email){
		Connection conn=DataBaseConnection.getConnection();
		String sql="insert into db_work(username,password,email)values(?,?,?)";		//插入用户注册信息的SQL语句
		try{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);		//对用户名属性赋值
			ps.setString(2, password);		//对密码属性赋值
			ps.setString(3, email);		//对email属性赋值
			ps.executeUpdate();		//执行数据库更新操作
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
	 * 在用户登录操作中连接数据库比对用户给出的用户名-密码对是否匹配，有两个String类形参，返回boolean类型对象
	 */
	public boolean login(String username,String password){
		Connection conn=DataBaseConnection.getConnection();
		String sql="select * from db_work where username = ? and password = ?";		//根据用户名-密码对检查是否匹配
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
