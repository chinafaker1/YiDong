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
		<div style="text-align: left">
		<center><b>系统使用指南说明</b></center>
1.系统登录
  打开浏览器（建议使用IE7.0以上版本或者谷歌浏览器），在网址栏输入：http://localhost:8080/AMonitor/，即可完成登录。

 
2.业务异常事件及其分析<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2.1打开方式<br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击导航栏处的业务异常事件及其分析根据自己的需求选择时间段（实时列表，最近一个小时，最近24小时）<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2.2信息查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;用户可以输入查询异常事件的手机品牌和所处时间段来进行查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;2.3信息下载<br/>
&nbsp;&nbsp;&nbsp;&nbsp;用户根据需要填入下载开始页和下载结束页进行下载，然后点击下载。<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;2.4查看异常的详细信息<br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击每一条异常信息中的查看来查看异常的详细信息<br/>
 
 
&nbsp;&nbsp;&nbsp;&nbsp;2.5 无线环境影响程度与终端性能分析<br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击每一条异常信息中的分析来查看异常的无线环境影响程度与终端性能分析<br/>
 
 
3.查询及结果分析<br/>
&nbsp;&nbsp;&nbsp;&nbsp;3.1打开方式<br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击导航栏处的查询及结果分析及其分析根据自己的查询类型（简单查询和复杂查询）<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;3.2简单查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;（1）通过选择下拉列表中的查询类别和填写具体信息，同时也可以选择启动的开始和结束时间以及每页显示的条数，最后点击查询<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（2）查询完成后可以点击 来进行分析<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（3）下载查询结果<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通过填写下载开始页和下载结束页，点击 来下载查询结果<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（4）查看异常事件的详细信息<br/>
 

&nbsp;&nbsp;&nbsp;&nbsp;3.3复杂查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;（1）添加查询条件<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择下拉列表中查询类型和填写详细信息，点击 按钮<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（2）查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选择完查询条件后，点击 按钮进行查询
 
&nbsp;&nbsp;&nbsp;&nbsp;（3）查询完成后可以点击 来进行分析<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（4）下载查询结果<br/>
&nbsp;&nbsp;&nbsp;&nbsp;通过填写下载开始页和下载结束页，点击 来下载查询结果<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;（5）查看异常事件的详细信息<br/>
4.参数统计<br/>
&nbsp;&nbsp;&nbsp;&nbsp;4.1 打开方式<br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击导航栏处的参数统计，打开参数统计页面<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;4.2业务异常统计排名查询<br/>
&nbsp;&nbsp;&nbsp;&nbsp;通过选择下拉列表的查询类型，然后点击 按钮进行查询<br/>
 
&nbsp;&nbsp;&nbsp;&nbsp;4.3下载查询结果<br/>
&nbsp;&nbsp;&nbsp;&nbsp;查询完成后，点击 按钮进行下载<br/>
5.APP客户端下载 <br/>
&nbsp;&nbsp;&nbsp;&nbsp;点击导航栏处的APP客户端下载即可<br/>
</div>
 <p>具体信息，请点击下载使用指南 <a href="./downloadhelp.jsp">使用指南</a></p>



		<!--content ends--->
		<!-- footer begins -->
		<%@ include file="/WEB-INF/jsp/web/bottom.jsp" %>
		<!-- footer ends -->
	</div>
</body>
</html>