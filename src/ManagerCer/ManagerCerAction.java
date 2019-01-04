package ManagerCer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class ManagerCerAction extends	ActionSupport //经理认证Action
{
	private static final long serialVersionUID = 1L;
	private	String	name;
	private	int	workId;
	private	String identityKey;	
	//定义身份密钥  并设初值  用户需要输入正确的密钥才能进行认证
	private	String	ikey="jaywu18210799763";

	
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
	
	public	void	setIdentityKey(String identityKey)
	{
		this.identityKey=identityKey;
	}
	public	String	getIdentityKey()
	{
		return	this.identityKey;
	}
	
	public	String	execute() throws Exception
	{
		//判断身份密钥是否正确 如果不正确 直接返回至无权限界面
		if(!this.getIdentityKey().equals(ikey))
			return	LOGIN;
		ActionContext ctx = ActionContext.getContext();
		ArrayList<String>	a=new	ArrayList<String>();
		a.add(name);
		a.add(String.valueOf(workId));
		String id=(String)ctx.getApplication().get("id");
		a.add(id);
		ManagerCerHandler	manager=new	ManagerCerHandler();
		boolean	exist=manager.checkManagerExist(workId);
		if(exist)
			 return	ERROR;	//已认证、认证失败
		 else
		 {
			 int	flag=manager.insertManager(a);
			 if(flag!=-1)
			 {
				 return	SUCCESS;//认证成功
			 }
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
	}
}
