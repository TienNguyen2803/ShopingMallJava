<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Order Manager</h2>
	<div>
		<!-- tab buttons -->
		<ul class="nav nav-tabs">
			<li class="active">
				<a data-toggle="tab" href="#edit"> 
					<span class="glyphicon glyphicon-edit"></span> Edit
				</a>
			</li>
			<li>
				<a data-toggle="tab" href="#list">
					<span class="glyphicon glyphicon-list"></span> List
				</a>
			</li>
		</ul>
		<!-- tab content -->
		<div class="tab-content">
			<div id="edit" class="tab-pane fade in active">
				<div class="alert alert-warning">${message}${param.message}</div>
				<form:form action="admin/order/index.php" modelAttribute="model" enctype="multipart/form-data">
					<div class="form-group">
						<label>Id</label>
						<form:input path="id" cssClass="form-control" readonly="${!empty model.id}"/>
					</div>
					<div class="form-group">
						<label>Customer</label>
						<form:input path="customer.id" cssClass="form-control"/>
					</div>
					
					<div class="form-group">
						<label>Order Date</label>
						<form:input path="orderDate" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Required Date</label>
						<form:input path="requiredDate" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Shipped Date</label>
						<form:input path="shippedDate" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Ship Name</label>
						<form:input path="shipName" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Ship Address</label>
						<form:input path="shipAddress" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Amount</label>
						<form:input path="amount" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Order Status</label>
						<form:select path="orderStatus.id" cssClass="form-control" 
							items="${orderStatuses}" itemValue="id" itemLabel="name"/>
					</div>
					<div class="form-group">
						<label>Notes</label>
						<form:textarea path="notes" rows="5" cssClass="form-control"/>
					</div>
					
					<div class="form-group">
						<button class="btn btn-default" formaction="admin/order/insert.php" ${empty model.id?'':'disabled'}>Insert</button>
						<button class="btn btn-default" formaction="admin/order/update.php" ${empty model.id?'disabled':''}>Update</button>
						<button class="btn btn-default" formaction="admin/order/delete.php" ${empty model.id?'disabled':''}>Delete</button>
						<button class="btn btn-default" formaction="admin/order/index.php">Reset</button>
					</div>
				</form:form>
			</div>
			<div id="list" class="tab-pane fade">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Customer</th>
							<th>Order Date</th>
							<th>Ship Address</th>
							<th>Amount</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr>
								<td>${item.id}</td>
								<td>${item.customer.id}</td>
								<td>${item.orderDate}</td>
								<td>${item.shipAddress}</td>
								<td>${item.amount}</td>
								<td>
									<a class="btn btn-default" href="admin/order/edit.php?id=${item.id}">Edit</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	
</body>
</html>