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
		//��ù��������
		workId=(int)ctx.getApplication().get("workId");
		a.add(trainPlan);
		a.add(String.valueOf(workId));
		SetTrHandler	set=new	SetTrHandler();
		int	flag=set.insertT(a);
		if(flag!=-1)//�ж��Ƿ�ɹ�
		{
			return SUCCESS;
		}
		else
			return	ERROR;
	}
	
	 public	void	validate()	//��֤����
	 {
		 if(this.getTrainPlan()==null||"".equals(this.getTrainPlan().trim()))
		 //�ж�ѵ���ƻ��Ƿ�Ϊ�ջ��߽�Ϊ�ո����
		 {
			 this.addFieldError("tactics", "��������հ�ѵ���ƻ�");
		 }
	 }
}
