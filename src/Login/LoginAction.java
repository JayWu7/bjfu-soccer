package Login;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class LoginAction extends	ActionSupport
{
	private static final long serialVersionUID
	= 1L;
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
		 LoginHandler login = new LoginHandler();
	     int mark = login.checkLogin(a);
	     switch(mark)
	     {
		     case	-1:	//登录失败
		    	 return	ERROR;
		     case	0://球员
		     {
		    	 PlayerHandler	player=new	PlayerHandler();
		    	 boolean	flag=player.selectPlayer(id);
		    	 if(flag)//判断是否取球员信息成功
		    	 {
		    		 //将学号和姓名加入共享域
		    		 ctx.getApplication().put("stuId", player.stuId);
		    	     ctx.getApplication().put("name", player.name);
		    		 return	SUCCESS;	//返回success进入球员界面
		    	 }
		    	 else
		    		 return	ERROR;
		     }
		     case	1://教练
		     {
		    	 CoachHandler	coach=new	CoachHandler();
		    	 boolean	flag=coach.selectCoach(id);
		    	 if(flag)
		    	 {
		    		 //将workId加入共享域，供CoachSet包里的Action使用
		    		 ctx.getApplication().put("workId", coach.workId);
		    		 return	NONE;	//返回none进入教练界面
		    	 }
		    	 else
		    		 return	ERROR;
		     }
		     case	2://经理
		     {
		    	ManagerHandler	manager=new	ManagerHandler();
		    	boolean	flag=manager.selectManager(id);
		    	if(flag)
		    	{
		    		return	LOGIN;	//返回login进入经理界面
		    	}
		    	else
		    		return	ERROR;
		     }
		     default:	//登录失败
		    	 return	ERROR;
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
