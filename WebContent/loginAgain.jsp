<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录界面</title>
</head>
<body background="img/background1.jpg">
<center>
	<h1 style="font-family:arial;color:coral">请重新登录</h1>
	<s:form action="login" method="post">
		<s:textfield key="id" label="用户名" />
		<s:password key="password" label="密码" /> 
		<s:submit value="登陆" /><br><br>
	</s:form>
<p style="color:firebrick">
	<p style="color:dodgerblue;font-family:宋体;font-size:35px">足球是圆的，你永远不知道下一秒会发生什么！</p>
	<img src="img/iceland.jpg" width="512" height="256"/>
</center>
</body>
</html>