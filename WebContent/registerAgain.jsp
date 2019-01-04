<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>
</head>
<body background="img/background3.jpg">
<center>
	<h1 style="font-family:FangSong;color:cadetblue">请重新注册</h1>
		<s:form action="register" method="post">
			<s:textfield key="id" label="请输入用户名" />
			<s:password key="password" label="请输入密码" /> 
			<s:submit value="注册" /><br><br>
		</s:form>
	<p style="color:royalblue;font-family:宋体;font-size:30px">信息学院足球队</p>
	<img src="img/xxxyTeam.jpg" width="512" height="300"/>
	<p style="color:springgreen;font-family:Helvetica;font-size:25px">Xxxy Never Give Up</p>
</center>
</body>
</html>