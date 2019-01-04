package Connect;
import java.sql.Connection;  
import java.sql.DriverManager;  
 

public class DBConnect 
{
	String	driver	="com.mysql.jdbc.Driver";	//驱动程序名
	String	url="jdbc:mysql://localhost:3306/bjfusoccer";	//url指向数据库
	String	user="root";	//登陆用户
	String	password="jay18210799763";	//登陆密码
	
	public Connection conn = null;
	
	public DBConnect() 
	{  
        try 
        {  
            Class.forName(driver);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
        } 
        catch (Exception e)
        {  
            e.printStackTrace();  
        }  
	}
}
