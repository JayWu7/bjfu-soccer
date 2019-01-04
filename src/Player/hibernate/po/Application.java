package Player.hibernate.po;

import java.io.Serializable;

public class Application implements	Serializable
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;
	private	String	name;
	private	String	message;
	
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
	
	public	void	setMessage(String message)
	{
		this.message=message;
	}
	public	String	getMessage()
	{
		return	message;
	}
}
