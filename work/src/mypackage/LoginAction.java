package mypackage;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户登录控制Action
 * @author Lx&Xb
 */
public class LoginAction extends ActionSupport {
	private String username;      //用来接收表单传来的username值
	private String password;      //用来接收表单传来的password值
	/**
	 * 通过Action对象为username和password属性提供setter()方法进行注入以及实现对应的getter()方法
	 */
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	/**
	 * 实现用户登录的相关后台处理操作
	 */
	public String execute(){
		UserDao userDao=new UserDao();		//实例化UserDao对象
		boolean login=userDao.login(username, password);		//根据用户名-密码对查询登陆结果
		if(login){
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
}
