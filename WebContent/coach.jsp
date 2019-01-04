<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>教练页面</title>
</head>
<body>

<div class="container">
<div class="jumbotron">
  <h1>Soccer Coach</h1> 
  <p style="font-family:SimSun">海鸥跟着拖网渔船飞行，那是因为它们以为沙丁鱼会被扔进海里--坎通纳</p> 
  <p style="font-family:宋体;font-size:15px">姓名：<s:property value="#session.name"/> 工号：<s:property value="#session.workId"/></p>
</div>
</div>

<div class="container">
<div class="row">
  <div class="col-md-4">
	<h2>首发球员 Starters</h2>
	<a href="setStarters.jsp"><input type="button" value="设定首发球员"></input></a>
	<p>You'll Never Walk Alone--利物浦队歌</p>
  </div>
  <div class="col-md-4">
    <h2>战术/训练计划</h2>
    <a href="setTactics.jsp"><input type="button" value="制定战术"></input></a> 
    <a href="setTrainPlan.jsp"><input type="button" value="制定训练计划"></input></a>
    <p>A football team is like a beautiful woman. When you do not tell her, she forgets she is beautiful--温格</p>
  </div>
  <div class="col-md-4">
    <h2>球员留言 Message</h2>
    <a href="checkMessage.jsp"><input type="button" value="查看球员留言"></input></a>
    <p>Not playing for England has also been very difficult, but I'm always available for my country--贝克汉姆</p>
  </div>
</div>
</div>
</body>
</html>