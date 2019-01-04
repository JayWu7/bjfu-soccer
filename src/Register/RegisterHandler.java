package Register;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RegisterHandler 	//处理与数据库交互的相关代码
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	boolean	checkUserExist(String id)//判断该账号是否存在
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from users where id=?"; //查找此账号是否已经被注册过
			ps=conn.prepareStatement(findSql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next())	//该账号存在
			{
				conn.close();
				return	true;
			}
			else
			{
				conn.close();
				return	false;
			}
		}catch(SQLException e)
		{
			return	true;	//出错 注册不成功
		}
	}
	
	public	int	insertRegister(ArrayList<String> a) 
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String sql="insert into users (id,password) values(?,?);";
			ps=conn.prepareStatement(sql);
			String	id=a.get(0);
			String	password=a.get(1);
			ps.setString(1, id);
			ps.setString(2, password);
			int f=ps.executeUpdate();	//判断是否插入成功
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);
		}
	}

}
