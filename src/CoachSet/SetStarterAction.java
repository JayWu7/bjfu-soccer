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
			if(this.getStarter().equals("�׷�"))	//������׷������޸�Ϊ�油 ��֮��Ȼ
				sql="update bjfuplayer set starter='�油' where stuId=?;";
			else
				sql="update bjfuplayer set starter='�׷�' where stuId=?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			int f=ps.executeUpdate();	//�ж��Ƿ��޸ĳɹ�
			conn.close();
			if(f!=-1)//�޸ĳɹ�
			{
				ActionContext ctx = ActionContext.getContext();
				List<BjfuPlayer> list=(List)ctx.getSession().get("playerList");
				for(int i=0;i<list.size();i++)
				{
					BjfuPlayer	player=(BjfuPlayer)list.get(i);
					int	id=player.getStuId();
					if(stuId==id)
					{
						if(starter.equals("�׷�"))
							list.get(i).setStarter("�油");
						else
							list.get(i).setStarter("�׷�");
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
