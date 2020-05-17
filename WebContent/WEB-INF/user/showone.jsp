<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查找</title>
</head>
<style>
body{ background-color:#CFF}
h1{ width:210px; margin:10px auto 0;}
.main{ width:900px; margin:10px auto; border:1px solid; background-color:#FFF}
tr{ text-align:center}
</style>
<body>
<h1>查询学生信息</h1>
	<table border="1" class="main">
	<tr><td colspan="10"align="right"><a href="${pageContext.request.contextPath }/index.jsp">返回</a></td></tr>
		<tr>
			<th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>学院</th><th>电话</th><th>宿舍号</th><th>出生日期</th><th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${empty(user) }">
				<tr><td colspan="9">对不起，当前数据库中没有用户信息</td></tr>
			</c:when>
			<c:otherwise>
					<tr>
						<td>${user.ID }</td>
						<td>${user.name }</td>
						<td>${user.sex?"男":"女" }</td>
						<td>${user.age }</td>
						<td>${user.department }</td>
						<td>${user.phoneNumber }</td>
						<td>${user.dorm }</td>
						<td>${user.birthday }</td>
						
						<td>
							<a href="${pageContext.request.contextPath }/user/update?ID=${user.ID}">修改</a>
							<a href="${pageContext.request.contextPath }/user/delete?ID=${user.ID}" onclick="return deleteUser(${user.ID })">删除</a>
						</td>
						
					</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>