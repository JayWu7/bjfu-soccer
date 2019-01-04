package CoachSet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SetTacticsAction extends	ActionSupport
{
	private static final long serialVersionUID = 1L;
	private	int	workId;
	private	String	tactics;
	public	void	setTactics(String tactics)
	{
		this.tactics=tactics;
	}
	public	String	getTactics()
	{
		return	this.tactics;
	}
	
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		ArrayList<String>	a=new	ArrayList<String>();
		//获得共享的数据
		workId=(int)ctx.getApplication().get("workId");
		a.add(tactics);
		a.add(String.valueOf(workId));
		SetTaHandler	set=new	SetTaHandler();
		int	flag=set.insertT(a);
		if(flag!=-1)//判断是否成功
		{
			return SUCCESS;
		}
		else
			return	ERROR;
	}
	
	 public	void	validate()	//验证函数
	 {
		 if(this.getTactics()==null||"".equals(this.getTactics().trim()))
		 //判断战术是否为空或者仅为空格符号
		 {
			 this.addFieldError("tactics", "请勿输入空白战术");
		 }
	 }
}
