<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<div class="navbar-btn-group">
				<div class="unit">
					<button type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-sort" aria-hidden="true"></span>&nbsp;排序
					</button>
				</div>
				<div class="unit">
					<button type="button" class="btn btn-primary">
						<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>&nbsp;筛选
					</button>
				</div>
			</div>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<table class="table table-hover">
	<thead>
		<tr>
			<th><span class="glyphicon glyphicon-unchecked"
				aria-hidden="true"></span> <span class="dropdown user-li-none"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-expanded="false">选择<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li id="select-all"><a href="#">全选</a></li>
						<li id="deselect-all"><a href="#">全部不选</a></li>
						<li id="select-invert"><a href="#">反选</a></li>
					</ul></span></th>
			<th>公司名称</th>
			<th>鱼塘名称</th>
			<th>鱼塘编号</th>
			<th>平台号</th>
			<th>状态</th>
		</tr>
	</thead>
	<tbody>
		<tr class="hidden">
			<th scope="row"><span class="glyphicon glyphicon-unchecked"
				aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;0</th>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td id="online-status-true"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<c:forEach var="device" items="${alldevices}" varStatus="i">
			<tr>
				<th scope="row"><span class="glyphicon glyphicon-unchecked"
					aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;${i.count}</th>
				<td>${device.companyName}</td>
				<td>${device.fishPondName}</td>
				<td>${device.fishPondNo}</td>
				<td>${device.platformId}</td>
				<td id="online-status-${device.onlineStatus}"><span
					class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- list-all end -->