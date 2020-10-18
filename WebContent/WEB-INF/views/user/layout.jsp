<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="shared/head.jsp"/>
</head>
<body>
    <div class="container">
        <header class="nn-header row">
        	<div class="nn-company">
	            <h1>Online shopping mall</h1>
	            <h5>The center point of the professional programming</h5>
            </div>
            <img class="pull-right" src="images/header-object.png" />
            <c:if test="${user.admin}">
            <div style="position: absolute; top: 5px; right: 5px">
            	<a href="admin/product/index.php">Administration</a>
            </div>
            </c:if>
        </header>

		<jsp:include page="shared/menu.jsp"/>

        <div class="nn-sheet row">

            <article class="col-sm-9">
                <div class="nn-body">
                	<jsp:include page="${view}"/>
                </div>
            </article>

            <aside class="col-sm-3">
                <!--CartInfo-->
				<jsp:include page="shared/cart-info.jsp"/>
                <!--/CartInfo-->

                <!--Search-->
				<jsp:include page="shared/search.jsp"/>
                <!--/Search-->

                <!--Category-->
				<jsp:include page="shared/category.jsp"/>
                <!--/Category-->

                <!--Supplier-->
				<jsp:include page="shared/supplier.jsp"/>
                <!--/Supplier-->

                <!--Special-->
				<jsp:include page="shared/special.jsp"/>
                <!--/Special-->

            </aside>
        </div>

        <footer class="panel panel-default row">
	        <div class="panel-heading">
	        	<p class="text-center">Nhất Nghệ &copy; 2017. All rights reserved.</p>
	        </div>
        </footer>
    </div>
</body>
</html>