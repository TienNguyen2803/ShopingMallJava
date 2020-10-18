<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:message code="" text="" arguments=""/>
<s:url value=""></s:url>
<!-- 
 	readonly="true" disabled="true" cssClass="form-control"
 -->
<form:form action="" modelAttribute="bean" enctype="">
	<form:input path="property"/>
	<form:password path=""/>
	<form:hidden path=""/>
	<form:button value=""/>
	<form:label path=""/>
	<form:textarea path="" rows="" cols=""/>
	
	<form:radiobutton path="" value="" label=""/>
	<form:checkbox path="" value="" label=""/>
	
	<form:radiobuttons path="" items="" itemValue="" itemLabel="" delimiter="" element=""/>
	<form:checkboxes path="" items="" itemValue="" itemLabel="" delimiter="" element=""/>
	
	<form:select path="" multiple="" items="" itemValue="" itemLabel=""/>
	<form:select path="" multiple="">
		<form:options  items="" itemValue="" itemLabel=""/>
	</form:select>
	
	<form:errors path="*|property" delimiter="" element=""/>
</form:form>