<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<style>
body{ background-color:#CFF}
h1{ width:190px; margin:10px auto 0;}
.main{ width:900px; margin:10px auto; border:1px solid; background-color:#FFF}
tr{ text-align:center}
</style>
<body>
	<h1>学籍管理</h1>
	<table border="1" class="main">
	<form action="${pageContext.request.contextPath }/user/showone" method="post">
		<tr><td colspan="10"align="right"><input type="text" name="ID" placeholder="请属于要查找学生的学号"><input type="submit" value="查找学生信息" ></td></tr>
	</form>
		<tr><td colspan="10"align="right"><a href="${pageContext.request.contextPath }/user/add">添加新用户</a></td></tr>
		<tr>
			<th>序号</th><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>学院</th><th>电话</th><th>宿舍号</th><th>出生日期</th><th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${empty(users) }">
				<tr><td colspan="10">对不起，当前数据库中没有用户信息</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.users }" var="user" varStatus="status">
					<tr>
						<td>${status.count }</td>
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
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<script type="text/javascript">
		function deleteUser(ID){
			if(window.confirm("你确定要删除这条数据吗？")){
				window.location = "${pageContext.request.contextPath }/user/delete?ID="+ID;
				return false;
			}else{
				return false;
			}
	</script>
</body>
</html>