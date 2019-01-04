package Register;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;

public class RegisterAction extends	ActionSupport	//�����й�ҳ�����
{
	private static final long serialVersionUID= 1L;
	private String id;
	private String password;

	 public	void	setId(String id)
	 {
		 this.id=id;
	 }
	 public	String	getId()
	 {
		 return	id;
	 }
	 
	 public	void	setPassword(String password)
	 {
		 this.password=password;
	 }
	 public	String	getPassword()
	 {
		 return	password;
	 }
	 
	 public String execute() throws Exception
	 {
		 ActionContext ctx = ActionContext.getContext();
		 ArrayList<String>	a=new	ArrayList<String>();
		 a.add(id);
		 a.add(password);
		 RegisterHandler	register=new	RegisterHandler();
		 boolean	exist=register.checkUserExist(id);//�жϴ��û����Ƿ����
		 if(exist)
			 return	ERROR;	//�˺��Ѵ��ڡ�ע��ʧ��
		 else
		 {
			 int	flag=register.insertRegister(a);
			 if(flag!=-1)
			 {
				 ctx.getApplication().put("id", id);
				 return	SUCCESS;//ע��ɹ�
			 }
			 else
				 return	NONE;	//ע��ʧ��
		 }
	 }
	 
	 public	void	validate()	//��֤����
	 {
		 if(this.getId()==null||"".equals(this.getId().trim()))
		 //�ж��û����Ƿ�Ϊ�ջ��߽�Ϊ�ո����
		 {
			 this.addFieldError("id", "�������û���");
		 }
		 if(this.getPassword()==null||"".equals(this.getPassword().trim()))
		 {
			 this.addFieldError("password","����������");
		 }
	 }
}