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
	<h2>Product Manager</h2>
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
				<form:form action="admin/product/index.php" modelAttribute="model" enctype="multipart/form-data">
					<div class="row">
						<div class="form-group col-sm-4">
							<label>Id</label>
							<form:input path="id" cssClass="form-control" readonly="true"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Name</label>
							<form:input path="name" cssClass="form-control"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Unit Price</label>
							<form:input path="unitPrice" cssClass="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-4">
							<label>Units In Stock</label>
							<form:input path="unitsInStock" cssClass="form-control"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Quantity / Unit</label>
							<form:input path="quantityPerUnit" cssClass="form-control"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Discount</label>
							<form:input path="discount" cssClass="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-4">
							<label>Product Date</label>
							<form:input path="productDate" cssClass="form-control datepicker"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Image</label>
							<input type="file" name="upimage" class="form-control"> (${model.image})
							<form:hidden path="image"/>
						</div>
						<div class="form-group col-sm-4">
							<label>View Count</label>
							<form:input path="viewCount" cssClass="form-control"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-4">
							<label>Available?</label>
							<div class="form-control">
								<form:radiobutton path="available" value="true" label="Yes"/>
								<form:radiobutton path="available" value="false" label="No"/>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Latest?</label>
							<div class="form-control">
								<form:radiobutton path="latest" value="true" label="Yes"/>
								<form:radiobutton path="latest" value="false" label="No"/>
							</div>
						</div>
						<div class="form-group col-sm-4">
							<label>Special?</label>
							<div class="form-control">
								<form:radiobutton path="special" value="true" label="Yes"/>
								<form:radiobutton path="special" value="false" label="No"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-4">
							<label>Category</label>
							<form:select path="category.id" cssClass="form-control"
								items="${cates}" itemValue="id" itemLabel="nameVN"/>
						</div>
						<div class="form-group col-sm-4">
							<label>Supplier</label>
							<form:select path="supplier.id" cssClass="form-control"
								items="${supps}" itemValue="id" itemLabel="companyName"/>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-sm-12">
							<label>Description</label>
							<form:textarea path="description" cssClass="form-control" rows="5"/>
						</div>
						<div class="form-group col-sm-12">
							<button class="btn btn-default" formaction="admin/product/insert.php" ${empty model.id?'':'disabled'}>Insert</button>
							<button class="btn btn-default" formaction="admin/product/update.php" ${empty model.id?'disabled':''}>Update</button>
							<button class="btn btn-default" formaction="admin/product/delete.php" ${empty model.id?'disabled':''}>Delete</button>
							<button class="btn btn-default" formaction="admin/product/index.php">Reset</button>
						</div>
					</div>
				</form:form>
			</div>
			<div id="list" class="tab-pane fade">
				<div id="result"></div>
				<div>
					<ul class="pager">
						<li><a href="#"><span class="glyphicon glyphicon-hand-up"></span></a></li>
						<li><a href="#"><span class="glyphicon glyphicon-hand-left"></span></a></li>
						<li><a>page 3 of 15 pages</a></li>
						<li><a href="#"><span class="glyphicon glyphicon-hand-right"></span></a></li>
						<li><a href="#"><span class="glyphicon glyphicon-hand-down"></span></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<script>
	pageNo = 0;
	pageSize = 10;
	pageCount = 2018;
	
	function getPage(){
		$.ajax({
			url:"admin/product/get-page.php",
			data:{pageNo: pageNo, pageSize: pageSize},
			success:function(response){
				$("#result").html(response);
				$(".pager a:eq(2)").html("page "+(pageNo+1)+" of "+pageCount+" pages");
			}
		});
	}
	
	$(function(){
		$.ajax({
			url:"admin/product/get-page-count.php",
			data:{pageSize: pageSize},
			success:function(response){
				pageCount = response;
				getPage();
			}
		});
		
		$(".pager a:first").click(function(){
			pageNo = 0;
			getPage();
			return false;
		});
		
		$(".pager a:eq(1)").click(function(){
			if(pageNo > 0){
				pageNo--;
				getPage();
			}
			return false;
		});
		
		$(".pager a:eq(3)").click(function(){
			if(pageNo < pageCount - 1){
				pageNo++;
				getPage();
			}
			return false;
		});
		
		$(".pager a:last").click(function(){
			pageNo = pageCount - 1;
			getPage();
			return false;
		});
	});
	</script>
</body>
</html>