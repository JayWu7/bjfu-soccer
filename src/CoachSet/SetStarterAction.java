package CoachSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import	Player.hibernate.po.*;

public class SetStarterAction extends	ActionSupport
{
	private static final long serialVersionUID= 1L;
	private	int	stuId;
	private	String	starter;
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	stuId;
	}
	
	public	void	setStarter(String starter)
	{
		this.starter=starter;
	}
	public	String	getStarter()
	{
		return	starter;
	}
	
	public String execute() throws Exception
	{
		PreparedStatement ps;
		
		try
		{
			Connection conn=new	DBConnect().conn;
			String	sql;
			if(this.getStarter().equals("首发"))	//如果是首发，则修改为替补 反之亦然
				sql="update bjfuplayer set starter='替补' where stuId=?;";
			else
				sql="update bjfuplayer set starter='首发' where stuId=?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			int f=ps.executeUpdate();	//判断是否修改成功
			conn.close();
			if(f!=-1)//修改成功
			{
				ActionContext ctx = ActionContext.getContext();
				List<BjfuPlayer> list=(List)ctx.getSession().get("playerList");
				for(int i=0;i<list.size();i++)
				{
					BjfuPlayer	player=(BjfuPlayer)list.get(i);
					int	id=player.getStuId();
					if(stuId==id)
					{
						if(starter.equals("首发"))
							list.get(i).setStarter("替补");
						else
							list.get(i).setStarter("首发");
					}
				}
				ctx.getSession().put("playerList", list);
				return	SUCCESS;
			}
			else
				return	ERROR;
		}
		catch(SQLException e)
		{
			return	ERROR;
		}
	}
}
