package ManagerSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import	Connect.DBConnect;

import	Player.hibernate.po.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddPlayerAction extends	ActionSupport
{
	private static final long serialVersionUID= 1L;
	private	int	stuId;
	private	String	playerName;
	private	String	position;
	
	public	void	setStuId(int stuId)
	{
		this.stuId=stuId;
	}
	public	int	getStuId()
	{
		return	stuId;
	}
	
	public	void	setPlayerName(String name)
	{
		this.playerName=name;
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
	
	public String execute() throws Exception
	{
		PreparedStatement ps;
		try
		{
			Connection conn=new	DBConnect().conn;
			String	sql;
			sql="insert into bjfuplayer values(?,?,?,'�油');";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, stuId);
			ps.setString(2, playerName);
			ps.setString(3, position);
			int f=ps.executeUpdate();	//�ж��Ƿ���ӳɹ�
			if(f!=-1)	//��ӳɹ�
			{
				//�޸���Ա���и���Ա�����������Ϣ
				sql="update player set team='bjfu' where stuId=?;";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, stuId);
				int	flag=ps.executeUpdate();
				conn.close();
				if(flag!=-1)
				{
					//�޸�session�е�playerList
					ActionContext ctx = ActionContext.getContext();
					List<BjfuPlayer> list=(List)ctx.getSession().get("playerList");
					BjfuPlayer	player=new	BjfuPlayer();
					player.setStuId(stuId);
					player.setPlayerName(playerName);
					player.setPosition(position);
					player.setStarter("�油");
					list.add(player);
					ctx.getSession().put("playerList", list);
					
					//�޸�session�е�players
					List<Player> players=(List)ctx.getSession().get("players");
					for(int i=0,length=players.size();i<length;i++)
					{
						Player	p=new	Player();
						p=players.get(i);
						if(p.getStuId()==stuId)
						{
							players.remove(i);
							length--;
							i--;
						}
					}
					ctx.getSession().put("players", players);
					return	SUCCESS;
				}
				else
				{
					conn.close();
					return	ERROR;
				}
			}
			else
			{
				conn.close();
				return	ERROR;
			}
		}
		catch(SQLException e)
		{
			return	ERROR;
		}
	}
}
