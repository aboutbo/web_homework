package mypackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;
/**
 * �û�ע�����Action
 * @author Lx&Xb
 */
public class RegisterAction extends ActionSupport {
	private String username;      //�������ձ�������usernameֵ
	private String password;      //�������ձ�������passwordֵ
	private String repassword;		//�������ձ�������repasswordֵ
	private String email;		//�������ձ�������emailֵ
	private String info;		//�����洢ע������Ϣ
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
	 * ʵ�����û�ע�����ش������
	 */
	public String execute(){
		UserDao userDao=new UserDao();		//ʵ����UserDao����
		if(username==null||username.isEmpty()){		//����û����Ƿ�Ϊ��
			setInfo("�û���Ϊ��");
			return ERROR;
		}else if(!password.equals(repassword)){		//���ǰ���������������Ƿ���ͬ
			setInfo("�����������벻���");
			return ERROR;
		}else if(userDao.userIsExist(username)){		//����û����Ƿ����
			setInfo("�û����Ѵ���");
			return ERROR;
		}else{
			Pattern p=Pattern.compile("[A-Z]+");		//����û�����ǿ���Ƿ񹻸ߣ�������ʽ���Ӻű�ʾƥ��ǰһ������һ�Σ�
			Pattern q=Pattern.compile("[a-z]+");
			Pattern r=Pattern.compile("[0-9]+");
			Matcher m1=p.matcher(password);
			Matcher m2= q.matcher(password);
			Matcher m3 = r.matcher(password);
			if(!m1.find(0) || !m2.find(0) || !m3.find(0)){
				setInfo("����ǿ�ȹ��ͣ����������д��ĸ��Сд��ĸ������");
				return ERROR;
			}
			boolean register=userDao.saveUser(username, password,email);		//�����û������ϴ������ݿ�
			if(register){
				return SUCCESS;
			}else{
				setInfo("���ݴ������");			//����δ֪����
				return ERROR;
			}
		}
	}
}
