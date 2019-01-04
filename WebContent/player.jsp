<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
#header 
{
    background-color:black;
    color:white;
    text-align:center;
    padding:5px;
}
#nav 
{
    line-height:30px;
    background-color:#eeeeee;
    height:300px;
    width:100px;
    float:left;
    padding:5px; 
}
#section 
{
    width:350px;
    float:left;
    padding:10px; 
}
#footer 
{
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
    padding:5px; 
}
</style>
</head>
<body >

<div id="header">
<h1>Soccer Player</h1>
</div>

<div id="nav">
	<a href="apply.jsp"><input type="button" value="申请出场机会"></input></a><br><br><br><br>
	<a href="apply.jsp"><input type="button" value="申请转会"></input></a><br><br><br><br>
	<a href="overConpact.jsp"><input type="button" value="终止合同"></input></a>
</div>

<div id="section">
<h2>基本信息</h2>
	<p style="color:gray;font-family:宋体;font-size:20px">姓名：<s:property value="#session.name"/></p>
	<p style="color:gray;font-family:宋体;font-size:20px">学号：<s:property value="#session.stuId"/></p>
	<p style="color:gray;font-family:宋体;font-size:20px">学院：<s:property value="#session.institute"/></p>
	<p style="color:gray;font-family:宋体;font-size:20px">生日：<s:property value="#session.birthday"/></p>
	<p style="color:gray;font-family:宋体;font-size:20px">场上位置：<s:property value="#session.position"/></p>
	<p style="color:gray;font-family:宋体;font-size:20px">自我介绍：<s:property value="#session.introduction"/></p>
</div>

<div id="footer">
Copyright ? JayWu
</div>

</body>
</html>