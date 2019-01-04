package CoachSet;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SetTrainPlanAction extends	ActionSupport
{
	private static final long serialVersionUID = 1L;
	private	int	workId;
	private	String	trainPlan;
	
	public	void	setTrainPlan(String trainPlan)
	{
		this.trainPlan=trainPlan;
	}
	public	String	getTrainPlan()
	{
		return	this.trainPlan;
	}
	
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		ArrayList<String>	a=new	ArrayList<String>();
		//获得共享的数据
		workId=(int)ctx.getApplication().get("workId");
		a.add(trainPlan);
		a.add(String.valueOf(workId));
		SetTrHandler	set=new	SetTrHandler();
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
		 if(this.getTrainPlan()==null||"".equals(this.getTrainPlan().trim()))
		 //判断训练计划是否为空或者仅为空格符号
		 {
			 this.addFieldError("tactics", "请勿输入空白训练计划");
		 }
	 }
}
