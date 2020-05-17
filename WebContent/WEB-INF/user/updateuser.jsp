<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<style>
body{ background-color:#CFF}
h1{ width:230px; margin:50px auto 0;}
.main{ width:250px; margin:10px auto; border:1px solid; background-color:#FFF}
</style>
<body>
<h1>学生信息更新</h1>
<form action="${pageContext.request.contextPath }/user/update" method="post">
	<table border="1" class="main">
		<tr>
			<td>学号</td>
			<td><input type="text" name="ID" value="${user.ID }" disabled="disabled"></td>
		</tr>
		<input type="hidden" name="ID" value="${user.ID }">
		<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value="${user.name }"></td>
		</tr>	
		<tr>
			<td>性别</td>
			<td><input type="radio" name="sex" value="true" ${fn:contains(user.sex,"true")?"checked":"" }>男<input type="radio" name="sex" value="false" ${fn:contains(user.sex,"false")?"checked":"" }>女</td>
		</tr>
		<tr>
			<td>年龄</td>
			<td><input type="text" name="age"  value="${user.age }"></td>
		</tr>
		<tr>
			<td>学院</td>
			<td><input type="text" name="department" value="${user.department }"></td>
		</tr>
		<tr>
			<td>电话</td>
			<td><input type="text" name="phoneNumber"  value="${user.phoneNumber }"></td>
		</tr>
		<tr>
			<td>宿舍号</td>
			<td><input type="text" name="dorm" value="${user.dorm }"></td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="date" name="birthday" value="${user.birthday }"></td>
		</tr>
		<tr><td colspan="2" align="center"><input type="submit" value="修改用户信息"></td></tr>
	</table>
</form>
</body>
</html>