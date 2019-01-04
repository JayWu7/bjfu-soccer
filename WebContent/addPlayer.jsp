<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>引进球员页面</title>
</head>
<body>

<div class="container">
<div class="jumbotron">
  <h1>Soccer Players</h1> 
  <h2 style="font-family:YouYuan">球员列表：</h2> 
  <table class="table">
  	<tr style="background-color:lightgreen;font-family:SimSun;font-size:20px">
  		<th>姓名:&nbsp;&nbsp;</th>
  		<th>学号:&nbsp;&nbsp;&nbsp;</th>
  		<th>学院:&nbsp;&nbsp;&nbsp;</th>
  		<th>生日:&nbsp;&nbsp;</th>
  		<th>介绍:&nbsp;&nbsp;&nbsp;</th>
  		<th>场上位置:&nbsp;&nbsp;</th>
  		<th>所属球队:</th>
  		</tr>
	<s:iterator value ="#session.players" var="player" >   
	      <tr>  
		      <td><s:property value="#player.name"/></td> 
		      <td><s:property value="#player.stuId"/></td>
		      <td><s:property value="#player.institute"/></td>
		      <td><s:property value="#player.birthday"/></td>
		      <td><s:property value="#player.introduction"/></td> 
		      <td><s:property value="#player.position"/></td> 
		      <td><s:property value="#player.team"/></td>  
		      <td>
			      	<s:form action="addPlayer" method="post">
			      		<s:submit value="引进">
			      			<input type="hidden" name="stuId" value="<s:property value="#player.stuId"/>">
			      			<input type="hidden" name="playerName" value="<s:property value="#player.name"/>">
			      			<input type="hidden" name="position" value="<s:property value="#player.position"/>">
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