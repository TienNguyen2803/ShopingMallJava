<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:forEach var="item" items="${items}"></c:forEach>

<c:if test="${empty attr}"></c:if>

<c:choose>
	<c:when test="${test1}"></c:when>
	<c:when test="${test2}"></c:when>
	<c:otherwise></c:otherwise>
</c:choose>

<c:set var="x" value="${y}" scope="session"/>
<c:remove var="x" scope="session"/>

<c:import url="home/index.php">
	<c:param name="" value=""/>
</c:import>

<c:url value="home/index.php" var="setlang">
	<c:param name="lang" value="vi"/>
</c:url>

<c:redirect url="${setlang}"/>

<f:setLocale value="vi"/>
<f:bundle basename="global" prefix="com.procity"/>
<f:message key="staff.age">
	<f:param value="16"/>
	<f:param value="65"/>
</f:message>

<f:parseDate value="" pattern="" type=""/>
<f:parseNumber value="" pattern="" type="" integerOnly=""/>
<f:formatDate value="" pattern="" type=""/>
<f:formatNumber value="" pattern="" type="" minFractionDigits="" maxFractionDigits="" />
