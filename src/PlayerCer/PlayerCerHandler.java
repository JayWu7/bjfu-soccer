package PlayerCer;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PlayerCerHandler	//处理与数据库交互相关代码
{
	PreparedStatement ps;
	ResultSet rs;
	public	boolean	checkPlayerExist(int stuId)//判断该学号是否已经认证
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from player where stuId=?"; 
			ps=conn.prepareStatement(findSql);
			ps.setInt(1, stuId);	//设置参数
			rs=ps.executeQuery();	//执行sql语句
			if(rs.next())	//该学号存在
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
			return	true;	//出错 验证不成功
		}
	}
	
	public	int	insertPlayer(ArrayList<String> a) 
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String sql="insert into player values(?,?,?,?,?,?,?,'暂无');";
			ps=conn.prepareStatement(sql);
			String	name=a.get(0);
			int	stuId=Integer.parseInt(a.get(1));	//将String型转为int
			String	institute=a.get(2);
			String	birthday=a.get(3);
			String	position=a.get(4);
			String	introduction=a.get(5);
			String	id=a.get(6);
			ps.setString(1, name);
			ps.setInt(2, stuId);
			ps.setString(3, institute);
			ps.setString(4, birthday);
			ps.setString(5, position);
			ps.setString(6, introduction);
			ps.setString(7, id);
			int f=ps.executeUpdate();	//判断是否插入成功
			if(f!=-1)	//插入成功，则球员认证成功 将users表中的role设置为0  表示身份为球员
			{
				String roleSql="update users set role=0 where id=?";
				ps=conn.prepareStatement(roleSql);
				ps.setString(1, id);
				f=ps.executeUpdate();	//重新给f赋值，判断是否更新users表中的role值
			}
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);	//出错则插入失败返回-1
		}
	}
}
