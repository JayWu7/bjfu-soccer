package Login;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginHandler	//���������ݿ⽻������ش���
{	
	PreparedStatement ps;
	ResultSet rs;

	public	int	checkLogin(ArrayList<String> arr)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�����������ݿ����
			String sql = "select role from users where id=? and password=?;";
			String	id=arr.get(0);	//���id
			String	password=arr.get(1);
			ps=conn.prepareStatement(sql);	//׼��ִ��sql���
			ps.setString(1, id);
			ps.setString(2,password);
			rs=ps.executeQuery();	//ִ��
			if(rs.next())	//��¼�ɹ�
			{
				//�ж��û����
				int role=rs.getInt("role");
				conn.close();
				return	role;
			}
			else
			{
				conn.close();
				return	-1;//����-1��ʾ��¼ʧ��
			}
		}
		catch(SQLException e)
		{
			return	-1;
		}
	}
}

