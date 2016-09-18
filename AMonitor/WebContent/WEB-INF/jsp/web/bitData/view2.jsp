<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->

    
    
</head>
<body>
<div id='11' style="min-width:700px;height:30px">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>	
</div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
     <div id="container" style="min-width:700px;height:367px"></div>
     <div id="1" style="min-width:700px;height:367px"><p>结论：${txtMemRate} ${txtMemRate} ${txtMemRate} ${txtMemRate}</p></div>
     <div id="environment" style="min-width:700px;height:367px"></div>
     <div id="RSRP"  style="min-width:700px;height:367px"></div>
    <div id="RSRQ" style="min-width:700px;height:367px"></div>
    <div id="PacketLossRate-UL" style="min-width:700px;height:367px"></div>
    <div id="PacketLossRate-DL" style="min-width:700px;height:367px"></div>
    <div id="Sinr-UL" style="min-width:700px;height:367px"></div>  
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
</body>
</html>