package mypackage;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �û���¼����Action
 * @author Lx&Xb
 */
public class LoginAction extends ActionSupport {
	private String username;      //�������ձ�������usernameֵ
	private String password;      //�������ձ�������passwordֵ
	/**
	 * ͨ��Action����Ϊusername��password�����ṩsetter()��������ע���Լ�ʵ�ֶ�Ӧ��getter()����
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
	 * ʵ���û���¼����غ�̨�������
	 */
	public String execute(){
		UserDao userDao=new UserDao();		//ʵ����UserDao����
		boolean login=userDao.login(username, password);		//�����û���-����Բ�ѯ��½���
		if(login){
			return SUCCESS;
		}else{
			return LOGIN;
		}
	}
}
