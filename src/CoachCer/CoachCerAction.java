package CoachCer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class CoachCerAction extends	ActionSupport //������֤Action
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
			 return	ERROR;	//����֤����֤ʧ��
		 else
		 {
			 int	flag=coach.insertCoach(a);
			 if(flag!=-1)
				 return	SUCCESS;//��֤�ɹ�
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
		 //���ҽ��ܿ���Ϊ�� �ʲ����ж��Ƿ�Ϊ��
	}
}
