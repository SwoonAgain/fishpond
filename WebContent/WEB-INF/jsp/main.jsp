<%@page import="java.util.Random"%>
<%@ page language="java" trimDirectiveWhitespaces="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl); /*用于引入静态地址的绝对路径*/%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>智能鱼塘管理系统</title>
<link rel="stylesheet" href="${baseurl }/resource/css/common.css?<% out.write(String.valueOf(Math.random())); %>">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>

<body class="user-style-main">
	<header class="user-style-header">
		<div class="container">
			<span
				style="color: darkcyan; font-size: 30px; display: inline-block; padding: 5px 0; vertical-align: middle;">智能鱼塘管理系统</span>
			<img src="/fishPond/resource/images/logo.jpg" alt="智能鱼塘管理系统"
				style="height: 50px;" /> <span id="user-head-mainpage"><img
				src="/fishPond/resource/images/user-head-mainpage.png" alt="用户"
				style="height: 40px;" /></span>
		</div>
	</header>
	<div class="container user-style-board">
		<div id="nav" class="pull-left nav-main">
			<ul class="nav nav-pills nav-stacked" role="tablist">
				<li role="presentation"><a href="#list-online"
					aria-controls="list-online" role="tab" data-toggle="tab"
					data-href="${baseurl }/rest/list-online/1"> <span
						class="glyphicon glyphicon-signal" aria-hidden="true"></span>&nbsp;&nbsp;在线
				</a></li>
				<li role="presentation"><a href="#list-all"
					aria-controls="list-all" role="tab" data-toggle="tab"
					data-href="${baseurl }/rest/list-all/1"> <span
						class="glyphicon glyphicon-globe" aria-hidden="true"></span>&nbsp;&nbsp;全部
				</a></li>
				<li role="presentation"><a href="#management"
					aria-controls="management" role="tab" data-toggle="tab"
					data-href="${baseurl }/management.jhtml"> <span
						class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;&nbsp;管理
				</a></li>
				<li role="presentation"><a href="#setting"
					aria-controls="setting" role="tab" data-toggle="tab"
					data-href="${baseurl }/setting.jhtml"> <span
						class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;&nbsp;设置
				</a></li>
			</ul>
		</div>
		<div id="panel" class="user-panel pull-left tab-content">

			<div id="list-online" role="tabpanel" class="tab-pane active fade in">

			</div>

			<div id="list-all" role="tabpanel" class="tab-pane"></div>

			<div id="management" role="tabpanel" class="tab-pane"></div>
			<div id="setting" role="tabpanel" class="tab-pane"></div>
		</div>

		<!-- Modal -->
		<div id="device-detail-modal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
		</div>
		<!-- /.modal -->
		
	</div>
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="${baseurl }/resource/js/sugar.js?<% out.write(String.valueOf(Math.random())); %>"></script>
</body>
</html>
