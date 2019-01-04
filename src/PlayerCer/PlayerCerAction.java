package PlayerCer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public class PlayerCerAction	extends	ActionSupport 
{
	private static final long serialVersionUID= 1L;
	private	String	name;
	private	int	stuId;
	private	String	institute;
	private	String	birthday;
	private	String	position;
	private	String	introduction;
	//private	String	picture;
	
	public	void	setName(String name)
	{
		this.name=name;
	}
	public	String	getName()
	{
		return	this.name;
	}
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	this.stuId;
	}
	
	public	void	setInstitute(String institute)
	{
		this.institute=institute;
	}
	public	String	getInstitute()
	{
		return	this.institute;
	}
	
	public	void	setBirthday(String birthday)
	{
		this.birthday=birthday;
	}
	public	String	getBirthday()
	{
		return	this.birthday;
	}
	
	public	void	setPosition(String position)
	{
		this.position=position;
	}
	public	String	getPosition()
	{
		return	this.position;
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
		a.add(String.valueOf(stuId));
		a.add(institute);
		a.add(birthday);
		a.add(position);
		a.add(introduction);
		String id=(String)ctx.getApplication().get("id");
		a.add(id);
		PlayerCerHandler	player=new	PlayerCerHandler();
		boolean	exist=player.checkPlayerExist(stuId);//�жϸ���Ա�Ƿ��Ѿ���֤	
		if(exist)
			 return	ERROR;	//����֤����֤ʧ��
		 else
		 {
			 int	flag=player.insertPlayer(a);
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
		 //�ж�ѧ���Ƿ�Ϊ��
		 if(this.getStuId()==0)
		 {
			 this.addFieldError("stuId","������ѧ��");
		 }
		 if(this.getInstitute()==null||"".equals(this.getInstitute().trim()))
		 {
			 this.addFieldError("institute", "��ѡ��ѧԺ");
		 }
		 if(this.getBirthday()==null||"".equals(this.getBirthday().trim()))
		 {
			 this.addFieldError("birthday", "����������");
		 }
		 if(this.getPosition()==null||"".equals(this.getPosition().trim()))
		 {
			 this.addFieldError("position", "��ѡ����λ��");
		 }
	 }
}
