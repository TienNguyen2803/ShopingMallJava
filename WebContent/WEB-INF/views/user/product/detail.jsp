<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Product Details</h2>
	<div class="nn-detail">
		<div class="row">
			<div class="col-sm-5 text-center">
				<img alt="" src="images/products/${model.image}">
			</div>
			<div class="col-sm-7">
				<ul>
					<li>Name: ${model.name}</li>
					<li>Unit Price: ${model.unitPrice}</li>
					<li>Quantity / Unit: ${model.quantityPerUnit}</li>
					<li>Units in Stock: ${model.unitsInStock}</li>
					<li>Product Date: ${model.productDate}</li>
					<li>Discount: ${model.discount * 100}%</li>
					<li>Category: ${model.category.nameVN}</li>
					<li>Supplier: ${model.supplier.companyName}</li>
					<li>Available?: ${model.available?'Yes':'No'}</li>
					<li>Latest?: ${model.latest?'Yes':'No'}</li>
					<li>Special?: ${model.special?'Yes':'No'}</li>
					<li>View Count: ${model.viewCount}</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">${model.description}</div>
		</div>
		<hr><hr>
		<div class="row">
			<div class="col-sm-12">
				<!-- tab buttons -->
				<ul class="nav nav-tabs">
					<li class="active">
						<a data-toggle="tab" href="#tab1"> 
							<span class="glyphicon glyphicon-edit"></span>
							HÀNG CÙNG LOẠI
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab2">
							<span class="glyphicon glyphicon-list"></span>
							HÀNG CÙNG NHÀ CUNG CẤP
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab3">
							<span class="glyphicon glyphicon-list"></span>
							HÀNG ĐÃ XEM
						</a>
					</li>
				</ul>
				<!-- tab content -->
				<div class="tab-content">
					<div id="tab1" class="tab-pane fade in active">
						<c:forEach var="p" items="${model.category.products}">
							<a href="product/detail/${p.id}.php">
									<img src="images/products/${p.image}">
							</a>
						</c:forEach>
					</div>
					<div id="tab2" class="tab-pane fade">
						<c:forEach var="p" items="${model.supplier.products}">
							<a href="product/detail/${p.id}.php">
									<img src="images/products/${p.image}">
							</a>
						</c:forEach>
					</div>
					<div id="tab3" class="tab-pane fade">
						<c:forEach var="p" items="${views}">
							<a href="product/detail/${p.id}.php">
									<img src="images/products/${p.image}">
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>