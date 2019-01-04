package Register;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RegisterHandler 	//���������ݿ⽻������ش���
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	boolean	checkUserExist(String id)//�жϸ��˺��Ƿ����
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from users where id=?"; //���Ҵ��˺��Ƿ��Ѿ���ע���
			ps=conn.prepareStatement(findSql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next())	//���˺Ŵ���
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
			return	true;	//���� ע�᲻�ɹ�
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
			int f=ps.executeUpdate();	//�ж��Ƿ����ɹ�
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);
		}
	}

}
