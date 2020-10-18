<%@ page pageEncoding="utf-8"%>

<jsp:useBean id="now" class="java.util.Date" scope="page">
	<jsp:setProperty name="now" property="year" value="110"/>
	<jsp:setProperty name="now" property="month" param="thang"/>
</jsp:useBean>

<jsp:include page="2.el.jsp">
	<jsp:param name="" value=""/>
</jsp:include>

<jsp:forward page="2.el.jsp">
	<jsp:param name="" value=""/>
</jsp:forward>

<jsp:element name=""/>

<%
	String value1 = (String)request.getAttribute("x");
	String value2 = (String)pageContext.findAttribute("x");
	String value3 = (String)pageContext.getAttribute("x", PageContext.REQUEST_SCOPE);
	response.sendRedirect("http://www.google.com");
	
	pageContext.getRequest();
	pageContext.getResponse();
	pageContext.getSession();
	pageContext.getServletContext();
	pageContext.include("2.el.jsp");
	pageContext.forward("2.el.jsp");
%>