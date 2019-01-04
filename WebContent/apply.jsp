<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>申请页面</title>
<style>
#header 
{
    background-color:black;
    color:white;
    text-align:center;
    padding:4px;
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
</style>
</head>
<body>

<div id="header">
	<h1>Talk to your Coach！</h1>
</div>

<div id="nav">
	<s:property value="#session.name"/><br><br>
	<s:property value="#session.stuId"/><br><br>
	<s:property value="#session.institute"/>
</div>
<div id="section">
	<h2>填写申请信息</h2>
	<s:form action="apply" method="post">
		<s:textarea name="message" cols="80" rows="20"></s:textarea><br><br>
		<s:submit value="提交" />
	</s:form>
</div>
</body>
</html>