package Apply;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;

public class ApplyAction extends	ActionSupport	//处理有关申请页面
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;
	private String	name;
	private String	message;
	
	public	void	setMessage(String message)	//设置申请信息函数
	{
		this.message=message;
	}
	public	String	getMessage()
	{
		return	this.message;
	}
	
	 public String execute() throws Exception
	 {
		 ActionContext ctx = ActionContext.getContext();
		 ArrayList<String>	a=new	ArrayList<String>();
		 //获得共享的数据
		 stuId=(int)ctx.getApplication().get("stuId");
		 name=(String)ctx.getApplication().get("name");
		 a.add(String.valueOf(stuId));
		 a.add(name);
		 a.add(message);
		 ApplyHandler	apply=new	ApplyHandler();
		 int	flag=apply.insertApplication(a);
		//判断是否插入成功
		 if(flag!=-1)	//成功
		 {
			 return	SUCCESS;
		 }
		 else
			 return	ERROR;
	 }
	 public	void	validate()	//验证函数
	 {
		 if(this.getMessage()==null||"".equals(this.getMessage().trim()))
		 //判断申请内容是否为空或者仅为空格符号
		 {
			 this.addFieldError("message", "请勿输入空白申请");
		 }
	 }
}
