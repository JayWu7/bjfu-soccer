package Over;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class OverAction extends	ActionSupport	//���������ͬ������
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;	//ѧ��
	private	String	id;	
	public String execute() throws Exception
	{
		 ActionContext ctx = ActionContext.getContext();
		 stuId=(int)ctx.getApplication().get("stuId");//��õ�ǰ��Աѧ��
		 OverHandler	over=new	OverHandler();
		 boolean	flag=over.deletePlayer(stuId);
		 if(flag)//��ֹ��ͬ�ɹ�
		 {
			 return	SUCCESS;
		 }
		 else
			 return	ERROR;
	}
}
