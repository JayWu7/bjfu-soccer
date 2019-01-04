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
		     case	-1:	//��¼ʧ��
		    	 return	ERROR;
		     case	0://��Ա
		     {
		    	 PlayerHandler	player=new	PlayerHandler();
		    	 boolean	flag=player.selectPlayer(id);
		    	 if(flag)//�ж��Ƿ�ȡ��Ա��Ϣ�ɹ�
		    	 {
		    		 //��ѧ�ź��������빲����
		    		 ctx.getApplication().put("stuId", player.stuId);
		    	     ctx.getApplication().put("name", player.name);
		    		 return	SUCCESS;	//����success������Ա����
		    	 }
		    	 else
		    		 return	ERROR;
		     }
		     case	1://����
		     {
		    	 CoachHandler	coach=new	CoachHandler();
		    	 boolean	flag=coach.selectCoach(id);
		    	 if(flag)
		    	 {
		    		 //��workId���빲���򣬹�CoachSet�����Actionʹ��
		    		 ctx.getApplication().put("workId", coach.workId);
		    		 return	NONE;	//����none�����������
		    	 }
		    	 else
		    		 return	ERROR;
		     }
		     case	2://����
		     {
		    	ManagerHandler	manager=new	ManagerHandler();
		    	boolean	flag=manager.selectManager(id);
		    	if(flag)
		    	{
		    		return	LOGIN;	//����login���뾭�����
		    	}
		    	else
		    		return	ERROR;
		     }
		     default:	//��¼ʧ��
		    	 return	ERROR;
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
