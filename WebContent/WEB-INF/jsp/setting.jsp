<%@ page language="java" trimDirectiveWhitespaces="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<div class="btn-group navbar-btn-group">
				<button type="button" class="btn btn-info">设置</button>
				<button type="button" class="btn btn-info dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false">
					<span class="caret"></span> <span class="sr-only">Toggle
						Dropdown</span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">基本设置</a></li>
					<li><a href="#">高级</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- 设置内容 -->
<div class="panel panel-default">
	<div class="panel-heading">端口</div>
	<div class="panel-body">端口号</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">xxxxx</h3>
	</div>
	<div class="panel-body">xxxxxxxxxxxxxx</div>
</div>
<!-- setting end -->