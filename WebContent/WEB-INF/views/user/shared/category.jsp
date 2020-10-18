<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <span class="glyphicon glyphicon-th-list"></span>
        <strong><s:message code="g.category"/></strong>
    </div>

    <div class="list-group">
	    <c:forEach var="c" items="${cates}">
	        <a href="product/list-by-category/${c.id}.php" class="list-group-item">
			    <c:choose>
			    	<c:when test="${pageContext.response.locale.language == 'vi'}">${c.nameVN}</c:when>
			    	<c:otherwise>${c.name}</c:otherwise>
			    </c:choose>	        
	        </a>
	    </c:forEach>
    </div>
</div>