<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<title>
	<c:if test="${not empty currentResource }">
		${currentResource.name}-
	</c:if><fmt:message key="webapp.name"  />
</title>
<link rel="shortcut icon" href="${rootUrl }images/favicon.jpg" />
<link href="${rootUrl }plugins/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" />
<link href="${rootUrl }css/manage.css" rel="stylesheet" />
<link href="${rootUrl }css/stylex.css" rel="stylesheet" />
<link href="${rootUrl }css/chosen.css" rel="stylesheet" />
<script src="${rootUrl }plugins/jquery/jquery-1.8.2.min.js"></script>
<script src="${rootUrl }js/tjlib/jquery.tjlib.js" type="text/javascript"></script>
<script src="${rootUrl }js/tjlib/jquery.taiji-3.0.js" type="text/javascript"></script>
<script src="${rootUrl }js/tjlib/apps.js"></script>
<!--[if lt IE 9]>
	<script src="${rootUrl }js/crossbrowserjs/html5shiv.js"></script>
	<script src="${rootUrl }js/crossbrowserjs/respond.min.js"></script>
	<script src="${rootUrl }js/crossbrowserjs/excanvas.min.js"></script>
<![endif]-->
	
<script  type="text/javascript">
var rootUrl='${rootUrl}';

$(document).ready(function() {
	App.init();
	
	$("#${param.myMenuId}").parents("ul.nav li").andSelf().addClass("active");
// 	$("#sidebar ul.nav li.active").each(function(){
// 		$("ol.breadcrumb").append($("<li>",{text:$(this).children("a").text()}));
// 	});
// 	$("ol.breadcrumb>li:last").addClass("active");
	if($("#sidebar ul.nav li.active").length){
		$("h1.page-header").text($("#sidebar ul.nav li.active:last").text());
	}
	
	$("#modPasswd,#modMyself").click(function(){
		$(this).showModal();
		return false;
	});
});
</script>
