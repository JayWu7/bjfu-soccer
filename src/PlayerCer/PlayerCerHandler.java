package PlayerCer;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PlayerCerHandler	//���������ݿ⽻����ش���
{
	PreparedStatement ps;
	ResultSet rs;
	public	boolean	checkPlayerExist(int stuId)//�жϸ�ѧ���Ƿ��Ѿ���֤
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from player where stuId=?"; 
			ps=conn.prepareStatement(findSql);
			ps.setInt(1, stuId);	//���ò���
			rs=ps.executeQuery();	//ִ��sql���
			if(rs.next())	//��ѧ�Ŵ���
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
			return	true;	//���� ��֤���ɹ�
		}
	}
	
	public	int	insertPlayer(ArrayList<String> a) 
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String sql="insert into player values(?,?,?,?,?,?,?,'����');";
			ps=conn.prepareStatement(sql);
			String	name=a.get(0);
			int	stuId=Integer.parseInt(a.get(1));	//��String��תΪint
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
			int f=ps.executeUpdate();	//�ж��Ƿ����ɹ�
			if(f!=-1)	//����ɹ�������Ա��֤�ɹ� ��users���е�role����Ϊ0  ��ʾ���Ϊ��Ա
			{
				String roleSql="update users set role=0 where id=?";
				ps=conn.prepareStatement(roleSql);
				ps.setString(1, id);
				f=ps.executeUpdate();	//���¸�f��ֵ���ж��Ƿ����users���е�roleֵ
			}
			conn.close();
			return	f;
		}catch(SQLException e)
		{
			return	(-1);	//���������ʧ�ܷ���-1
		}
	}
}
