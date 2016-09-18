<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->

    
</head>
<body>
<div id='11' style="min-width:58%;height:30px">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>	
</div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="container" style="min-width:58%;height:367px"></div>
    <div id="1">无线环境影响程度为${txte}</div>
     <div id="container1" style="min-width:58%;height:367px"></div>
    <div id="2">CPU使用率为${txtCpu}</div>
      <div id="container2" style="min-width:58%;height:367px"></div>
      <div id="3">内存占用率为${txtMem}</div>
	</div>
   <script type="text/javascript">  
   var a=${a};
   var b=${b};
   var c=${c};
   var aa0=${aa0};
   var aa1=${aa1};
   var aa2=${aa2};
   var aa3=${aa3};
   var aa4=${aa4};
   var aa5=${aa5};
   var aa6=${aa6};
   var aa7=${aa7};
   var aa8=${aa8};
   var aa9=${aa9};
   var bb0=${bb0};
   var bb1=${bb1};
   var bb2=${bb2};
   var bb3=${bb3};
   var bb4=${bb4};
   var bb5=${bb5};
   var bb6=${bb6};
   var bb7=${bb7};
   var bb8=${bb8};
   var bb9=${bb9};
   var cc0=${cc0};
   var cc1=${cc1};
   var cc2=${cc2};
   var cc3=${cc3};
   var cc4=${cc4};
   var cc5=${cc5};
   var cc6=${cc6};
   var cc7=${cc7};
   var cc8=${cc8};
   var cc9=${cc9};
   show3();	
   show4();	
   show5();	
     function show3()
     {
     var data=[{color:"#C1232B",y:aa0},
           	{color:"#D7504B",y:aa1},
        	{color:"#60C0DD",y:aa2},
        	{color:"#E87C25",y:aa3},
        	{color:"#27727B",y:aa4},
        	{color:"#9BCA63",y:aa5},
        	{color:"#FAD860",y:aa6},
           	{color:"#F3A43B",y:aa7},
        	{color:"#60C0DD",y:aa8},
        	{color:"#D7504B",y:aa9}
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
    	            categories: ['0-10%', '10%-20%', '20%-30%','30%-40%','40%-50%','50%-60%','60%-70%','70%-80%','80%-90%','90%-100%'], 
    	            labels: { 
    	            	rotation: -45,
  
    	            } 
    	        }],
    	        yAxis:{

					title:{

					text:'事件数'

					}

					},
    	        plotOptions: {
    	        	column: {
    	               	dataLabels: {
    	                  enabled: true, // 在节点显示数据
    	                  //color: '#000000',  // 设置节点显示数据字体的颜色
    	                  formatter: function() {
        	                      if(this.point.x==a)
    	                          return this.point.y+"（均值 ）";  // 重新设置节点显示数据
    	                          else
    	                          return this.point.y;    
    	                       	},
    	              },
    	            }
    	        },
    	        legend: {
                    
                    enabled:false
                },
    	        title: {
    	            text: '无线环境影响程度统计分析'
    	        },
    	       
    	        credits: {
    	            enabled:false
    	          },
    	          exporting: {
    	              enabled:false
    	          },       
    	        series: [{
        	       name:'事件数',   	            
    	           data: data,
    	           type:'column'
    	       }],
    	    });
    	    
          
    	    // Activate the sliders
    	  
			

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
     }
     function show4()
     {
     var data=[{color:"#C1232B",y:bb0},
           	{color:"#D7504B",y:bb1},
        	{color:"#60C0DD",y:bb2},
        	{color:"#E87C25",y:bb3},
        	{color:"#27727B",y:bb4},
        	{color:"#9BCA63",y:bb5},
        	{color:"#FAD860",y:bb6},
           	{color:"#F3A43B",y:bb7},
        	{color:"#60C0DD",y:bb8},
        	{color:"#D7504B",y:bb9}
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
    	            renderTo: 'container1',
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
    	            categories: ['0-10%', '10%-20%', '20%-30%','30%-40%','40%-50%','50%-60%','60%-70%','70%-80%','80%-90%','90%-100%'], 
    	            labels: { 
    	            	rotation: -45,
  
    	            } 
    	        }],
    	        yAxis:{

					title:{

					text:'事件数'

					}

					},
    	        plotOptions: {
    	        	column: {
    	               	dataLabels: {
    	                  enabled: true, // 在节点显示数据
    	                  //color: '#000000',  // 设置节点显示数据字体的颜色
    	                  formatter: function() {
    	                	  if(this.point.x==b)
    	                          return this.point.y+"（均值） ";  // 重新设置节点显示数据
    	                          else
    	                          return this.point.y;   
    	                       	},
    	              },
    	            }
    	        },
    	        legend: {
                    
                    enabled:false
                },
    	        title: {
    	            text: 'CPU使用率'
    	        },
    	       
    	        credits: {
    	            enabled:false
    	          },
    	          exporting: {
    	              enabled:false
    	          },       
    	        series: [{
        	       name:'事件数',   	            
    	           data: data,
    	           type:'column'
    	       }],
    	    });
    	    
          
    	    // Activate the sliders
    	  
			

// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);
     }
     function show5()
     {
     var data=[{color:"#C1232B",y:cc0},
           	{color:"#D7504B",y:cc1},
        	{color:"#60C0DD",y:cc2},
        	{color:"#E87C25",y:cc3},
        	{color:"#27727B",y:cc4},
        	{color:"#9BCA63",y:cc5},
        	{color:"#FAD860",y:cc6},
           	{color:"#F3A43B",y:cc7},
        	{color:"#60C0DD",y:cc8},
        	{color:"#D7504B",y:cc9}
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
    	            renderTo: 'container2',
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
    	            categories: ['0-10%', '10%-20%', '20%-30%','30%-40%','40%-50%','50%-60%','60%-70%','70%-80%','80%-90%','90%-100%'], 
    	            labels: { 
    	            	rotation: -45,
  
    	            } 
    	        }],
    	        yAxis:{

					title:{

					text:'事件数'

					}

					},
    	        plotOptions: {
    	        	column: {
    	               	dataLabels: {
    	                  enabled: true, // 在节点显示数据
    	                  //color: '#000000',  // 设置节点显示数据字体的颜色
    	                  formatter: function() {
    	                	  if(this.point.x==c)
    	                          return this.point.y+"（均值） ";  // 重新设置节点显示数据
    	                          else
    	                          return this.point.y;   
    	                       	},
    	              },
    	            }
    	        },
    	        legend: {
                    
                    enabled:false
                },
    	        title: {
    	            text: '内存占用率'
    	        },
    	       
    	        credits: {
    	            enabled:false
    	          },
    	          exporting: {
    	              enabled:false
    	          },       
    	        series: [{
        	       name:'事件数',   	            
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