<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>卖出球员页面</title>
</head>
<body>

<div class="container">
<div class="jumbotron">
  <h1>BJFU Players</h1> 
  <h2 style="font-family:YouYuan">当前球队球员有：</h2> 
  <table class="table">
  	<tr style="background-color:lightgreen;font-family:SimSun;font-size:20px">
  		<th>姓名:&nbsp;&nbsp;</th>
  		<th>工号:&nbsp;&nbsp;&nbsp;</th>
  		<th>场上位置:&nbsp;&nbsp;&nbsp;</th>
  		<th>状态:</th></tr>
	<s:iterator value ="#session.playerList" var="player" >   
	      <tr>  
		      <td><s:property value="#player.playerName"/></td> 
		      <td><s:property value="#player.stuId"/></td>
		      <td><s:property value="#player.position"/></td>
		      <td><s:property value="#player.starter"/></td>
		      <td>
			      	<s:form action="deletePlayer" method="post">
			      		<s:submit value="卖出">
			      			<input type="hidden" name="stuId" value="<s:property value="#player.stuId"/>">
			      		</s:submit>
			      	</s:form>
			  </td>  
	     </tr>  
     </s:iterator>   
  </table>
  <a href="manager.jsp"><input type="button" value="返回"></input></a>
   <s:debug></s:debug>
</div>
</div>
</body>
</html>