<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>Registration</h2>
	<div class="alert alert-warning">${message}</div>
	<form:form action="account/register.php" 
		modelAttribute="user" enctype="multipart/form-data">
		<div class="form-group">
			<label>Username</label>
			<form:input path="id" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Password</label>
			<form:input path="password" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Fullname</label>
			<form:input path="fullname" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Email Address</label>
			<form:input path="email" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Phone</label>
			<form:input path="phone" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<label>Photo</label>
			<input name="upphoto" type="file" class="form-control"/>
		</div>
		<div class="form-group">
			<button class="btn btn-default">Sign Up</button>
		</div>
	</form:form>
</body>
</html>