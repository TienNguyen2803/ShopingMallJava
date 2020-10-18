<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Forgot Password</h2>
	<div class="alert alert-warning">${message}</div>
	<form action="account/forgot.php" method="post">
		<div class="form-group">
			<label>Username</label>
			<input name="id" class="form-control">
		</div>
		
		<div class="form-group">
			<label>Email Address</label>
			<input name="email" class="form-control">
		</div>
		
		<div class="form-group">
			<button class="btn btn-default">
				<span class="glyphicon glyphicon-log-in"></span> 
				Retrieve password
			</button>
		</div>
	</form>
</body>
</html>