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

public class CoachHandler 	//处理教练登录与数据库的交互
{
	PreparedStatement ps;
	ResultSet rs;
	String	name;
	int	workId;
	
	public	boolean	selectCoach(String id)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String sql="select name,workId from coach where id=?;";
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
				//取出球队库中的所有球员信息，供更换首发球员页面使用
				Configuration cfg=new Configuration().configure();
	 			SessionFactory sf=cfg.buildSessionFactory();
	 			Session hsession=sf.openSession();
	 			Transaction ts=hsession.beginTransaction();
	 			
	 			Query hquery=hsession.createQuery("from BjfuPlayer u");
	 			List	playerList=hquery.list();
	 			ctx.getSession().put("playerList", playerList);
	 			
	 			//取出留言库中所有留言信息
	 			hquery=hsession.createQuery("from Application u");
	 			List	appliList=hquery.list();
	 			ctx.getSession().put("appliList", appliList);
	 			
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
