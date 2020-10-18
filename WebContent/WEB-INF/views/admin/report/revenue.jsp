<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Revenue by ${group}</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${group}</th>
				<th>Sold Quantity</th>
				<th>Revenue</th>
				<th>Min Price</th>
				<th>Max Price</th>
				<th>Average Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item[0]}</td>
					<td>${item[1]}</td>
					<td>$<f:formatNumber value="${item[2]}" maxFractionDigits="3"/></td>
					<td>$${item[3]}</td>
					<td>$${item[4]}</td>
					<td>$<f:formatNumber value="${item[5]}" maxFractionDigits="3"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>Total: ?</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>