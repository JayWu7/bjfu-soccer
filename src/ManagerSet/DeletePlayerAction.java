package ManagerSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Player.hibernate.po.BjfuPlayer;

public class DeletePlayerAction extends	ActionSupport
{
	private static final long serialVersionUID= 1L;
	private	int	stuId;
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	stuId;
	}
	
	public String execute() throws Exception
	{
		PreparedStatement ps;
		try
		{
			Connection conn=new	DBConnect().conn;
			String	sql;
			sql="delete from bjfuplayer where stuId=?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			int f=ps.executeUpdate();	//判断是否修改成功
			conn.close();
			if(f!=-1)//修改成功
			{
				ActionContext ctx = ActionContext.getContext();
				List<BjfuPlayer> list=(List)ctx.getSession().get("playerList");
				for(int i=0,length=list.size();i<length;i++)
				{
					BjfuPlayer	player=(BjfuPlayer)list.get(i);
					int	id=player.getStuId();
					if(stuId==id)	//在session中删除本学号球员
					{
						list.remove(i);
						length--;
						i--;
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
