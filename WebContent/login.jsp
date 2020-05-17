<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style>
body{ background-color:#CFF}
h1{ width:190px; margin:200px auto 0;}
.main{ width:250px; margin:10px auto; border:1px solid; background-color:#FFF}
.name{ width:70; text-align:center;}
.password{ width:70; text-align:center;}
.login{ width:50px; margin:5px 50px;}
</style>
</head>
<body>
	<h1>管理员登录</h1>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		<table class="main">
			<tr>
				<td class="name">用户名</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td class="password">密码</td>
				<td><input type="password" name="password" ></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="登录" class="login"><input type="button" value="注册" onclick ="jump()" class="register" magin-left="50px"></td></tr>
		</table>
		</form>
	<script type="text/javascript">
		function jump(){
			window.location = "${pageContext.request.contextPath }/register.jsp";
		}
	</script> 
</body>
</html>