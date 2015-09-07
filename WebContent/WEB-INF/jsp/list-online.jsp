<%@ page language="java" trimDirectiveWhitespaces="true" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-btn-group">
			<div class="col-lg-2 btn-group" id="sort">
				<button type="button" class="btn btn-info dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
					data-field>
					<span class="glyphicon glyphicon-sort" aria-hidden="true">排序</span><span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#" data-field="company_name">公司名称</a></li>
					<li><a href="#" data-field="fish_pond_name">鱼塘名称</a></li>
					<li><a href="#" data-field="fish_pond_no">鱼塘编号</a></li>
					<li><a href="#" data-field="platform_id">平台号</a></li>
				</ul>
			</div>

			<div class="col-lg-6 input-group" id="filter">
				<div class="input-group-btn">
					<button type="button" class="btn btn-info dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
						data-field>
						<span class="glyphicon glyphicon-filter" aria-hidden="true">筛选</span><span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#" data-field>全部</a></li>
						<li><a href="#" data-field="company_name">公司名称</a></li>
						<li><a href="#" data-field="fish_pond_name">鱼塘名称</a></li>
						<li><a href="#" data-field="fish_pond_no">鱼塘编号</a></li>
						<li><a href="#" data-field="platform_id">平台号</a></li>
					</ul>
				</div>
				<input type="text" class="form-control" aria-label="..." disabled> <span
					class="input-group-btn">
					<button id="submit" class="btn btn-info" type="button" disabled>提交</button>
				</span>
				<!-- /btn-group -->
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<div class="wrap-table">
<%@ include file="onlineDevicesTable.jsp" %>
</div>
<nav id="paging">
	<ul class="pagination" data-amount>
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span><span class="sr-only"></span>
		</a></li>
		<li class="active"><a href="#"><span class="sr-only"></span></a></li>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span><span
				class="sr-only"></span>
		</a></li>
	</ul>
</nav>
<!-- list-online end -->