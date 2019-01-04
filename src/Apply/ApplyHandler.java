package Apply;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ApplyHandler 	//���������ݿ⽻������ش���
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	int	insertApplication(ArrayList<String> a) 
	{	//��������Ϣ�������ݿ�
		try
		{
			Connection conn=new	DBConnect().conn;	//�������ݿ�����
			String sql="insert into application values(?,?,?);";
			ps=conn.prepareStatement(sql);
			int	stuId=Integer.parseInt(a.get(0));	//��String��תΪint
			String	name=a.get(1);
			String	message=a.get(2);
			ps.setInt(1, stuId);
			ps.setString(2, name);
			ps.setString(3,message);
			int f=ps.executeUpdate();	//�ж��Ƿ����ɹ�
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);
		}
	}
	
}
