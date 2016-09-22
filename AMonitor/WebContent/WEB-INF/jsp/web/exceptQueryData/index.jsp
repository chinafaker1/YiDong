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
<script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts.js"></script>
<script type="text/javascript" src="${rootUrl}jquery/highcharts/exporting.js"></script>
<script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts-3d.js"></script>
<script type='text/javascript'>
$(function(){
	$("#sumManage").taiji({
		enableAclCheck:true,
		
	});

	$('#queryBtn').click(function(){
		$("#listForm").trigger("submit");
	})
	$("#selectCondition").change(function(){
		$("#inputvalue").val('');
		var value=$(this).val();
		var label=$(this).find("option:selected").text();
		$("#inputvalue").attr('placeholder','请输入'+label+'值');
	});
	$("#addCondition").click(function(){
		var inputValue=$("#inputvalue").val();
		if(inputValue==null||inputValue==''){
			alert("请输入要查询的值");
			return;
		}
		var selectValue=$("#selectCondition").val();
		var selectLabel=$("#selectCondition").find('option:selected').text();
		var length=$("#conditions .selectcondition").length;
		console.log("length====="+length);
		if(length>0){
			alert('已经选择了条件');return;
		}
		//var html="<li class='conditioninput selectcondition' l='"+selectLabel+"' v='"+selectValue+"' >"+selectLabel+"值:"+inputValue+"<a href='javascript:void(0);' class='btn btn-info btn-xs delete'>X</a></li>";
		//$("#conditions").append(html);
		$("#"+selectValue).val(inputValue);
		$("#listForm").trigger("submit");
	});
	
	
	$(".delete").live('click',function(){
		var p=$(this).parent();
		var selectValue=p.attr('v');
		p.remove();
		$("#"+selectValue).val('');
		
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
		window.location.href="${rootUrl}app/common/bitdata/export?"+params;
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
				 <div class="sumlist_title">
					 <h4>业务异常信息查询-简单查询</h4>
				 </div>
				 <div class="sublist-toolbar">
					<form class="taiji_search_form form-inline m-t-5 " modelAttribute="queryModel"  id="listForm" name="listForm" action="${rootUrl }app/common/exceptQueryData/index" method="post">
						<div class='sbulist_condition'>
							<ul id='conditions'>
							</ul>
							<ul style='display:none;'>
								<li class='conditioninput'><input name="brand" id='brand' size="15" maxlength="50" placeholder="手机品牌" /></li>
								<li class='conditioninput'><input name="type" id='type' size="15" maxlength="50" placeholder="手机型号" /></li>
								<li class='conditioninput'><input name="version" id='version' size="20" maxlength="50" placeholder="Android版本" /></li>
								<li class='conditioninput'><input name="localIp" id="localIp" size="25" maxlength="50" placeholder="本机IP地址" /></li>
								<li class='conditioninput'><input name="AppName" id="AppName" size="20" maxlength="50" placeholder="进程名称" /></li>
								<li class='conditioninput'><input name="IMEI" id="IMEI" size="20" maxlength="50" placeholder="IMEI" /></li>
								<li class='conditioninput'><input name="IMSI" id="IMSI" size="20" maxlength="50" placeholder="IMSI" /></li>
								<li class='conditioninput'><input name="NetType" id="NetType" size="25" maxlength="50" placeholder="网络类型" /></li>
								<li class='conditioninput'><input name="cid" id="cid" size="20" maxlength="50" placeholder="CID" /></li>
								<li class='conditioninput'><input name="LAC" id="LAC" size="20" maxlength="50" placeholder="LAC" /></li>
								<li class='conditioninput'><input name="excepType" id="excepType" size="20" maxlength="50" placeholder="异常类型" /></li>
								<li class='conditioninput'><input name="addr" id="addr" size="20" maxlength="50" placeholder="地址" /></li>
							</ul>
							<ul style='clear:both;margin-top:5px;'>
								<li class='conditioninput'>
									<select name='selectCondition' id="selectCondition">
										<option value='brand'>手机品牌</option>
										<option value='type'>手机型号</option>
										<option value='version'>Android版本</option>
										<option value='localIp'>本机IP地址</option>
										<option value='AppName'>进程名称</option>
										<option value='IMEI'>IMEI</option>
										<option value='IMSI'>IMSI</option>
										<option value='NetType'>网络类型</option>
										<option value='cid'>CID</option>
										<option value='LAC'>LAC</option>
										<option value='LAC'>excepType</option>
										<option value='LAC'>addr</option>
										
									</select>
								</li>
								<li class='conditioninput'><input name="inputvalue" id="inputvalue" size="15" placeholder="请输入手机品牌" /></li>
								<li class='conditioninput'>
									<button class="btn btn-md btn-primary m-r-5" type="button" id="addCondition">查询</button>
									
									<a href="${rootUrl }app/common/exceptQueryData/index/tongji"class="taiji_modal "><img src='${rootUrl }images/analysis.jpg'/></a>
									
								</li>
							</ul>
							<ul style='clear:both;margin-top:5px;'>
								<li class='conditioninput'>
				 					<input style="width:150px" name="startTime" id='startTime' readonly="true"  class="form-control" placeholder="启动时间开始时间" onfocus="WdatePicker({el:$dp.$('startTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endTime\')}'});" />
								</li>
								<li class='conditioninput'>
				 					<input style="width:150px" name="endTime"  id='endTime' readonly="true" class="form-control" placeholder="启动时间结束时间"  onfocus="WdatePicker({el:$dp.$('endTime'),dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'});"
				 					value='<fmt:formatDate value="${endTime.time }" pattern="yyyy-MM-dd HH:mm:ss" />' />
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
								
							</ul>
							<ul style='clear:both;margin-top:5px;'>
								<li><label class="control-label">下载开始页</label></li>
								<li class='conditioninput'>
				 					<input style="width:80px" name="startNo"  id='startNo' placeholder="下载开始页" />
				 				</li>
				 				<li><label class="control-label">下载终止页</label></li>
								<li class='conditioninput'>
				 					<input style="width:80px" name="endNo"  id='endNo' placeholder="下载终止页" />
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
								<th>Android版本</th>
								<th>本机IP地址</th>
								<th>IMEI</th>
								<th>IMSI</th>
								<th width="200px">操作</th>
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