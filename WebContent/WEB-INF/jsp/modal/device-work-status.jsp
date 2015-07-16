<%@ page language="java" trimDirectiveWhitespaces="true"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>状态实时参数</h3>
<table class="table table-striped table-bordered" id="devices-status">
	<c:if test="${empty status }">
	<thead>
	<tr><td COLSPAN="4"><h4 class="alert alert-danger">读取异常！</h4></td></tr>
	</thead>
	</c:if>
	<tbody>
		<tr>
			<td>A风机工作</td>
			<td class="online-status-${status.fanA }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>B药振工作</td>
			<td class="online-status-${status.shockDrugB }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>B风机工作</td>
			<td class="online-status-${status.fanB }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>搅拌工作</td>
			<td class="online-status-${status.stir }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>A振动工作</td>
			<td class="online-status-${status.shockA }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>药泵工作</td>
			<td class="online-status-${status.pumpDrug }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>B振动工作</td>
			<td class="online-status-${status.shockB }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>上料绞龙工作</td>
			<td class="online-status-${status.loadMaterailAuger }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>手动停止</td>
			<td class="online-status-${status.manualStop }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>绞阀工作</td>
			<td class="online-status-${status.valveAuger }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>缺料</td>
			<td class="online-status-${status.lackMaterail }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>排料工作</td>
			<td class="online-status-${status.discharge }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>缺相</td>
			<td class="online-status-${status.lackPhase }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>空压机工作</td>
			<td class="online-status-${status.airCompressor }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
		</tr>
		<tr>
			<td>A药振工作</td>
			<td class="online-status-${status.shockDrugA }"><span
				class="glyphicon glyphicon-certificate" aria-hidden="true"></span></td>
			<td>当前重量</td>
			<td>${status.currentWeight }</td>
		</tr>
	</tbody>
</table>