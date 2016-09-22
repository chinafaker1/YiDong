<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul id="myTab" class="nav nav-tabs">
	<li class="active"><a href="#tab1" data-toggle="tab">基础信息</a></li>
	<li><a href="#tab2" data-toggle="tab">业务异常信息</a></li>
	<li><a href="#tab3" data-toggle="tab">分析</a></li>

</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade in active" id="tab1">
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
			<td style="font-weight: bold;">异常类型：</td>
			<td>${vo.excepType }</a></td>
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
		<td style="font-weight: bold;">经度：</td>
		<td>${vo.longitude }</td>
		<td style="font-weight: bold;">纬度：</td>
		<td>${vo.latutide }</td>
		</tr>
		<tr>
		<td style="font-weight: bold;">地址：</td>
		<td>${vo.addr }</td>
		</tr>
		</table>
	</div>
	<div class="tab-pane fade" id="tab2">
		<table class="table table-bordered">
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
	<div class="tab-pane fade" id="tab3">
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
     <div id="container" style="min-width:58%;height:367px"></div>
      <div id="1"><p class="conclusion">结论：${txtMemRate} ${txtCpuRate} ${txte} ${other1}</p></div>
     <div id="environment" style="min-width:58%;height:367px"></div>
     <div id="2"><p class="conclusion">结论：${compareE}影响程度最大”</p></div>
     <div id="RSRP"  style="min-width:58%;height:367px"></div>
    <div id="RSRQ" style="min-width:58%;height:367px"></div>
    <div id="PacketLossRate-UL" style="min-width:58%;height:367px"></div>
    <div id="PacketLossRate-DL" style="min-width:58%;height:367px"></div>
    <div id="Sinr-UL" style="min-width:58%;height:367px"></div>  
	</div>
   <script type="text/javascript"> 
 var xx= new Array();
   
   for(var i=0;i<48;i++)
   {
      
           xx[i]=i+"区间";

 
       } 
   var ee=${ee};
   var cpuRate=${cpuRate};
   var MemRate=${MemRate};
   var eUL_SINR=${eUL_SINR};
   var eRSRP=${eRSRP};
   var eRSRQ=${eRSRQ};
   var eUL_PLR=${eUL_PLR};
   var eUL=${eUL};
   var eDL=${eDL};
   var eDL_PLR=${eDL_PLR};
   var indexRsrp=${indexRsrp};
   var indexRsrq=${indexRsrq};
   var indexExpRsrp=${indexExpRsrp};
   var indexExpRsrq=${indexExpRsrq};
   var indexExpSinrUl=${indexExpSinrUl};
   var mrRP='${mrRP}'.split(',');
   var mrRQ='${mrRQ}'.split(',');
   var mrDL='${mrDL}'.split(',');
   var mrUL='${mrUL}'.split(',');
   var mrSL='${mrSL}'.split(',');
   var RP=new Array();
   var RQ=new Array();
   var DL=new Array();
   var UL=new Array();
   var SL=new Array();
   for(var i=0;i<48;i++)
   {   
	   RP[i]=parseFloat(mrRP[i]);
   } 
   for(var a=0;a<18;a++)
   {   
	   RQ[a]=parseFloat(mrRQ[a]);
   } 
   for(var b=0;b<28;b++)
   {   
	   DL[b]=parseFloat(mrDL[b]);
   } 
   for(var c=0;c<28;c++)
   {   
	   UL[c]=parseFloat(mrUL[c]);
   } 
   for(var d=0;d<37;d++)
   {   
	   SL[d]=parseFloat(mrRP[d]);
   }            
                
				show3();
				show4('RSRP',RP);
				//show('RSRP',RP);
				show4('RSRQ',RQ);
				show4('PacketLossRate-UL',UL);
				show4('PacketLossRate-DL',DL);
				show4('Sinr-UL',SL);
				show5();
				function show3() {
					var data = [ {
						color : "#C1232B",
						y : ee
					}, {
						color : "#D7504B",
						y : MemRate
					}, {
						color : "#60C0DD",
						y : cpuRate
					}, ];

					// Set up the chart
					var chart = new Highcharts.Chart({
						chart : {
							backgroundColor : '#FFFFFF',
							borderWidth : 0,
							borderRadius : 0,
							plotBackgroundColor : null,
							plotShadow : false,
							plotBorderWidth : 0,
							renderTo : 'container',
							type : 'column',
							margin : 75,
							options3d : {
								enabled : true,
								alpha : 15,
								beta : 0,
								depth : 50,
								viewDistance : 25
							}
						},
						xAxis : [ { //X轴标签 
							categories : [ '无线环境', '内存占用率', 'CPU使用率' ],
							labels : {
								rotation : -45,

							}
						} ],
						yAxis:{

							title:{

							text:'影响程度/占比（%）'

							}

							},
						plotOptions : {
							column : {
								dataLabels : {
									enabled : true, // 在节点显示数据
									//color: '#000000',  // 设置节点显示数据字体的颜色
									formatter : function() {
										return this.point.y + '%'; // 重新设置节点显示数据
									},
								},
							}
						},
						legend : {

							enabled : false
						},
						title : {
							text : '无线环境影响程度与终端性能'
						},

						credits : {
							enabled : false
						},
						exporting : {
							enabled : false
						},
						series : [ {
							name : '影响程度/占比（%）',
							data : data,
							type : 'column'
						} ],
					});

					// Activate the sliders

					// Apply the theme
					var highchartsOptions = Highcharts
							.setOptions(Highcharts.theme);
				}
				function show4(name,data) {
					var finalData = [];

					if(name=="RSRP"){
					for(var i=0;i<data.length;i++) {
					  var d = data[i];
					  if(i==indexRsrp) 
						  var g='blue';
					  else if(i==indexExpRsrp)
						  var g='red';
					  else var g='green';
					  finalData.push({
					    y: d,
					    color: g  
					  })
					} 
					}
					
					else if(name=="RSRQ"){
						for(var i=0;i<data.length;i++) {
							  var d = data[i];
							  if(i==indexRsrq) 
								  var g='blue';
							  else if(i==indexExpRsrq)
								  var g='red';
							  else var g='green';
							  finalData.push({
							    y: d,
							    color: g  
							  })
							} 
							}
					else if(name=="PacketLossRate-UL"||name=="PacketLossRate-DL"){
						for(var i=0;i<data.length;i++) {
							  var d = data[i];
							  var g='green';
							  finalData.push({
							    y: d,
							    color: g  
							  })
							} 
							}
					else{
						for(var i=0;i<data.length;i++) {
							  var d = data[i];
							 if(i==indexExpSinrUl)
							 var g='red';
							 else var g='green';
							  finalData.push({
							    y: d,
							    color: g  
							  })
							} 
						}
					// Set up the chart
					var chart = new Highcharts.Chart({
						chart : {
							backgroundColor : '#FFFFFF',
							borderWidth : 0,
							borderRadius : 0,
							plotBackgroundColor : null,
							plotShadow : false,
							plotBorderWidth : 0,
							renderTo : name,
							type : 'column',
							margin : 75,
							options3d : {
								enabled : true,
								alpha : 0,
								beta : 0,
								depth : 50,
								viewDistance : 25
							}
						},
						xAxis : [ { //X轴标签 
							categories : xx,
							labels : {
								rotation : -45,

							}
						} ],
						yAxis:{

							title:{

							text:'样本数'

							}

							},
						plotOptions : {
							column : {
								dataLabels : {
									enabled : true, // 在节点显示数据
									//color: '#000000',  // 设置节点显示数据字体的颜色
									formatter : function() {
										if(name=="RSRP")
											{
											if(this.point.x==indexRsrp)
												return "APP均值";
											else if(this.point.x==indexExpRsrp)
												return "MR均值";
							
											}
										else if(name=="RSRQ")
											{
											if(this.point.x==indexRsrq)
												return "APP均值";
											else if(this.point.x==indexExpRsrq)
												return "MR均值";
								
											}
										else if(name=="Sinr-UL")
											{
											if(this.point.x==indexExpSinrUl)
												return "MR均值";
											
											}
										else
										return this.point.y; // 重新设置节点显示数据
									},
								},
							}
						},
						legend : {

							enabled : false
						},
						title : {
							text : name,
						},

						credits : {
							enabled : false
						},
						exporting : {
							enabled : false
						},
						series : [ {
							name : '样本数',
							data : finalData,
							type : 'column'
						} ],
					});

					// Activate the sliders

					// Apply the theme
					var highchartsOptions = Highcharts
							.setOptions(Highcharts.theme);
				}
				function show5()
			     {
			     var data=[{color:"#C1232B",y:eUL_SINR},
			           	{color:"#D7504B",y:eRSRQ},
			        	{color:"#60C0DD",y:eRSRP},
			        	{color:"#E87C25",y:eUL_PLR},
			        	{color:"#27727B",y:eUL},
			        	{color:"#9BCA63",y:ee},
			        	{color:"#FAD860",y:eDL},
			           	{color:"#F3A43B",y:eDL_PLR},
			        	{color:"#60C0DD",y:eRSRP},
			        	{color:"#D7504B",y:eRSRQ}
			        	
			        	];

			    	    // Set up the chart
			    	    var chart = new Highcharts.Chart({
			    	        chart: {
			    	        	backgroundColor:'#FFFFFF',
			    	    		borderWidth: 0,
			    	    		borderRadius: 0,
			    	    		plotBackgroundColor: null,
			    	    		plotShadow: false,
			    	    		plotBorderWidth: 0,
			    	            renderTo: 'environment',
			    	            type: 'column',
			    	            margin: 75,
			    	            options3d: {
			    	                enabled: true,
			    	                alpha: 15,
			    	                beta: 0,
			    	                depth: 50,
			    	                viewDistance: 25
			    	            }
			    	        },
			    	        xAxis: [{ //X轴标签 
			    	            categories: ['SINR-UL', 'RSRQ', 'RSRP', 'PLR-UL', '上行', 
			    	       '总体', '下行', 'PLR-DL', 'RSRP', 'RSRQ'], 
			    	            labels: { 
			    	            	rotation: -45,
			  
			    	            } 
			    	        }],
			    	        yAxis:{

								title:{

								text:'影响程度（%）'

								}

								},
			    	        plotOptions: {
			    	        	column: {
			    	               	dataLabels: {
			    	                  enabled: true, // 在节点显示数据
			    	                  //color: '#000000',  // 设置节点显示数据字体的颜色
			    	                  formatter: function() {
			    	                          return this.point.y+'%';  // 重新设置节点显示数据
			    	                       	},
			    	              },
			    	            }
			    	        },
			    	        legend: {
			                    
			                    enabled:false
			                },
			    	        title: {
			    	            text: '无线环境影响程度分析'
			    	        },
			    	       
			    	        credits: {
			    	            enabled:false
			    	          },
			    	          exporting: {
			    	              enabled:false
			    	          },       
			    	        series: [{
			        	       name:'影响程度（%）',   	            
			    	           data: data,
			    	           type:'column'
			    	       }],
			    	    });
			    	    
			          
			    	    // Activate the sliders
			    	  
						

			// Apply the theme
			var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
			     }
				 
			</script>
	</div>
</div>
</body>
</html>