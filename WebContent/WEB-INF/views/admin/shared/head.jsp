<%@ page pageEncoding="utf-8"%>

	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Website Administration</title>
    <base href="${pageContext.servletContext.contextPath}/">
	
	<!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    
    <!-- jQuery Validation -->
    <script src="js/jquery.validate.min.js"></script>
	
	<!-- jQuery UI -->
    <link href="css/jquery-ui.min.css" rel="stylesheet" />
    <script src="js/jquery-ui.min.js"></script>
	
	<!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
	
	<!-- eShop -->
    <link href="css/jshop.css" rel="stylesheet" />
    
    <script>
    $(function(){
    	$("input.datepicker").datepicker({
    		dateFormat:'mm/dd/yy'
    	});
    })
    </script>