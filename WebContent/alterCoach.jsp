<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<title>更换教练页面</title>
</head>
<body>

<div class="container">
<div class="jumbotron">
  <h1>Team Coach</h1> 
  <h2 style="font-family:YouYuan">教练列表：</h2> 
  <table class="table">
  	<tr style="background-color:lightgreen;font-family:SimSun;font-size:20px">
  		<th>姓名:&nbsp;&nbsp;</th>
  		<th>工号:&nbsp;&nbsp;&nbsp;</th>
  		<th>介绍:&nbsp;&nbsp;&nbsp;</th>
  		<th>训练计划:&nbsp;&nbsp;</th>
  		<th>战术:&nbsp;&nbsp;</th>
  		<th>所属球队:</th>
  		</tr>
	<s:iterator value ="#session.coachList" var="coach" >   
	      <tr>  
		      <td><s:property value="#coach.name"/></td> 
		      <td><s:property value="#coach.workId"/></td>
		      <td><s:property value="#coach.introduction"/></td> 
		      <td><s:property value="#coach.trainPlan"/></td> 
		      <td><s:property value="#coach.tactics"/></td> 
		      <td><s:property value="#coach.team"/></td>  
		      <td>
			      	<s:form action="setCoach" method="post">
			      		<s:submit value="设为主教练">
			      			<input type="hidden" name="workId" value="<s:property value="#coach.workId"/>">
			      		</s:submit>
			      	</s:form>
			      </td>  
	     </tr>  
     </s:iterator>   
  </table>
   <s:debug></s:debug>
</div>
</div>
</body>
</html>