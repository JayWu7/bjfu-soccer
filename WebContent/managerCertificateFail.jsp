<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>经理认证页面</title>
</head>
<body background="img/background6.jpg">
<center>
	<h1 style="font-family:NSimSun;color:darkgreen">欢迎来到经理认证页面</h1>
	<p style="color:slateblue;font-family:宋体;font-size:30px">认证失败，请重新输入</p>
	<s:form action="managercer" method="post" enctype="multipart/form-data">
		<s:textfield key="name" label="请输入姓名" />
		<s:textfield key="workId" label="请输入工号" />
		<s:textfield key="identityKey" label="请输入身份密钥" />
		<s:submit value="认证" /><br><br>
	</s:form>
</center>
</body>
</html>