<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script type="text/javascript" src="${rootUrl}jquery/jquery.js"></script>
    <script src="${rootUrl}jquery/echarts.min.js"></script>
     <script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts.js"></script>
     <script type="text/javascript" src="${rootUrl}jquery/highcharts/exporting.js"></script>
     <script type="text/javascript" src="${rootUrl}jquery/highcharts/highcharts-3d.js"></script>  
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="RSRP" style="width: 600px;height:400px;float:left"></div>
    <div id="RSRQ" style="width: 600px;height:400px;float:left"></div>
    <div id="PDSCHPRBNum" style="width: 600px;height:400px;float:left"></div>
    <div id="PacketLossRateULQ" style="width: 600px;height:400px;float:left"></div>
    <div id="PacketLossRateDLQ" style="width: 600px;height:400px;float:left"></div>
    <div id="SinrUL" style="width: 600px;height:400px;float:left"></div>
    <div id="container" style="min-width:700px;height:400px"></div>
﻿	<div id="sliders" style="min-width:310px;max-width: 800px;margin: 0 auto;">
	</div>
   <script type="text/javascript">
   var listRSRP;
   var listRSRQ;
   var listPDSCHPRBNum;
   var listPacketLossRateULQ;
   var listPacketLossRateDLQ;
   var listSinrUL;
   var listee;
   var indexRsrp;
   var indexRsrq;
   var indexExpPrbNum;
   var meanRsrp;
   var meanRsrq;
   var indexExpSinrUl;
    $.ajax({
		  type: "POST",
		  url:"app/common/bitData/index/tongji",
		  dataType : "json", 
		  success: function (json) {		   
			  var obj=eval(json); //使用这个方法解析json
			  indexRsrp=obj.indexRsrp;
			  indexRsrq=obj.indexRsrq;
			  indexExpSinrUl=obj.indexExpSinrUl;
			  meanRsrp=obj.meanRsrp;
			  meanRsrq=obj.meanRsrq;
			  indexExpPrbNum=obj.indexExpPrbNum;
			  listRSRP=obj.listRSRP;
			  show("RSRP",listRSRP);
			  listRSRQ=obj.listRSRQ;
			  show("RSRQ",listRSRQ);
			  listPDSCHPRBNum=obj.listPDSCHPRBNum;
			  show("PDSCHPRBNum",listPDSCHPRBNum);
			  listPacketLossRateULQ=obj.listPacketLossRateULQ;
			  show("PacketLossRateULQ",listPacketLossRateULQ);
			  listPacketLossRateDLQ=obj.listPacketLossRateDLQ;
			  show("PacketLossRateDLQ",listPacketLossRateDLQ);	
			  listSinrUL=obj.listSinrUL;
			  show("SinrUL",listSinrUL);
			  listee=obj.listee;

			  show3();	                
	       },
	       error: function (json) {
	    	   alert("哈哈哈错啦吧");
	           alert("json=" + json);
	           return false;
	       }
		  });
   function show(name,listname)
   {
	           
		        // 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById(name));
		        var xx= new Array();
		        
		        for(var i=0;i<48;i++)
		        {
		            if(i<10)
		                {
		                xx[i]="0"+i+"";
		                }
		            else
		                {
		                xx[i]=i;
		                }
		      
		            }
		       
		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: name+'数量统计'
		            },
		            tooltip: {},
		            legend: {
		            	type: 'bar',
		                data:['数量']
		            },
		            xAxis: {
		                data: xx
		            },
		            yAxis: {},
		            series: [{
		                name: '数量',
		                type: 'bar',
		                itemStyle: {
		                    normal: {
		                        color: function(params) {
		                            // build a color map as your need.
		                            var colorList = [
		                              '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
		                               '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
		                               '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
		                            ];
                                    if(name=="RSRP")
                                        {
                                      if(params.dataIndex==indexRsrp)
        		                            return '#B5C334';
                                      else if (params.dataIndex==meanRsrp)
                                          return '#FCCE10';
                                      else
                                           return '#F0805A';
                                        }
                                    else if(name=="RSRQ")
                                    {
                                    	 if(params.dataIndex==indexRsrq)
         		                            return '#B5C334';
                                       else if (params.dataIndex==meanRsrq)
                                           return '#FCCE10';
                                       else
                                            return '#F0805A';
                                          }
		                            else if(name=="SinrUL")
			                            {
		                            	 if(params.dataIndex==indexExpSinrUl)
	         		                            return '#B5C334';
	                                       else
	                                            return '#F0805A';
			                            }
		                            else if(name=="PDSCHPRBNum")
		                            {
		                            	 if(params.dataIndex== indexExpPrbNum)
	         		                            return '#B5C334';
	                                       else
	                                            return '#F0805A';
			                            }
		                            else
			                        return '#F0805A';
		                        },
		                      label: {
		                            show: function(params) {
			                            alert("hhhhhh");			           
			                            if(params.dataIndex==8)
			                            return false;
			                            else
				                        return false;
			                        },
		                            position: 'top',
		                            formatter: '{c}'
		                        }
		                    }
		                },
		                data: listname,	                
		            }
		            ]
		        };
		       
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);

	   }
   function show1(name,listname)
   {
	           
		        // 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById(name));
		        var xx= new Array();
		        
		        for(var i=0;i<48;i++)
		        {
		            if(i<10)
		                {
		                xx[i]="0"+i+"";
		                }
		            else
		                {
		                xx[i]=i;
		                }
		      
		            }
		       
		        // 指定图表的配置项和数据
		        var option = {
		            title: {
		                text: name+'影响程度'
		            },
		            tooltip: {},
		            legend: {
		            	type: 'bar',
		                data:['数量']
		            },
		            xAxis: {
		                data:["eRsrp","eRsrq","ePrb","eDlPlr"," eUlPlr","eUlSinr","eUl","eDl","e"]
		            },
		            yAxis: {},
		            series: [{
		                name: '影响程度',
		                type: 'bar',
		                data: listname[0]
		            }]
		        };
		       
		        // 使用刚指定的配置项和数据显示图表。
		        myChart.setOption(option);

	   }
   
  
     function show3()
     {
     var data=[{color:"#C1232B",y:listee[0][5]},
           	{color:"#D7504B",y:listee[0][1]},
        	{color:"#60C0DD",y:listee[0][0]},
        	{color:"#E87C25",y:listee[0][4]},
        	{color:"#27727B",y:listee[0][6]},
        	{color:"#9BCA63",y:listee[0][8]},
        	{color:"#FAD860",y:listee[0][7]},
           	{color:"#F3A43B",y:listee[0][3]},
        	{color:"#60C0DD",y:listee[0][0]},
        	{color:"#D7504B",y:listee[0][1]},
        	{color:"#F4E001",y:listee[0][2]}
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
    	            renderTo: 'container',
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
    	            categories: ['eUL-SINR', 'eRSRQ', 'eRSRP', 'eUL-PLR', 'eUL', 
    	       'e', 'eDL', 'eDL-PLR', 'eRSRP', 'eRSRQ', 'ePRB'], 
    	            labels: { 
    	            	rotation: -45,
  
    	            } 
    	        }],
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
    	            text: '总体影响程度'
    	        },
    	       
    	        credits: {
    	            enabled:false
    	          },
    	          exporting: {
    	              enabled:false
    	          },       
    	        series: [{
        	       name:'影响程度',   	            
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