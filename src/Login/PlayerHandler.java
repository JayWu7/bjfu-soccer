package Login;

import	Connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionContext;

public class PlayerHandler 	//����Ա����ȡ����Ա��Ϣ
{
	PreparedStatement ps;
	ResultSet rs;
	String	name;
	int	stuId;
	String	institute;
	String	birthday;
	String	position;
	String	introduction;
	
	public	boolean	selectPlayer(String id)
	{
		try
		{
			Connection conn=new	DBConnect().conn;	//�����������ݿ����
			String sql="select * from player where id=?;";
			ps=conn.prepareStatement(sql);	//׼��ִ��sql���
			ps.setString(1, id);
			rs=ps.executeQuery();	//ִ��
			if(rs.next())	//ȡֵ�ɹ�
			{
				//ȡ�����ݿ��ֵ
				name=rs.getString("name");
				stuId=rs.getInt("stuId");
				institute=rs.getString("institute");
				birthday=rs.getString("birthday");
				position=rs.getString("position");
				introduction=rs.getString("introduction");
				//��ֵ���빲����������jspҳ����ʾ
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("name", name);
				ctx.getSession().put("stuId", stuId);
				ctx.getSession().put("institute", institute);
				ctx.getSession().put("birthday", birthday);
				ctx.getSession().put("position", position);
				ctx.getSession().put("introduction", introduction);
				ctx.getSession().put("id", id);
				
				return	true;
			}
			else	//ʧ��
				return	false;
		}catch(SQLException e)
		{
			return	false;
		}
	}
}
