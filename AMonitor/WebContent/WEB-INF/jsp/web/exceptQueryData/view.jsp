<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
 
</head>
<body>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h4 class="modal-title">信息--查看</h4>
</div>
<div class="modal-body">
<table class="table table-bordered">
		  <tr>
			<th colspan="4" style="color: #cee1ee; width: 100%; text-align: center;">信息详情</th>
		</tr>
		<tr>
			<th>手机品牌:</th>
			<td>${vo.brand }</a></td>
			<th>手机型号:</th>
			<td>${vo.type}</td>
		</tr>
		<tr>
			<th>Android版本:</th>
			<td>${vo.version }</a></td>
			<th>本机IP地址:</th>
			<td>${vo.localIp}</td>
		</tr>
		<tr>
			<th>IMEI:</th>
			<td>${vo.IMEI }</a></td>
			<th>IMSI:</th>
			<td>${vo.IMSI}</td>
		</tr>
</table>
</div>
<div class="modal-footer">
	<a href="#" class="btn btn-sm btn-white" data-dismiss="modal">关闭</a>
</div>
	
</body>
</html>