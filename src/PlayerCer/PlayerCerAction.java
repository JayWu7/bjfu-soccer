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
		boolean	exist=player.checkPlayerExist(stuId);//判断该球员是否已经认证	
		if(exist)
			 return	ERROR;	//已认证、认证失败
		 else
		 {
			 int	flag=player.insertPlayer(a);
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
		 //判断学号是否为空
		 if(this.getStuId()==0)
		 {
			 this.addFieldError("stuId","请输入学号");
		 }
		 if(this.getInstitute()==null||"".equals(this.getInstitute().trim()))
		 {
			 this.addFieldError("institute", "请选择学院");
		 }
		 if(this.getBirthday()==null||"".equals(this.getBirthday().trim()))
		 {
			 this.addFieldError("birthday", "请输入生日");
		 }
		 if(this.getPosition()==null||"".equals(this.getPosition().trim()))
		 {
			 this.addFieldError("position", "请选择场上位置");
		 }
	 }
}
