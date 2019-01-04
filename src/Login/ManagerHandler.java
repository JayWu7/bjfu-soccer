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
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String sql="select name,workId from manager where id=?;";
			ps=conn.prepareStatement(sql);	//准备执行sql语句
			ps.setString(1, id);
			rs=ps.executeQuery();	//执行
			if(rs.next())	//取值成功
			{
				//取出数据库的值
				name=rs.getString("name");
				workId=rs.getInt("workId");
				conn.close();	//关闭数据库连接
				//将值加入共享域，用于在jsp页面显示
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("name", name);
				ctx.getSession().put("workId", workId);
				//取出教练库的所有教练信息，供更换教练页面使用
				Configuration cfg=new Configuration().configure();
	 			SessionFactory sf=cfg.buildSessionFactory();
	 			Session hsession=sf.openSession();
	 			Transaction ts=hsession.beginTransaction();
	 			
	 			Query hquery=hsession.createQuery("from Coach u");
	 			List	coachList=hquery.list();
	 			ctx.getSession().put("coachList", coachList);
	 			
	 			//取出球队库中所有球员信息，供卖出球员页面使用
	 			hquery=hsession.createQuery("from BjfuPlayer u");
	 			List	playerList=hquery.list();
	 			ctx.getSession().put("playerList", playerList);
	 			
	 			//取出球员库中的所有球员信息，供引进球员页面使用
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
