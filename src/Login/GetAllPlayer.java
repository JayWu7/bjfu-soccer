package Login;

import	Connect.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllPlayer //����ӿ���ȡ��������Ա��Ϣ
{
	Statement ps;
	ResultSet rs;
	public	List<Player>	a=new	ArrayList<Player>();
	
	public	boolean	selectPlayer()
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�����������ݿ����
			String sql="select * from bjfuplayer;";
			ps=conn.createStatement();	//׼��ִ��sql���
			rs=ps.executeQuery(sql);	//ִ��
			while(rs.next())	//ȡֵ�ɹ�
			{		
				//ȡ�����ݿ��ֵ
				int	stuId=rs.getInt("stuId");
				String playerName=rs.getString("playerName");
				String position=rs.getString("position");
				String starter=rs.getString("starter");
				
				Player	player=new	Player(stuId,playerName,position,starter);//������Ա����
				a.add(player);	//�����Ա����Ա�б�
			}//
			conn.close();//�ر����ݿ�����
			if(a!=null)
			{
				return	true;
			}
			else
				return	false;	
		}catch(SQLException e)
		{
			return	false;
		}
	}
}
