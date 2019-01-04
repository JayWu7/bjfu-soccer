package Over;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

public class OverAction extends	ActionSupport	//处理结束合同的申请
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;	//学号
	private	String	id;	
	public String execute() throws Exception
	{
		 ActionContext ctx = ActionContext.getContext();
		 stuId=(int)ctx.getApplication().get("stuId");//获得当前球员学号
		 OverHandler	over=new	OverHandler();
		 boolean	flag=over.deletePlayer(stuId);
		 if(flag)//终止合同成功
		 {
			 return	SUCCESS;
		 }
		 else
			 return	ERROR;
	}
}
