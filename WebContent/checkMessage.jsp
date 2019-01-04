<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>查看球员留言</title>
</head>
<body>

<div class="container">
<div class="jumbotron">
  <h1>Message from Players</h1> 
  <h2 style="font-family:YouYuan">当前留言有：</h2> 
  <table class="table">
  	<tr style="background-color:lightgreen;font-family:SimSun;font-size:20px">
  		<th>姓名:&nbsp;&nbsp;</th>
  		<th>学号:&nbsp;&nbsp;&nbsp;</th>
  		<th>留言信息:&nbsp;&nbsp;&nbsp;</th>
	<s:iterator value ="#session.appliList" var="appli" >   
	      <tr>  
		      <td><s:property value="#appli.stuId"/></td>
		      <td><s:property value="#appli.name"/></td>
		      <td><s:property value="#appli.message"/></td>
	     </tr>  
     </s:iterator>   
  </table>
   <s:debug></s:debug>
</div>
</div>
</body>
</html>