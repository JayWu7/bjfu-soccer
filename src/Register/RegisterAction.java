package Register;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import com.opensymphony.xwork2.ActionContext;

public class RegisterAction extends	ActionSupport	//处理有关页面控制
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
		 boolean	exist=register.checkUserExist(id);//判断此用户名是否存在
		 if(exist)
			 return	ERROR;	//账号已存在、注册失败
		 else
		 {
			 int	flag=register.insertRegister(a);
			 if(flag!=-1)
			 {
				 ctx.getApplication().put("id", id);
				 return	SUCCESS;//注册成功
			 }
			 else
				 return	NONE;	//注册失败
		 }
	 }
	 
	 public	void	validate()	//验证函数
	 {
		 if(this.getId()==null||"".equals(this.getId().trim()))
		 //判断用户名是否为空或者仅为空格符号
		 {
			 this.addFieldError("id", "请输入用户名");
		 }
		 if(this.getPassword()==null||"".equals(this.getPassword().trim()))
		 {
			 this.addFieldError("password","请输入密码");
		 }
	 }
}