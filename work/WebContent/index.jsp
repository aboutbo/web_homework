<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<h1 align="center">用户登录</h1>
	<form  name="index_form" action="index.action" method="post">
		<table align="center" border="0" width="500">
			<tr>
				<td align="right" width="30%">用户名：</td>
				<td><input type="text" name="username" style="width:155px"/></td>
			</tr>
			<tr>
				<td align="right" width="30%">密码：</td>
				<td><input type="password" name="password" style="width:155px"/></td>
			</tr>
			<tr>
				<td colspan="3" align="center" height="40">
					<input type="submit" value="登录"/>
					<input  name="bt_reg" type="button" value="注册"/>
					<script type="text/javascript">
						index_form.bt_reg.onclick=function(){
							var url="register.jsp";
							window.location.href=url;
						}
					</script>
				</td>
			</tr> 
		</table>
	</form>
</body>
</html>