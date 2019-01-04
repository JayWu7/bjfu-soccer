package Apply;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

import com.opensymphony.xwork2.ActionContext;

public class ApplyAction extends	ActionSupport	//�����й�����ҳ��
{
	private static final long serialVersionUID = 1L;
	private	int	stuId;
	private String	name;
	private String	message;
	
	public	void	setMessage(String message)	//����������Ϣ����
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
		 //��ù��������
		 stuId=(int)ctx.getApplication().get("stuId");
		 name=(String)ctx.getApplication().get("name");
		 a.add(String.valueOf(stuId));
		 a.add(name);
		 a.add(message);
		 ApplyHandler	apply=new	ApplyHandler();
		 int	flag=apply.insertApplication(a);
		//�ж��Ƿ����ɹ�
		 if(flag!=-1)	//�ɹ�
		 {
			 return	SUCCESS;
		 }
		 else
			 return	ERROR;
	 }
	 public	void	validate()	//��֤����
	 {
		 if(this.getMessage()==null||"".equals(this.getMessage().trim()))
		 //�ж����������Ƿ�Ϊ�ջ��߽�Ϊ�ո����
		 {
			 this.addFieldError("message", "��������հ�����");
		 }
	 }
}
