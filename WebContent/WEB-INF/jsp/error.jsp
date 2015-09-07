<%@ page language="java" trimDirectiveWhitespaces="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误</title>
<style type="text/css">
.err{
	position:relative;
	width:300px;
	margin:30px auto;
}
.err p{
	padding:15px;
	color:#a94442;
	background-color:#f2dede;
	border:1px solid transparent;
	border-color:#ebccd1;
	border-radius:4px;
}
</style>
</head>
<body>
	<div class = "err">
    <p>服务器开了个小差...</p>
    </div>
</body>
</html>