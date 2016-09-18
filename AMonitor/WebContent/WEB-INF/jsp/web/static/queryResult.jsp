<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<script src="${rootUrl }plugins/echarts/echarts-all.js" type="text/javascript"></script>
<script type='text/javascript'>
	var batteryIndex=0;//用于确定是第几个电池
	$(function(){
		//**********画图 begins**********************
		var datas=${datas};
		var names=datas.names;//电池名称
		var seriesDatas=datas.datas;//值
		var charts = echarts.init(document.getElementById('piecharts'));
		option = {
			    title : {
			        text: '${type.value}',
// 			        subtext: '纯属虚构',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        data:names
			    },
			    toolbox: {
			        show : true,
			        feature : {
// 			            mark : {show: true},
// 			            dataView : {show: true, readOnly: false},
// 			            magicType : {
// 			                show: true, 
// 			                type: ['pie', 'funnel'],
// 			                option: {
// 			                    funnel: {
// 			                        x: '25%',
// 			                        width: '50%',
// 			                        funnelAlign: 'left',
// 			                        max: 1548
// 			                    }
// 			                }
// 			            },
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    series : [
			        {
			            name:'访问来源',
			            type:'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:seriesDatas
			        }
			    ]
			};
		charts.setOption(option);
	});
</script>
<div class='searchResult'>
<div class='tablelist'>
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th style='color:#FFF'>序号</th>
				<th style='color:#FFF'>名称</th>
				<th style='color:#FFF'>数量</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${lists}" var="vo"  varStatus="voStatus">
			<tr>
				<td>${voStatus.index+1 }</td>
				<td>${vo.name }</td>
				<td>${vo.count }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<div class='charts' id='piecharts'>
	
</div>
</div>