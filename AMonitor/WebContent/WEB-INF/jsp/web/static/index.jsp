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
<script type='text/javascript'>
$(function(){
// 	$("#sumManage").taiji({
// 		enableAclCheck:true
// 	});
	$('#queryBtn').click(function(){
// 		$("#listForm").trigger("submit");
		$(".taiji_search_result").html("<img src='${rootUrl}images/loading.gif' />");
		var type=$("#condition").val();
		if(type==null||type==""){
			$(".taiji_search_result").html("");
			alert("未选择要素值");
		}
		$.post("${rootUrl}app/common/bitData/static",{"type":type},function(data){
			$(".taiji_search_result").html(data);
		});
	});
	$("#downExcel").click(function(){
		var type=$("#condition").val();
// 		console.log('params==='+params);
		window.location.href="${rootUrl}app/common/bitStaticData/export?type="+type;
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
				 <div class="sumlist_title">
					 <h4>业务异常统计排名</h4>
				 </div>
				 <div class="sublist-toolbar">
					<div class='sbulist_condition'>
						<ul>
						<li class='conditioninput'>
						<select name="condition" id="condition">
							<c:forEach items="${values }" var="vo">
								<option value='${vo }'>${vo.value }</option>
							</c:forEach>
						</select>
						<button class="taiji_search_submit btn btn-md btn-primary m-r-5" type="button" id="queryBtn"><i class="fa fa-search  m-r-10 "></i>查询</button>
						<button class="btn btn-md btn-primary m-r-5" type="button" id="downExcel"><i class="fa fa-search  m-r-10 "></i>下载</button>
						</li>
						
						</ul>
					</div>
				 </div>
				<div class="taiji_search_result table-responsive">
					
				</div>
			</div>
		</div>
		<!--content ends--->
		<!-- footer begins -->
		<%@ include file="/WEB-INF/jsp/web/bottom.jsp" %>
		<!-- footer ends -->
	</div>
</body>
</html>