<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Change Password</h2>
	<div class="alert alert-warning">${message}</div>
	<form action="account/change.php" method="post">
		<div class="form-group">
			<label>Username</label>
			<input name="id" class="form-control">
		</div>
		
		<div class="form-group">
			<label>Password</label>
			<input type="password" name="password" class="form-control" >
		</div>
		
		<div class="form-group">
			<label>New Password</label>
			<input type="password" name="newPassword" class="form-control" >
		</div>
		
		<div class="form-group">
			<label>Confirm New Password</label>
			<input type="password" name="confirmPassword" class="form-control" >
		</div>
		
		<div class="form-group">
			<button class="btn btn-default">
				<span class="glyphicon glyphicon-log-in"></span> Change
			</button>
		</div>
	</form>
</body>
</html>