package ManagerSet;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import	Coach.hibernate.po.*;

public class SetCoachAction extends	ActionSupport
{
	private static final long serialVersionUID= 1L;
	private	int	workId;
	
	public	void	setWorkId(int workId)
	{
		this.workId=workId;
	}
	public	int	getWorkId()
	{
		return	workId;
	}
	
	public String execute() throws Exception
	{
		PreparedStatement ps;
		try
		{
			Connection conn=new	DBConnect().conn;
			String	sql;
			//�����Ӵ������������Ƚ��������������
			sql="update coach set team=NULL where team='bjfu';";
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();	//ִ�и��²���
			
			sql="update coach set team ='bjfu' where workId=?;";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, workId);
			int f=ps.executeUpdate();	//�ж��Ƿ��޸ĳɹ�
			conn.close();
			if(f!=-1)	//�޸�bjfu�������ɹ�
			{
				//�޸�session���ֵ
				ActionContext ctx = ActionContext.getContext();
				List<Coach> list=(List)ctx.getSession().get("coachList");
				for(int i=0;i<list.size();i++)
				{
					Coach coach=(Coach)list.get(i);
					int	id=coach.getWorkId();
					String team=coach.getTeam();
					if(workId==id)	//����������
						list.get(i).setTeam("bjfu");
					if(team=="bjfu")
						list.get(i).setTeam("");
				}
				ctx.getSession().put("coachList", list);
				return	SUCCESS;
			}
			else
				return	ERROR;
		}catch(SQLException e)
		{
			return	ERROR;
		}
	}
}
