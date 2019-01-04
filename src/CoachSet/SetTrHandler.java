package CoachSet;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SetTrHandler 	//���������ݿ⽻������ش��� ���ѵ���ƻ��ϴ�
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	int	insertT(ArrayList<String> a)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�������ݿ�����
			String	sql="update coach set trainPlan = ? where workId=?";
			ps=conn.prepareStatement(sql);
			String	trainPlan=a.get(0);
			int	workId=Integer.parseInt(a.get(1));	//��String��תΪint
			ps.setString(1, trainPlan);
			ps.setInt(2, workId);
			int	flag=ps.executeUpdate();	//ִ�в��ж��Ƿ�ִ�гɹ�
			conn.close();
			return	flag;
		}
		catch(SQLException e)
		{
			return	(-1);
		}
	}
}
