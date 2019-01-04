package CoachCer;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CoachCerHandler //处理与数据库交互相关代码
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	boolean	checkCoachExist(int workId)//判断该工号教练是否已经认证
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from coach where workId=?"; 
			ps=conn.prepareStatement(findSql);
			ps.setInt(1, workId);	//设置参数
			rs=ps.executeQuery();	//执行sql语句
			if(rs.next())	//该工号存在
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
	
	public	int	insertCoach(ArrayList<String> a)
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String	sql="insert into coach (name,workId,introduction,id) values(?,?,?,?);";
			ps=conn.prepareStatement(sql);
			String	name=a.get(0);
			int	workId=Integer.parseInt(a.get(1));
			String	introduction=a.get(2);
			String	id=a.get(3);
			ps.setString(1, name);	//设置sql语句参数
			ps.setInt(2, workId);
			ps.setString(3, introduction);
			ps.setString(4, id);
			int f=ps.executeUpdate();	//执行并判断是否插入成功
			if(f!=-1)	//插入成功，则教练认证成功 将users表中的role设置为1 代表身份为教练
			{
				String roleSql="update users set role=1 where id=?";
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
