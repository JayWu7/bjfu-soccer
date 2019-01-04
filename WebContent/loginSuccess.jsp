<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录成功</title>
</head>
<body background="img/background2.jpg">
<center>
	<h1 style="font-family:arial;color:coral">登录成功</h1>
	<s:property value="#session.id"/>
	<s:property value="#session.name"/>
	<s:property value="#session.stuId"/>
	<s:property value="#session.institute"/>
	<s:property value="#session.position"/>
	<s:property value="#session.introduction"/>
	<s:property value="#session.birthday"/>
</center>
</body>
</html>