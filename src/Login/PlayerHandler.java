package Login;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;

public class PlayerHandler 	//从球员库中取出球员信息
{
	PreparedStatement ps;
	ResultSet rs;
	String	name;
	int	stuId;
	String	institute;
	String	birthday;
	String	position;
	String	introduction;
	
	public	boolean	selectPlayer(String id)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String sql="select * from player where id=?;";
			ps=conn.prepareStatement(sql);	//准备执行sql语句
			ps.setString(1, id);
			rs=ps.executeQuery();	//执行
			if(rs.next())	//取值成功
			{
				//取出数据库的值
				name=rs.getString("name");
				stuId=rs.getInt("stuId");
				institute=rs.getString("institute");
				birthday=rs.getString("birthday");
				position=rs.getString("position");
				introduction=rs.getString("introduction");
				//将值加入共享域，用于在jsp页面显示
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("name", name);
				ctx.getSession().put("stuId", stuId);
				ctx.getSession().put("institute", institute);
				ctx.getSession().put("birthday", birthday);
				ctx.getSession().put("position", position);
				ctx.getSession().put("introduction", introduction);
				ctx.getSession().put("id", id);
				
				return	true;
			}
			else	//失败
				return	false;
		}catch(SQLException e)
		{
			return	false;
		}
	}
}
