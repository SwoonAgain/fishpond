<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String baseurl = request.getContextPath();  request.setAttribute("baseurl", baseurl);%>
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
					<label for="inputEmail3" class="col-sm-3 control-label">第一餐目标量</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="第一餐目标量" value="${editParameter.firstMealQuantity }">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-3 control-label">第一餐开时间</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="inputPassword3"
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
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</form>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->