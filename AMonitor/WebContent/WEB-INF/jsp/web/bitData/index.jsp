<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="expires" content="0" /> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:bundle basename="sso_client"><fmt:message key="webapp.name" /></fmt:bundle> </title>
<link rel="shortcut icon" href="${rootUrl }images/icon.png" />
<link href="${rootUrl}css/common.css" rel="stylesheet" type="text/css" />
<link href="${rootUrl}css/manage.css" rel="stylesheet" type="text/css" />
<link href="${rootUrl}css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootUrl }plugins/jquery/jquery-1.8.2.min.js"></script>
<script src="${rootUrl }js/tjlib/jquery.tjlib.js" type="text/javascript"></script>
<script src="${rootUrl }js/tjlib/jquery.taiji-3.0.js" type="text/javascript"></script>
<script src="${rootUrl }plugins/jquery/jquery.form.js" type="text/javascript"></script>
<script src="${rootUrl }plugins/datepicker/WdatePicker.js" type="text/javascript"></script>
<script src="${rootUrl}jquery/echarts.min.js"></script>
<script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${rootUrl}jquery/highcharts/exporting.js"></script>
<script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts-3d.js"></script>
<script type='text/javascript'>
$(function(){
	$("#sumManage").taiji({
		enableAclCheck:true
	});
	$('#queryBtn').click(function(){
		$("#listForm").trigger("submit");	
	});
	$("#downExcel").click(function(){
		var startNo=$("#startNo").val();
		var endNo=$("#endNo").val();
		if(startNo==''||endNo==''){
			alert('填写下载的开始结束页数');
			return;
		}
		if(isNaN(startNo)||isNaN(endNo)){
			alert("填写的是非数字，请填写数字");
			return;
		}
		var params=$("#listForm").serialize();
		console.log('params==='+params);
		window.location.href="${rootUrl}app/common/bitdata/export?"+params;
// 		$("#listForm").attr("action","${rootUrl}app/common/bitdata/export");
// 		$("#listForm").trigger("submit");
// 		$("#listForm").attr("action","${rootUrl}app/common/bitData/index");
	});
});
</script>
</head>
<body>
	<div id='box'>
		<!-- tops begin -->
		<%@ include file="/WEB-INF/jsp/web/head.jsp" %>
		<!-- tops  end -->
		<!--content begins-->
		<div id='content'>
			<div id="sumManage">			 
				 <div class="sublist-toolbar">
					<form class="taiji_search_form form-inline m-t-5 " modelAttribute="queryModel"  id="listForm" name="listForm" action="${rootUrl }app/common/bitData/index" method="post">
						<div class='sbulist_condition'>
							<ul>
							<li class='conditioninput'><input name="brand" size="25" maxlength="50" placeholder="手机品牌" /></li>
			 				<li class='conditioninput'>
			 					<input style="width:150px" name="startTime" id='startTime' readonly="true"  class="form-control" placeholder="启动时间开始时间" onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});" value='<fmt:formatDate value="${endTime.time }" pattern="yyyy-MM-dd HH:mm:ss" />' />
							</li>
							<li class='conditioninput'>
			 					<input style="width:150px" name="endTime"  id='endTime' readonly="true" class="form-control" placeholder="启动时间结束时间"  onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
 />
			 				</li>
							<li><label class="control-label">每页条数</label></li>
							<li class='conditioninput'>
								<select name="pageSize" data-style="btn-white" data-width="80px">
									<option value="2">2</option>
									<option value="10" selected>10</option>
									<option value="16">16</option>
									<option value="20">20</option>
									<option value="50">50</option>
									<option value="100">100</option>
								</select>
							</li>
							<li>
								<button class="taiji_search_submit btn btn-md btn-primary m-r-5" type="button" id="queryBtn"><i class="fa fa-search  m-r-10 "></i>查询</button>
							</li>
							</ul>
							<ul style='clear:both;margin-top:5px;'>
								<li><label class="control-label">下载开始页</label></li>
								<li class='conditioninput'>
				 					<input style="width:110px" name="startNo"  id='startNo' placeholder="下载开始页" />
				 				</li>
				 				<li><label class="control-label">下载终止页</label></li>
								<li class='conditioninput'>
				 					<input style="width:110px" name="endNo"  id='endNo' placeholder="下载终止页" />
				 				</li>
				 				<li>
								<button class="btn btn-md btn-primary m-r-5" type="button" id="downExcel"><i class="fa fa-search  m-r-10 "></i>下载</button>
								</li>
							</ul>
						</div>
						</form>
				 </div>
				<div class="taiji_search_result table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
							    <th>异常类型</th>
							    <th>异常时间</th>
								<th class="taiji_sortable {orderBy:'createTime',desc:false}">手机品牌</th>
								<th>手机型号</th>
								<th style="width:140px">Android版本</th>
								<th>本机IP地址</th>
								<th>IMEI</th>
								<th>IMSI</th>
								<th style="width:80px">操作</th>								
							</tr>
						</thead>
						<tbody>	
						</tbody>
					</table>
				</div>
				<div class="pageturn taiji_pager"></div>
			</div>
		</div>
		<!--content ends--->
		<!-- footer begins -->
		<%@ include file="/WEB-INF/jsp/web/bottom.jsp" %>
		<!-- footer ends -->
	</div>
</body>
</html>