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
			<h4 class="modal-title" id="myModalLabel">设备详情</h4>
		</div>
		<div class="modal-body">

			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a
					href="#device-work-status" aria-controls="device-work-status"
					role="tab" data-toggle="tab">工作状态</a></li>
				<li role="presentation"><a href="#device-parameters"
					aria-controls="device-parameters" role="tab" data-toggle="tab">参数</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in active"
					id="device-work-status">
					<%@ include file="device-work-status.jsp"%>

				</div>
				<div role="tabpanel" class="tab-pane" id="device-parameters">
					<%@ include file="device-detail-form.jsp"%>
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-primary hidden" id="modal-edit">编辑</button>
			<button type="button" class="btn btn-primary hidden" id="modal-save">保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->