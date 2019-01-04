package Player.hibernate.po;

import java.io.Serializable;

public class BjfuPlayer implements	Serializable
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;
	private	String	playerName;
	private	String	position;
	private	String	starter;
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	stuId;
	}
	
	public	void	setPlayerName(String playerName)
	{
		this.playerName=playerName;
	}
	public	String	getPlayerName()
	{
		return	playerName;
	}
	
	public	void	setPosition(String position)
	{
		this.position=position;
	}
	public	String	getPosition()
	{
		return	position;
	}
	
	public	void	setStarter(String starter)
	{
		this.starter=starter;
	}
	public	String	getStarter()
	{
		return	starter;
	}
}
