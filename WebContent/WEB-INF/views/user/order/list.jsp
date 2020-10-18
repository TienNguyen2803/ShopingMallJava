<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>List of Orders</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>ORDER DATE</th>
				<th>SHIP ADDRESS</th>
				<th>AMOUNT</th>
				<th>STATUS</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${orders}">
				<tr>
					<td>${item.id}</td>
					<td>${item.orderDate}</td>
					<td>${item.shipAddress}</td>
					<td>${item.amount}</td>
					<td>${item.orderStatus.name}</td>
					<td>
						<a href="order/detail/${item.id}.php">Detail</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>