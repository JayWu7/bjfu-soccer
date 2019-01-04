package CoachCer;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CoachCerHandler //���������ݿ⽻����ش���
{
	PreparedStatement ps;
	ResultSet rs;
	
	public	boolean	checkCoachExist(int workId)//�жϸù��Ž����Ƿ��Ѿ���֤
	{
		try
		{
			Connection conn=new	DBConnect().conn;
			String findSql = "select * from coach where workId=?"; 
			ps=conn.prepareStatement(findSql);
			ps.setInt(1, workId);	//���ò���
			rs=ps.executeQuery();	//ִ��sql���
			if(rs.next())	//�ù��Ŵ���
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
			ps.setString(1, name);	//����sql������
			ps.setInt(2, workId);
			ps.setString(3, introduction);
			ps.setString(4, id);
			int f=ps.executeUpdate();	//ִ�в��ж��Ƿ����ɹ�
			if(f!=-1)	//����ɹ����������֤�ɹ� ��users���е�role����Ϊ1 �������Ϊ����
			{
				String roleSql="update users set role=1 where id=?";
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
