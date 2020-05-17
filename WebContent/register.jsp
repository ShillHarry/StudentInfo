<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<style>
body{ background-color:#CFF}
h1{ width:190px; margin:200px auto 0;}
.main{ width:250px; margin:10px auto; border:1px solid; background-color:#FFF}
.name{ width:70; text-align:center;}
.password{ width:70; text-align:center;}
.login{ width:70px; margin:5px 50px;}
</style>
<body>
<h1>管理员注册</h1>
<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
	<table class="main">
		<tr><td class="name">用户名</td><td><input type="text" name="username"></td></tr>
		<tr><td class="password">密码</td><td><input type="password" name="password"></td></tr>
		<tr><td colspan="2"><input type="button" value="返回登录" class="login" onclick="jump()"><input type="submit" value="注册"></td></tr>
	</table>
	<script type="text/javascript">
		function jump(){
			window.location = "${pageContext.request.contextPath }/login.jsp";
		}
	</script> 
</form>
</body>
</html>