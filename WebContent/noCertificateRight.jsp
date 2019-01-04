<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权限错误页面</title>
</head>
<body>
<center>
	<h1 style="font-family:arial;color:lightskyblue">你没有经理认证权限</h1>
	<p style="font-family:宋体;color:steelblue;font-size:25px">Sorry！</p>
	<p style="color:firebrick;font-size:25px" >点击返回认证页面：</p>
		<a href="managerCertificate.jsp"><input type="button" value="返回"></input></a>
</center>
</body>
</html>