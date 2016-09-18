<%@ page session="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="utils" uri="http://www.taiji.com.cn/tags/utils" %>
<c:url value="/" var="rootUrl" scope="application"></c:url>
<c:if test="${fn:contains(rootUrl,';jsession')}">
	<c:set value="${fn:split(rootUrl,';')[0] }" var="rootUrl" scope="application"/>	
</c:if>
<c:choose>
<c:when test="${not empty cookie.skin }">
	<c:set value="${cookie.skin.value }" var="skin"/>	
</c:when>
<c:otherwise>
	<c:set value="blue" var="skin"/>	
</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${'hide' eq cookie.showHideMenu.value }">
	<c:set var="showHideMenu" value="hide"/>
</c:when>
<c:otherwise>
	<c:set var="showHideMenu" value="show"/>
</c:otherwise>
</c:choose>