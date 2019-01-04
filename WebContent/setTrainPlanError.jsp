<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>制定训练计划页面</title>
<style>
#header 
{
    background-color:black;
    color:white;
    text-align:center;
    padding:4px;
}
</style>
</head>
<body>
	<div id="header">
		<h1>制定训练计划</h1>
	</div>
<center>
	<s:form action="trainplan" method="post">
			<h2 style="font-family:SimSun">填写训练计划</h2>
			<p style="font-family:宋体;font-size:15px">提交有误，请重新提交</p>
			<s:textarea name="trainPlan" cols="80" rows="20"></s:textarea><br><br>
			<s:submit value="提交" />
	</s:form>
</center>
</body>
</html>