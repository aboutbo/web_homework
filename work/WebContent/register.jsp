<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
	<h1 align="center">用户注册</h1>
	<form name="reg_form" action="register.action" method="post">
		<table align="center" border="0" width="500">
			<tr>
				<td align="right">用户名:</td>
				<td><input type="text" name="username"></td>
				<td align="left">(用户名长度不超过8个字符)</td>
			</tr>
			<tr>
				<td align="right">密码:</td>
				<td><input type="password" name="password"></td>
				<td align="left">(密码长度不超过16字符)</td>
			</tr>
			<tr>
				<td align="right">确认密码:</td>
				<td><input type="password" name="repassword"></td>
				<td align="left">(再次确认您所输入的密码)</td>
			</tr>
			<tr>
				<td align="right">电子邮箱</td>
				<td><input type="text" name="email"></td>
				<td align="left">(请输入电子邮箱)</td>
			</tr>
			<tr>
				<td colspan="3" align="center" height="40">
					<input type="submit" value="注册">
					<input type="reset" value="重置">
					<input name="bt_back" type="button" value="返回"/>
					<script type="text/javascript">
						reg_form.bt_back.onclick=function(){
							document.reg_form.reset();
							var url="index.jsp";
							window.location.href=url;
						}
					</script>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>