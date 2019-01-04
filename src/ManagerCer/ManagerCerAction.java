package ManagerCer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class ManagerCerAction extends	ActionSupport //������֤Action
{
	private static final long serialVersionUID = 1L;
	private	String	name;
	private	int	workId;
	private	String identityKey;	
	//���������Կ  �����ֵ  �û���Ҫ������ȷ����Կ���ܽ�����֤
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
		//�ж������Կ�Ƿ���ȷ �������ȷ ֱ�ӷ�������Ȩ�޽���
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
			 return	ERROR;	//����֤����֤ʧ��
		 else
		 {
			 int	flag=manager.insertManager(a);
			 if(flag!=-1)
			 {
				 return	SUCCESS;//��֤�ɹ�
			 }
			 else
				 return	NONE;	//��֤ʧ��
		 }
	}
	
	public	void	validate()	//��֤����
	{
		if(this.getName()==null||"".equals(this.getName().trim()))
		//�ж������Ƿ�Ϊ�ջ��߽�Ϊ�ո����
		 {
			 this.addFieldError("name", "����������");
		 }
		
		 //�жϹ����Ƿ�Ϊ��
		 if(this.getWorkId()==0)
		 {
			 this.addFieldError("workId","�����빤��");
		 }
	}
}
