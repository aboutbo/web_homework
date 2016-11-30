package mypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户注册控制Action
 * @author Lx&Xb
 */
public class RegisterAction extends ActionSupport {
	private String username;      //用来接收表单传来的username值
	private String password;      //用来接收表单传来的password值
	private String repassword;		//用来接收表单传来的repassword值
	private String email;		//用来接收表单传来的email值
	private String info;		//用来存储注册结果信息
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
	public String getRepassword(){
		return repassword;
	}
	public void setRepassword(String repassword){
		this.repassword=repassword;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getInfo(){
		return info;
	}
	public void setInfo(String info){
		this.info=info;
	}
	/**
	 * 实现新用户注册的相关处理操作
	 */
	public String execute(){
		UserDao userDao=new UserDao();		//实例化UserDao对象
		if(username==null||username.isEmpty()){		//检查用户名是否为空
			setInfo("用户名为空");
			return ERROR;
		}else if(!password.equals(repassword)){		//检查前后两次输入密码是否相同
			setInfo("两次密码输入不相等");
			return ERROR;
		}else if(userDao.userIsExist(username)){		//检查用户名是否存在
			setInfo("用户名已存在");
			return ERROR;
		}else{
			Pattern p=Pattern.compile("[A-Z]+");		//检查用户密码强度是否够高（正则表达式，加号表示匹配前一项至少一次）
			Pattern q=Pattern.compile("[a-z]+");
			Pattern r=Pattern.compile("[0-9]+");
			Matcher m1=p.matcher(password);
			Matcher m2= q.matcher(password);
			Matcher m3 = r.matcher(password);
			if(!m1.find(0) || !m2.find(0) || !m3.find(0)){
				setInfo("密码强度过低，必须包含大写字母、小写字母和数字");
				return ERROR;
			}
			boolean register=userDao.saveUser(username, password,email);		//将新用户数据上传到数据库
			if(register){
				return SUCCESS;
			}else{
				setInfo("数据传输出错");			//发生未知错误
				return ERROR;
			}
		}
	}
}
