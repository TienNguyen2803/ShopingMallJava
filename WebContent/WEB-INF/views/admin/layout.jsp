<!DOCTYPE html>
<html>
<head>
	<jsp:include page="shared/head.jsp"/>
</head>
<body>
    <div class="container">
        <header class="nn-header row" style="height: 90px;">
            <div class="nn-company">
	            <h1>Website administration tool</h1>
            </div>
        </header>
		<jsp:include page="shared/menu.jsp"/>

        <div class="nn-sheet row">
            <article class="nn-body">
                <jsp:include page="${view}"/>
            </article>
        </div>

        <footer class="panel panel-default row">
	        <div class="panel-heading">
	        	<p class="text-center">Nhất Nghệ &copy; 2017. All rights reserved.</p>
	        </div>
        </footer>
    </div>
</body>
</html>