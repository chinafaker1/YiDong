<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>无MR数据分析结果</p>
<table class="table">
<tr>
<td>RSRP</td>
<td>SINR</td>
<td>内存占用率</td>
<td>CPU使用率</td>
<td >其它因素影响</td>
</tr>
<tr>
<td>${expRsrp}</td>
<td>${expSinr}</td>
<td>${cpuRate}%</td>
<td>${MemRate}%</td>
<td rowspan="2">${other}</td>
</tr>
<tr>
<td colspan="2">${txtRsrp}</td>
<td>${txtMemRate}</td>
<td>${txtCpuRate}</td>
<td></td>
<td></td>
</tr>
</table>
</body>
</html>