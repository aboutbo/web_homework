<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误</title>
<style type="text/css">
    html,body{
        text-align:center;
    }
</style>
</head>
<body>
	<h1 align="center">错误</h1>
	注册失败，失败原因：<s:property value="info"/>
</body>
</html>