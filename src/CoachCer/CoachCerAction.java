package CoachCer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class CoachCerAction extends	ActionSupport //教练认证Action
{
	private static final long serialVersionUID= 1L;
	private	String	name;
	private	int	workId;
	private	String	introduction;
	
	public	void	setName(String name)
	{
		this.name=name;
	}
	public	String	getName()
	{
		return	this.name;
	}
	
	public	void	setWorkId(int workId)
	{
		this.workId=workId;
	}
	public	int	getWorkId()
	{
		return	this.workId;
	}
	
	public	void	setIntroduction(String introduction)
	{
		this.introduction=introduction;
	}
	public	String	getIntroduction()
	{
		return	this.introduction;
	}
	
	public	String	execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		ArrayList<String>	a=new	ArrayList<String>();
		a.add(name);
		a.add(String.valueOf(workId));
		a.add(introduction);
		String id=(String)ctx.getApplication().get("id");
		a.add(id);
		CoachCerHandler	coach=new	CoachCerHandler();
		boolean	exist=coach.checkCoachExist(workId);
		if(exist)
			 return	ERROR;	//已认证、认证失败
		 else
		 {
			 int	flag=coach.insertCoach(a);
			 if(flag!=-1)
				 return	SUCCESS;//认证成功
			 else
				 return	NONE;	//认证失败
		 }
	}
	
	public	void	validate()	//验证函数
	{
		if(this.getName()==null||"".equals(this.getName().trim()))
		//判断姓名是否为空或者仅为空格符号
		 {
			 this.addFieldError("name", "请输入姓名");
		 }
		
		 //判断工号是否为空
		 if(this.getWorkId()==0)
		 {
			 this.addFieldError("workId","请输入工号");
		 }
		 //自我介绍可以为空 故不需判断是否为空
	}
}
