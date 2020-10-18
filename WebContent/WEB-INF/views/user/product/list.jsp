<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>List of Products</h2>
	<c:forEach var="p" items="${items}">
		<div class="col-sm-4 nn-prod">
			<div class="panel panel-default">
				<div class="panel-heading">${p.name}</div>
				<div class="panel-body">
					<a href="product/detail/${p.id}.php">
						<img src="images/products/${p.image}">
					</a>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="pull-left">$${p.unitPrice}</div>
						<div class="pull-right" data-cart-id="${p.id}">
							<jsp:include page="../shared/cart-buttons.jsp"/>
						</div>
					</div>
				</div>
				<c:choose>
					<c:when test="${p.special}">
						<img src="images/special_icon.gif">
					</c:when>
					<c:when test="${p.latest}">
						<img src="images/new_icon.gif">
					</c:when>
					<c:when test="${p.discount > 0}">
						<img src="images/promo_icon.gif">
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:forEach>
</body>
</html>