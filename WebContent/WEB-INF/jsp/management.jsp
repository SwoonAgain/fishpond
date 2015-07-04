<%@ page language="java" trimDirectiveWhitespaces="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<div class="btn-group navbar-btn-group">
				<div class="unit">
					<button type="button" class="btn btn-info">公司信息管理</button>
				</div>
				<div class="unit">
					<button type="button" class="btn btn-info">鱼塘信息管理</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- management end -->