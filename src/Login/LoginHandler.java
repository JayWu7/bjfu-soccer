package Login;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginHandler	//处理与数据库交互的相关代码
{	
	PreparedStatement ps;
	ResultSet rs;

	public	int	checkLogin(ArrayList<String> arr)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//创建连接数据库对象
			String sql = "select role from users where id=? and password=?;";
			String	id=arr.get(0);	//获得id
			String	password=arr.get(1);
			ps=conn.prepareStatement(sql);	//准备执行sql语句
			ps.setString(1, id);
			ps.setString(2,password);
			rs=ps.executeQuery();	//执行
			if(rs.next())	//登录成功
			{
				//判断用户身份
				int role=rs.getInt("role");
				conn.close();
				return	role;
			}
			else
			{
				conn.close();
				return	-1;//返回-1表示登录失败
			}
		}
		catch(SQLException e)
		{
			return	-1;
		}
	}
}

