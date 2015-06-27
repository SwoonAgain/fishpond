<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>主页</title>
<link rel="stylesheet" href="/fishPond/resource/css/common.css">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
</head>

<body class="user-style-main">
	<header class="user-style-header">
		<div class="container">
			<span
				style="color: darkcyan; font-size: 30px; display: inline-block; padding: 5px 0; vertical-align: middle;">智能鱼塘管理系统</span>
			<img src="/fishPond/resource/images/logo.jpg" alt="智能鱼塘管理系统" style="height: 50px;" /> <span
				id="user-head-mainpage"><img src="/fishPond/resource/images/user-head-mainpage.png"
				alt="用户" style="height: 40px;" /></span>
		</div>
	</header>
	<div class="container user-style-board">
		<div id="nav" class="pull-left nav-main">
			<ul class="nav nav-pills nav-stacked" role="tablist">
				<li role="presentation" class="active"><a href="#list-online"
					aria-controls="list-online" role="tab" data-toggle="tab"> <span
						class="glyphicon glyphicon-signal" aria-hidden="true"></span>&nbsp;&nbsp;在线
				</a></li>
				<li role="presentation"><a href="#list-all"
					aria-controls="list-all" role="tab" data-toggle="tab"> <span
						class="glyphicon glyphicon-globe" aria-hidden="true"></span>&nbsp;&nbsp;全部
				</a></li>
				<li role="presentation"><a href="#management"
					aria-controls="management" role="tab" data-toggle="tab"> <span
						class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;&nbsp;管理
				</a></li>
				<li role="presentation"><a href="#setting"
					aria-controls="setting" role="tab" data-toggle="tab"> <span
						class="glyphicon glyphicon-cog" aria-hidden="true"></span>&nbsp;&nbsp;设置
				</a></li>
			</ul>
		</div>
		<div id="panel" class="user-panel pull-left tab-content">

			<div id="list-online" role="tabpanel" class="tab-pane active fade in">
				<nav class="navbar navbar-default">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<div class="btn-group navbar-btn-group">
								<div class="unit">
									<button type="button" class="btn btn-success">
										<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp;计划
									</button>
								</div>
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
										<li><a href="#">全选</a></li>
										<li><a href="#">全部不选</a></li>
										<li><a href="#">反选</a></li>
									</ul></span></th>
							<th>公司名称</th>
							<th>鱼塘名称</th>
							<th>鱼塘编号</th>
							<th>平台号</th>
							<th>状态</th>
							<th>查看</th>
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
							<td><span
								class="glyphicon glyphicon-eye-open user-glyphicon-orange"
								aria-hidden="true" data-toggle="modal" data-target="#myModal"></span><span
								class="sr-only">查看</span></td>
						</tr>
						<c:forEach var="onlinedevice" items="${onlinedevices}" varStatus="i">
							<tr>
								<th scope="row"><span class="glyphicon glyphicon-unchecked"
									aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;${i.count}</th>
								<td>${onlinedevice.companyName}</td>
								<td>${onlinedevice.fishPondName}</td>
								<td>${onlinedevice.fishPondNo}</td>
								<td>${onlinedevice.platformId}</td>
								<td id="online-status-${onlinedevice.onlineStatus}"><span
									class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
								<td><span
									class="glyphicon glyphicon-eye-open user-glyphicon-orange"
									aria-hidden="true" data-toggle="modal" data-target="#myModal" data-id="${onlinedevice._id}"></span><span
									class="sr-only">查看</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="list-all" role="tabpanel" class="tab-pane">
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

						<!-- Collect the nav links, forms, and other content for toggling
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#">Link</a></li>
              <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li><a href="#">Separated link</a></li>
                </ul>
              </li>
            </ul>
          </div>
           -->
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
										<li><a href="#">全选</a></li>
										<li><a href="#">全部不选</a></li>
										<li><a href="#">反选</a></li>
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
						<c:forEach var="device" items="${devices}" varStatus="i">
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
			</div>

			<div id="management" role="tabpanel" class="tab-pane">
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
				<!-- 管理页 -->
			</div>
			<div id="setting" role="tabpanel" class="tab-pane">
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
				<!-- 设置内容 end -->
			</div>
		</div>

		<!-- Modal -->
		<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">设备详情</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="firstMealQuantity" class="col-sm-3 control-label">第一餐目标量</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="firstMealQuantity"
										placeholder="第一餐目标量">
								</div>
							</div>
							<div class="form-group">
								<label for="firstMealOpenTime" class="col-sm-3 control-label">第一餐开时间</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="firstMealOpenTime"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第二餐目标量</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="第二餐目标量">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第二餐开时间</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第三餐目标量</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="第三餐目标量">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第三餐开时间</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第四餐目标量</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="第四餐目标量">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">第四餐开时间</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">抛料时间</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">时间间隔</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">手动喂料重量</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="inputPassword3"
										placeholder="">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary">保存</button>
							</div>
						</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</div>
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="/fishPond/resource/js/sugar.js"></script>
</body>
</html>
