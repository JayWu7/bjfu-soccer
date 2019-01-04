package Apply;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ApplyHandler 	//处理与数据库交互的相关代码
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	int	insertApplication(ArrayList<String> a) 
	{	//将申请信息插入数据库
		try
		{
			Connection conn=new	DBConnect().conn;	//创建数据库连接
			String sql="insert into application values(?,?,?);";
			ps=conn.prepareStatement(sql);
			int	stuId=Integer.parseInt(a.get(0));	//将String型转为int
			String	name=a.get(1);
			String	message=a.get(2);
			ps.setInt(1, stuId);
			ps.setString(2, name);
			ps.setString(3,message);
			int f=ps.executeUpdate();	//判断是否插入成功
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);
		}
	}
	
}
