<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Checkout</h2>
	<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>PRICE</th>
				<th>DISCOUNT</th>
				<th>QUANTITY</th>
				<th>AMOUNT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${cart.items}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.unitPrice}</td>
					<td>${item.discount*100}%</td>
					<td>${item.quantity}</td>
					<td>${item.amount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	${message}
	<form:form action="order/checkout.php" modelAttribute="order">
		<form:hidden path="orderStatus.id"/>
		
		<div class="row">
			<div class="form-group col-sm-4">
				<label>Customer</label>
				<form:input path="customer.id" cssClass="form-control" readonly="true"/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>Order Date</label>
				<form:input path="orderDate" cssClass="form-control" readonly="true"/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>Required Date</label>
				<form:input path="requiredDate" cssClass="form-control datepicker"/>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-4">
				<label>Ship Name</label>
				<form:input path="shipName" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>Ship Address</label>
				<form:input path="shipAddress" cssClass="form-control"/>
			</div>
			
			<div class="form-group col-sm-4">
				<label>Amount</label>
				<form:input path="amount" cssClass="form-control" readonly="true"/>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-sm-12">
				<label>Notes</label>
				<form:textarea path="notes" cssClass="form-control" rows="4"/>
			</div>
			
			<div class="form-group col-sm-12">
				<button class="btn btn-default">Purchase</button>
			</div>
		</div>
	</form:form>
</body>
</html>