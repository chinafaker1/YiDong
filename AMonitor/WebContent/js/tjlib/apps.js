/*
Template Name: Color Admin Responsive Admin Template
Author: Sean Ngu
Author URL: http://www.sean-theme.com/pixel-admin/
Version: 1.0
*/
var handleSlimScroll=function(){
	"use strict";
	$("[data-scrollbar=true]").each(function(){
		var e=$(this).attr("data-height");
		e=!e?$(this).height():e;
		$(this).slimScroll({height:e,alwaysVisible:true})})
	};
var handleSidebarMenu=function(){
		"use strict";
		$(".sidebar .nav > .has-sub > a").click(function(){
			var e=$(this).next(".sub-menu");
			var t=".sidebar .nav > li.has-sub > .sub-menu";
			$(t).not(e).slideUp(250);
			$(e).slideToggle(250)});
			$(".sidebar .nav > .has-sub .sub-menu li.has-sub > a").click(function(){
				var e=$(this).next(".sub-menu");$(e).slideToggle(250)
			});
		};
var handleMobileSidebarToggle=function(){
	$(".sidebar").click(function(e){e.stopPropagation()});
	$(document).click(function(e){
		if(!e.isPropagationStopped()){
			if($("#page-container").hasClass("sidebar-toggled")){
				$("#page-container").removeClass("sidebar-toggled")}
		}
	});
	$("[data-click=sidebar-toggled]").click(function(e){
		e.stopPropagation();
		var t="sidebar-toggled";
		var n="#page-container";if($(n).hasClass(t)){$(n).removeClass(t)}else{$(n).addClass(t)}
	})
};

var handleSidebarMinify=function(){
	$("[data-click=sidebar-minify]").click(function(e){
		e.preventDefault();
		var t="sidebar-minified";
		var n="#page-container";
		if($(n).hasClass(t)){
			$(n).removeClass(t)
		}else{
			$(n).addClass(t)
		}
		$(window).trigger("resize")})
};
var handlePageContentView=function(){
	"use strict";
	$.when($("#page-loader").addClass("hide")).done(function(){
		$("#page-container").addClass("in")
		})
};
var handlePanelAction=function(){
	"use strict";
	$(document).on("hover","[data-click=panel-remove]",function(){
		$(this).tooltip({title:"Remove",placement:"bottom",trigger:"hover",container:"body"});
		$(this).tooltip("show")
		});
	$(document).on("click","[data-click=panel-remove]",function(e){e.preventDefault();$(this).closest(".panel").remove()});
	$(document).on("hover","[data-click=panel-collapse]",function(){$(this).tooltip({title:"Collapse / Expand",placement:"bottom",trigger:"hover",container:"body"});$(this).tooltip("show")});
	$(document).on("click","[data-click=panel-collapse]",function(e){
		e.preventDefault();$(this).closest(".panel").children().not(".panel-heading").slideToggle()
		});
	$(document).on("hover","[data-click=panel-reload]",function(){$(this).tooltip({title:"Reload",placement:"bottom",trigger:"hover",container:"body"});$(this).tooltip("show")});
	$(document).on("click","[data-click=panel-reload]",function(e){
		e.preventDefault();
		var t=$(this).closest(".panel");
		t.find(".taiji_search_submit").click();
		});
	$(document).on("hover","[data-click=panel-expand]",function(){$(this).tooltip({title:"Expand / Compress",placement:"bottom",trigger:"hover",container:"body"});$(this).tooltip("show")});
	$(document).on("click","[data-click=panel-expand]",function(e){
		e.preventDefault();
		var t=$(this).closest(".panel");
		if($("body").hasClass("panel-expand")&&$(t).hasClass("panel-expand")){
			$("body, .panel").removeClass("panel-expand");
			$(".panel").removeAttr("style");
			$("[class*=col]").sortable("enable")
		}else{
			$("body").addClass("panel-expand");
			$(this).closest(".panel").addClass("panel-expand");
			$("[class*=col]").sortable("disable")
		}
		$(window).trigger("resize")})
};
var handleDraggablePanel=function(){
	"use strict";
	var e="[class*=col]";
	var t=".panel-heading";
	var n=".row > [class*=col]";
	$(e).sortable({handle:t,connectWith:n})
};
var handelTooltipPopoverActivation=function(){
	"use strict";
	$("[data-toggle=tooltip]").tooltip();
	$("[data-toggle=popover]").popover()};
var handleScrollToTopButton=function(){
	"use strict";
	$(document).scroll(function(){
		 var e=$(document).scrollTop();
		 if(e>=200){$("[data-click=scroll-top]").addClass("in")}else{$("[data-click=scroll-top]").removeClass("in")}
	});
	$("[data-click=scroll-top]").click(function(e){e.preventDefault();$("html, body").animate({scrollTop:$("body").offset().top},500)})
};
var App=function(){
	"use strict";
	return{
		init:function(){
			handleSlimScroll();
			handleSidebarMenu();
			handleMobileSidebarToggle();
			handleSidebarMinify();
			handlePageContentView();
			handlePanelAction();
			handleDraggablePanel();
			handelTooltipPopoverActivation();
			handleScrollToTopButton()}}
}();