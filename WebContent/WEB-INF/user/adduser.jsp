<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
</head>
<style>
body{ background-color:#CFF}
h1{ width:230px; margin:50px auto 0;}
.main{ width:250px; margin:10px auto; border:1px solid; background-color:#FFF}
</style>
<body>
<h1>学生信息添加</h1>
<form action="${pageContext.request.contextPath }/user/add" method="post">
	<table border="1" class="main">
		<tr>
			<td>学号</td>
			<td><input type="text" name="ID"></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
		</tr>	
		<tr>
			<td>性别</td>
			<td><input type="radio" name="sex" value="true">男<input type="radio" name="sex" value="false">女</td>
		</tr>
		<tr>
			<td>学院</td>
			<td><input type="text" name="department"></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phoneNumber"></td>
		</tr>
		<tr>
			<td>宿舍号</td>
			<td><input type="text" name="dorm"></td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="date" name="birthday"></td>
		</tr>
		<tr><td colspan="2" align="center"><input type="submit" value="添加新用户"></td></tr>
	</table>
</form>
</body>
</html>