<%@ page language="java" trimDirectiveWhitespaces="true"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover"  id="devices-list">
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
		<c:forEach var="device" items="${alldevices}" varStatus="i">
			<tr>
				<th scope="row"><span class="glyphicon glyphicon-unchecked"
					aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;${i.count}</th>
				<td>${device.companyName}</td>
				<td>${device.fishPondName}</td>
				<td>${device.fishPondNo}</td>
				<td>${device.platformId}</td>
				<td class="online-status-${device.onlineStatus}"><span
					class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
