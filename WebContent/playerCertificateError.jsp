<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!-- 球员认证页面 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>球员认证页面</title>
</head>
<body background="img/background6.jpg">
<center>
	<h1 style="font-family:NSimSun;color:darkgreen">请重新认证</h1>
	<p style="color:slateblue;font-family:宋体;font-size:30px">此球员已认证，请核实是否输入有误</p>
	<s:form action="playercer" method="post" enctype="multipart/form-data">
			<s:textfield key="name" label="请输入姓名" />
			<s:textfield key="stuId" label="请输入学号" />
			<s:select list="{'信息','工学','经管','园林','林学','留学生','材料'}" name="institute" label="请选择学院"></s:select>
			<s:textfield key="birthday" label="请输入生日（year-month-day）" />
			<s:checkboxlist list="{'前锋','后卫','中场','守门员'}" name="position" label="请选择场上位置，可多选"></s:checkboxlist>
			<s:textarea name="introduction" label="请输入个人简介" cols="40" rows="8"></s:textarea><br><br>
			<!--<s:file name="picture" label="请上传照片"></s:file> -->
			
			<s:submit value="认证" /><br><br>
	</s:form>
</center>
</body>

</html>