package Coach.hibernate.po;

import java.io.Serializable;

public class Coach implements	Serializable
{
	private static final long serialVersionUID = 1L;
	private	int	workId;
	private	String	name;
	private	String	introduction;
	private	String	trainPlan;
	private	String	tactics;
	private	String	team;
	
	public	void	setWorkId(int workId)
	{
		this.workId=workId;
	}
	public	int	getWorkId()
	{
		return	workId;
	}
	
	public	void	setName(String name)
	{
		this.name=name;
	}
	public	String	getName()
	{
		return	name;
	}
	
	public	void	setIntroduction(String introduction)
	{
		this.introduction=introduction;
	}
	public	String	getIntroduction()
	{
		return	this.introduction;
	}
	
	public	void	setTrainPlan(String trainPlan)
	{
		this.trainPlan=trainPlan;
	}
	public	String	getTrainPlan()
	{
		return	this.trainPlan;
	}
	
	public	void	setTactics(String tactics)
	{
		this.tactics=tactics;
	}
	public	String	getTactics()
	{
		return	tactics;
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
