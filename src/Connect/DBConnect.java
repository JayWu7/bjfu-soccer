package Connect;
import java.sql.Connection;  
import java.sql.DriverManager;  
 

public class DBConnect 
{
	String	driver	="com.mysql.jdbc.Driver";	//����������
	String	url="jdbc:mysql://localhost:3306/bjfusoccer";	//urlָ�����ݿ�
	String	user="root";	//��½�û�
	String	password="jay18210799763";	//��½����
	
	public Connection conn = null;
	
	public DBConnect() 
	{  
        try 
        {  
            Class.forName(driver);//ָ����������  
            conn = DriverManager.getConnection(url, user, password);//��ȡ����  
        } 
        catch (Exception e)
        {  
            e.printStackTrace();  
        }  
	}
}
