package CoachSet;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SetTaHandler 	//处理与数据库交互的相关代码 完成战术上传
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	int	insertT(ArrayList<String> a)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建数据库连接
			String	sql="update coach set tactics = ? where workId=?";
			ps=conn.prepareStatement(sql);
			String	tactics=a.get(0);
			int	workId=Integer.parseInt(a.get(1));	//将String型转为int
			ps.setString(1, tactics);
			ps.setInt(2, workId);
			int	flag=ps.executeUpdate();	//执行并判断是否执行成功
			conn.close();
			return	flag;
		}
		catch(SQLException e)
		{
			return	(-1);
		}
	}
}
