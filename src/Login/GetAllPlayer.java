package Login;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllPlayer //从球队库中取出所有球员信息
{
	Statement ps;
	ResultSet rs;
	public	List<Player>	a=new	ArrayList<Player>();
	
	public	boolean	selectPlayer()
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String sql="select * from bjfuplayer;";
			ps=conn.createStatement();	//准备执行sql语句
			rs=ps.executeQuery(sql);	//执行
			while(rs.next())	//取值成功
			{		
				//取出数据库的值
				int	stuId=rs.getInt("stuId");
				String playerName=rs.getString("playerName");
				String position=rs.getString("position");
				String starter=rs.getString("starter");
				
				Player	player=new	Player(stuId,playerName,position,starter);//创建球员对象
				a.add(player);	//添加球员至球员列表
			}//
			conn.close();//关闭数据库连接
			if(a!=null)
			{
				return	true;
			}
			else
				return	false;	
		}catch(SQLException e)
		{
			return	false;
		}
	}
}
