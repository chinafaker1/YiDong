<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<script>
	$(function(){
	});
</script>
</head>
<body>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h4 class="modal-title">业务异常事件信息--查看</h4>
</div>
<div class="modal-body" style="overflow-x:auto;">
<table class="table table-bordered">
		  <tr>
			<th colspan="4" style="color: #AA0000; width: 100%; text-align: center;">业务异常事件信息详情</th>
		</tr>
		 <tr>
			<th colspan="4" style="color: #AA0000; width: 100%; text-align: left;">手机基本信息</th>
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
		<tr>
		    <th>内存占用率:</th>
			<td>${vo.memRate}</td>
			<th>CPU使用率:</th>
			<td>${vo.cpuRate}</td>
		</tr>
		<tr>
			<th>运营商:</th>
			<td>${vo.corporation }</a></td>
			
		</tr>
		
		
		 <tr>
			<th colspan="4" style="color:#AA0000; width: 100%; text-align: left;">应用进程信息</th>
		</tr>
		<tr>
			<th>应用进程名称:</th>
			<td>${vo.appName }</a></td>
		</tr>
		<tr>
		    <th>异常时间:</th>
			<td>${vo.excepTime}</td>
			 <th>上报次数:</th>
			<td>${vo.uploadNum+1}</td>
		   
		   
		</tr>
		<tr>
		    <th>启动时间</th>
		    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${vo.launtime.time }" /></a></td>
		     <th>退出时间</th>
		    <td>${vo.exittime }</a></td>	   
		</tr>
		<tr>
			<th>UID:</th>
			<td>${vo.uid }</a></td>
			<th>PID:</th>
			<td>${vo.pid}</td>
		</tr>
		<tr>
			<th>进程数:</th>
			<td>${vo.pidNumber }</a></td>
			<th>GID:</th>
			<td>${vo.gid}</td>
		</tr>
		 <tr>
			<th colspan="4" style="color:#AA0000; width: 100%; text-align: left;">业务流量与无线环境信息</th>
		</tr>
		<tr>
		
		<td style="color:#AA0000;">时间戳</td>
		<td style="color:#AA0000;">发送字节量</td>
		<td style="color:#AA0000;">接收字节量</td>
		<td style="color:#AA0000;">RSRP</td>
		<td style="color:#AA0000;">RSRQ</td>
		<td style="color:#AA0000;">SINR</td>
		
		
		<td style="color:#AA0000;">PCI</td>
		<td style="color:#AA0000;">CI</td>
		<td style="color:#AA0000;">Enodeb_id</td>
		<td style="color:#AA0000;">cell_id</td>
		<td style="color:#AA0000;">TAC</td>
		<td  width="150px" style="color:#AA0000;">网络类型</td>
		</tr>
		<c:forEach items="${pg.list}" var="vo1"  varStatus="voStatus">
			<tr>			
			<td>${vo1.timeStamp }</td>
			<td>${vo1.txByte }</td>
	        <td>${vo1.rxByte }</td>
			<td>${vo1.rsrp }</td>
	        <td>${vo1.rsrq }</td>
	        <td>${vo1.rssinr }</td>
	       
	       
	        <td>${vo1.pci }</td>
	        <td>${vo1.ci }</td>
	        <td>${vo1.enodbId }</td>
	        <td>${vo1.cellId }</td>
	        <td>${vo1.tac }</td>
	        <td  style="width:10%">${vo1.netType }</td>
		    </tr>
		</c:forEach>
		
		
</table>
</div>
<div class="modal-footer">
	<a href="#" class="btn btn-sm btn-white" data-dismiss="modal">关闭</a>
</div>
	
</body>
</html>