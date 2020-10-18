<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
</head>
<body>
	<h2><s:message code="acc.login"/></h2>
	<div class="alert alert-warning">${message}</div>
	<form action="account/login.php" method="post">
		<div class="form-group">
			<label><s:message code="acc.id"/></label>
			<input name="id" class="form-control" value="${cookie.uid.value}">
		</div>
		
		<div class="form-group">
			<label><s:message code="acc.pw"/></label>
			<input type="password" name="password" class="form-control" value="${cookie.pwd.value}">
		</div>
		
		<div class="form-group">
			<label>
				<input type="checkbox" name="remember" value="true">
				<s:message code="acc.rm"/>
			</label>
		</div>
		
		<div class="form-group">
			<button class="btn btn-default">
				<span class="glyphicon glyphicon-log-in"></span> Login
			</button>
		</div>
	</form>
</body>
</html>