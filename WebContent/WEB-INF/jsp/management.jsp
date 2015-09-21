<%@ page language="java" trimDirectiveWhitespaces="true"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String baseurl = request.getContextPath();
	request.setAttribute("baseurl", baseurl);
%>
<div id="managementTabs">
	<ul>
		<li><a href="#userManage">用户管理</a></li>
		<li><a href="#pondManage">鱼塘信息管理</a></li>
		<li><a href="#campanyManage">公司信息管理</a></li>
		<li><a href="#deviceManage">设备管理</a></li>
	</ul>

	<div id="userManage">
		<div class="actions">
			<button class="btn btn-default">增加</button>
			<button class="btn btn-default">删除</button>
		</div>
		<div id="userList">
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
						<th>username</th>
						<th>phone</th>
						<th>email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
						<td><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div id="pondManage">
		<div id="userList">
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
						<th>username</th>
						<th>phone</th>
						<th>email</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
					<tr>
						<th scope="row"><span class="glyphicon glyphicon-unchecked"
							aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;1</th>
						<td>zhangsan</td>
						<td>13838380438</td>
						<td>im38@38.cn</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div id="campanyManage"></div>

	<div id="deviceManage"></div>
</div>
<!-- management end -->