<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>经理页面</title>
</head>
<body>
<body>

<div class="container">
<div class="jumbotron">
  <h1>Soccer Manager</h1> 
  <p style="font-family:SimSun">海鸥跟着拖网渔船飞行，那是因为它们以为沙丁鱼会被扔进海里--坎通纳</p> 
  <p style="font-family:宋体;font-size:15px">姓名：<s:property value="#session.name"/> 工号：<s:property value="#session.workId"/></p>
</div>
</div>

<div class="container">
<div class="row">
  <div class="col-md-4">
	<h2>更换教练 Coach</h2>
	<a href="alterCoach.jsp"><input type="button" value="更换教练"></input></a>
	<p>You'll Never Walk Alone--利物浦队歌</p>
  </div>
  <div class="col-md-4">
    <h2>卖出球员 Player</h2>
    <a href="deletePlayer.jsp"><input type="button" value="卖出球员"></input></a> 
    <p>A football team is like a beautiful woman. When you do not tell her, she forgets she is beautiful--温格</p>
  </div>
  <div class="col-md-4">
    <h2>引进球员 Player</h2>
    <a href="addPlayer.jsp"><input type="button" value="引进球员"></input></a>
    <p>Not playing for England has also been very difficult, but I'm always available for my country--贝克汉姆</p>
  </div>
</div>
</div>
</body>
</html>