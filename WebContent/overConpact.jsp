<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>终止合同页面</title>
</head>
<body background="img/06.jpg">
<center>
<h1 style="font-family:FangSong;color:royalblue;font-size:30px">终止合同页面</h1>
<s:form action="over" method="post">
	<p style="color:red;font-family:宋体;font-size:20px">你确定要终止合同吗？</p>
	<a href="player.jsp"><input type="button" value="退出"></input></a>
	<s:submit value="确定" />
</s:form>
<img src="img/xxxyTeam.jpg" width="512" height="300"/>
</center>
</body>
</html>