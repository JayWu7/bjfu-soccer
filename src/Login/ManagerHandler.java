package Login;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import com.opensymphony.xwork2.ActionContext;

public class ManagerHandler 
{
	PreparedStatement ps;
	ResultSet rs;
	String	name;
	int	workId;
	
	public	boolean	selectManager(String id)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�����������ݿ����
			String sql="select name,workId from manager where id=?;";
			ps=conn.prepareStatement(sql);	//׼��ִ��sql���
			ps.setString(1, id);
			rs=ps.executeQuery();	//ִ��
			if(rs.next())	//ȡֵ�ɹ�
			{
				//ȡ�����ݿ��ֵ
				name=rs.getString("name");
				workId=rs.getInt("workId");
				conn.close();	//�ر����ݿ�����
				//��ֵ���빲����������jspҳ����ʾ
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("name", name);
				ctx.getSession().put("workId", workId);
				//ȡ������������н�����Ϣ������������ҳ��ʹ��
				Configuration cfg=new Configuration().configure();
	 			SessionFactory sf=cfg.buildSessionFactory();
	 			Session hsession=sf.openSession();
	 			Transaction ts=hsession.beginTransaction();
	 			
	 			Query hquery=hsession.createQuery("from Coach u");
	 			List	coachList=hquery.list();
	 			ctx.getSession().put("coachList", coachList);
	 			
	 			//ȡ����ӿ���������Ա��Ϣ����������Աҳ��ʹ��
	 			hquery=hsession.createQuery("from BjfuPlayer u");
	 			List	playerList=hquery.list();
	 			ctx.getSession().put("playerList", playerList);
	 			
	 			//ȡ����Ա���е�������Ա��Ϣ����������Աҳ��ʹ��
	 			hquery=hsession.createQuery("from Player u");
	 			List	players=hquery.list();
	 			ctx.getSession().put("players", players);
	 			
	 			ts.commit();
	 			hsession.close(); 
				return	true;
			}
			else
				return	false;
		}
		catch(SQLException e)
		{
			return	false;
		}
	}
	
}
