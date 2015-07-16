<%@ page language="java" trimDirectiveWhitespaces="true"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String url = request.getContextPath();  request.setAttribute("url", url);%>
<table class="table table-hover" id="devices-list">
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
			<th>实时重量</th>
			<th>查看</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="onlinedevice" items="${onlinedevices}" varStatus="i">
			<tr>
				<th scope="row"><span class="glyphicon glyphicon-unchecked"
					aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;${i.count}</th>
				<td>${onlinedevice.companyName}</td>
				<td>${onlinedevice.fishPondName}</td>
				<td>${onlinedevice.fishPondNo}</td>
				<td>${onlinedevice.platformId}</td>
				<td><span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span></td>
				<td class="viewDeviceDetail"  data-toggle="modal" data-target="#device-detail-modal" data-href="${url }/rest/device-detail/${onlinedevice._id}"><span
					class="glyphicon glyphicon-eye-open user-glyphicon-orange"
					aria-hidden="true"></span><span
					class="sr-only">查看</span></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
