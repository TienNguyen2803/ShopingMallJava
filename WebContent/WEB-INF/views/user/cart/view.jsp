<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Shopping Cart</h2>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>DISCOUNT</th>
				<th>QUANTITY</th>
				<th>AMOUNT</th>
				<th>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${cart.items}">
				<tr data-item-id="${item.id}" 
					 data-item-price="${item.unitPrice}" 
					 data-item-discount="${item.discount}">
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.unitPrice}</td>
					<td>${item.discount*100}%</td>
					<td>
						<input value="${item.quantity}" style="width:40px" type="number" min="1">
					</td>
					<td class="nn-item-amount">${item.amount}</td>
					<td>
						<button class="btn btn-sm btn-warning">
							<span class="glyphicon glyphicon-trash"></span>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center">
		<a href="${backUrl}" class="btn btn-sm btn-info">
			<span class="glyphicon glyphicon-hand-left"></span> Continue Shopping
		</a>
		<button class="btn btn-sm btn-danger">
			<span class="glyphicon glyphicon-trash nn-clear-cart"></span> Clear Cart
		</button>
		<a href="order/checkout.php" class="btn btn-sm btn-primary">
			<span class="glyphicon glyphicon-hand-right"></span> Checkout
		</a>
	</div>
</body>
</html>