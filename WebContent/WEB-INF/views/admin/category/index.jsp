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
	<h2>Category Manager</h2>
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
				<form:form action="admin/category/index.php" modelAttribute="model">
					<div class="form-group">
						<label>Id</label>
						<form:input path="id" cssClass="form-control" readonly="true"/>
					</div>
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" cssClass="form-control"/>
					</div>
					<div class="form-group">
						<label>Name VN</label>
						<form:input path="nameVN" cssClass="form-control"/>
					</div>
					
					<div class="form-group">
						<button class="btn btn-default" formaction="admin/category/insert.php" ${empty model.id?'':'disabled'}>Insert</button>
						<button class="btn btn-default" formaction="admin/category/update.php" ${empty model.id?'disabled':''}>Update</button>
						<button class="btn btn-default" formaction="admin/category/delete.php" ${empty model.id?'disabled':''}>Delete</button>
						<button class="btn btn-default" formaction="admin/category/index.php">Reset</button>
					</div>
				</form:form>
			</div>
			<div id="list" class="tab-pane fade">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Name VN</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${items}">
							<tr>
								<td>${item.id}</td>
								<td>${item.name}</td>
								<td>${item.nameVN}</td>
								<td>
									<a class="btn btn-default" href="admin/category/edit.php?id=${item.id}">Edit</a>
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