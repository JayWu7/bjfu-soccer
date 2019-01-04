package Over;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OverHandler //���������ݿ⽻������ش���	
{
	PreparedStatement ps;
	
	public	boolean	deletePlayer(int stuId)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�����������ݿ����
			String	sql="delete from player where stuId=?; ";
			ps=conn.prepareStatement(sql);	//׼��ִ��sql���
			ps.setInt(1,stuId);
			int	flag=ps.executeUpdate();	//�ж��Ƿ�ɾ���ɹ�
			if(flag!=-1)	//��Ա���ݿ�ɾ���ɹ�
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
