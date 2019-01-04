package Player.hibernate.po;

import java.io.Serializable;

public class Player implements	Serializable
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;
	private	String	name;
	private	String	institute;
	private	String	birthday;
	private	String	position;
	private	String	introduction;
	private	String	team;
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	stuId;
	}
	
	public	void	setName(String name)
	{
		this.name=name;
	}
	public	String	getName()
	{
		return	name;
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
	
	public	void	setTeam(String team)
	{
		this.team=team;
	}
	public	String	getTeam()
	{
		return	team;
	}
	
}
