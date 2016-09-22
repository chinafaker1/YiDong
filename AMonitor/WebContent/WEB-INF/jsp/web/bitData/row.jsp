<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<tr>
    <td>${vo.excepType}</td>
    <td>${vo.excepTime}</td>
	<td>${vo.brand }</td>
	<td>${vo.type }</td>
	<td>${vo.version }</td>
	<td>${vo.localIp }</td>
	<td>${vo.IMEI }</td>
	<td>${vo.IMSI }</td>
	<td>
		<a href="${rootUrl }app/common/bitData/view/${vo.id}" class="taiji_modal taiji_acl">查看/分析</a>
	</td>
	
</tr>
							