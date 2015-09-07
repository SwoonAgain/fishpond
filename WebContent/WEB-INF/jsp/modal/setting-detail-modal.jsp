<%@ page language="java" trimDirectiveWhitespaces="true"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String baseurl = request.getContextPath();
	request.setAttribute("baseurl", baseurl);
%>
<div class="modal-dialog" id="device-detail">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">A模式</h4>
		</div>
		<div class="modal-body">

			<form action="${baseurl }/rest/set-parameters" method="post"
				id="edit-parameters">
				<input type="hidden" name="deviceId" id="deviceId"
					value="${editParameter.deviceId }" />
				<div class="panel panel-default user-small-panel">
					<div class="panel-heading">
						<h3 class="panel-title">第一餐</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-xs-4">
								<label for="firstMealQuantity" class="control-label">目标量</label>
								<input type="text" class="form-control" id="firstMealQuantity"
									name="firstMealQuantity"
									value="${editParameter.firstMealQuantity }">
							</div>

							<div class="form-group  col-xs-4">
								<label for=firstMealOpenTime class="control-label">开时间</label> <input
									type="text" class="form-control" id="firstMealOpenTime"
									name="firstMealOpenTime"
									value="${editParameter.firstMealOpenTime }">
							</div>
							<div class="form-group  col-xs-4">
								<label for="firstMealCloseTime" class="control-label">关时间</label>
								<input type="text" class="form-control" id="firstMealCloseTime"
									name="firstMealCloseTime"
									value="${editParameter.firstMealCloseTime }">
							</div>
						</div>
					</div>
				</div>

				<div class="panel panel-default user-small-panel">
					<div class="panel-heading">
						<h3 class="panel-title">第二餐</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-xs-4">
								<label for="secondMealQuantity" class="control-label">目标量</label>
								<input type="text" class="form-control" id="secondMealQuantity"
									name="secondMealQuantity"
									value="${editParameter.secondMealQuantity }">
							</div>

							<div class="form-group  col-xs-4">
								<label for="secondMealOpenTime" class="control-label">开时间</label>
								<input type="text" class="form-control" id="secondMealOpenTime"
									name="secondMealOpenTime"
									value="${editParameter.secondMealOpenTime }">
							</div>
							<div class="form-group  col-xs-4">
								<label for="secondMealCloseTime" class="control-label">关时间</label>
								<input type="text" class="form-control" id="secondMealCloseTime"
									name="secondMealCloseTime"
									value="${editParameter.secondMealCloseTime }">
							</div>
						</div>
					</div>
				</div>

				<div class="panel panel-default user-small-panel">
					<div class="panel-heading">
						<h3 class="panel-title">第三餐</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-xs-4">
								<label for="thirdMealQuantity" class="control-label">目标量</label>
								<input type="text" class="form-control" id="thirdMealQuantity"
									name="thirdMealQuantity"
									value="${editParameter.thirdMealQuantity }">
							</div>

							<div class="form-group  col-xs-4">
								<label for="thirdMealOpenTime" class="control-label">开时间</label>
								<input type="text" class="form-control" id="thirdMealOpenTime"
									name="thirdMealOpenTime"
									value="${editParameter.thirdMealOpenTime }">
							</div>
							<div class="form-group  col-xs-4">
								<label for="thirdMealCloseTime" class="control-label">关时间</label>
								<input type="text" class="form-control" id="thirdMealCloseTime"
									name="thirdMealCloseTime"
									value="${editParameter.thirdMealCloseTime }">
							</div>
						</div>
					</div>
				</div>

				<div class="panel panel-info user-small-panel">
					<div class="panel-heading">
						<h3 class="panel-title">其他</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="form-group col-xs-3">
								<label for="throwingTime" class="control-label">抛料时间</label> <input
									type="text" class="form-control" id="throwingTime"
									name="throwingTime" value="${editParameter.throwingTime }">
							</div>

							<div class="form-group  col-xs-3">
								<label for="intervalTime" class="control-label">时间间隔</label> <input
									type="text" class="form-control" id="intervalTime"
									name="intervalTime" value="${editParameter.intervalTime }">
							</div>
							<div class="form-group  col-xs-6">
								<label for="manualFeedWeight" class="control-label">手动喂料重量</label>
								<input type="text" class="form-control" id="manualFeedWeight"
									name="manualFeedWeight"
									value="${editParameter.manualFeedWeight }">
							</div>
						</div>
					</div>
				</div>
			</form>

		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary" id="modal-edit">编辑</button>
			<button type="button" class="btn btn-primary" id="modal-save">保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->