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
		//��ù��������
		workId=(int)ctx.getApplication().get("workId");
		a.add(tactics);
		a.add(String.valueOf(workId));
		SetTaHandler	set=new	SetTaHandler();
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
		 if(this.getTactics()==null||"".equals(this.getTactics().trim()))
		 //�ж�ս���Ƿ�Ϊ�ջ��߽�Ϊ�ո����
		 {
			 this.addFieldError("tactics", "��������հ�ս��");
		 }
	 }
}
