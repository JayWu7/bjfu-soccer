package Over;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OverHandler //处理与数据库交互的相关代码	
{
	PreparedStatement ps;
	
	public	boolean	deletePlayer(int stuId)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String	sql="delete from player where stuId=?; ";
			ps=conn.prepareStatement(sql);	//准备执行sql语句
			ps.setInt(1,stuId);
			int	flag=ps.executeUpdate();	//判断是否删除成功
			if(flag!=-1)	//球员数据库删除成功
			{
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
