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
	<h2>Customer Manager</h2>
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
				<form:form action="admin/customer/index.php" modelAttribute="model" enctype="multipart/form-data">
					<div class="form-group">
						<label>Id</label>
						<form:input path="id" cssClass="form-control" readonly="${!empty model.id}"/>
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
						<label>Phone Number</label>
						<form:input path="phone" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Photo</label>
						<input type="file" name="upphoto" class="form-control"> (${model.photo})
						<form:hidden path="photo"/>
					</div>
					<div class="form-group">
						<label>Is Admin?</label>
						<div class="form-control">
							<form:radiobutton path="admin" value="true" label="Yes"/>
							<form:radiobutton path="admin" value="false" label="No"/>
						</div>
					</div>
					<div class="form-group">
						<label>Is Admin?</label>
						<div class="form-control">
							<form:radiobutton path="activated" value="true" label="Yes"/>
							<form:radiobutton path="activated" value="false" label="No"/>
						</div>
					</div>
					
					<div class="form-group">
						<button class="btn btn-default" formaction="admin/customer/insert.php" ${empty model.id?'':'disabled'}>Insert</button>
						<button class="btn btn-default" formaction="admin/customer/update.php" ${empty model.id?'disabled':''}>Update</button>
						<button class="btn btn-default" formaction="admin/customer/delete.php" ${empty model.id?'disabled':''}>Delete</button>
						<button class="btn btn-default" formaction="admin/customer/index.php">Reset</button>
					</div>
				</form:form>
			</div>
			<div id="list" class="tab-pane fade">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Fullname</th>
							<th>Email Address</th>
							<th>Phone Number</th>
							<th>Photo</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr>
								<td>${item.id}</td>
								<td>${item.fullname}</td>
								<td>${item.email}</td>
								<td>${item.phone}</td>
								<td>${item.photo}</td>
								<td>
									<a class="btn btn-default" href="admin/customer/edit.php?id=${item.id}">Edit</a>
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