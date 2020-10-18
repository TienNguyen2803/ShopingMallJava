<%@ page pageEncoding="utf-8"%>
<!-- 
	form-group
	form-control
	input-group
	input-group-addon
 -->
<div class="form-group">
	<label>Username</label>
	<input class="form-control">
</div>

<div class="form-group">
	<label>Gender</label>
	<div class="form-control">
		<label><input type="radio" value="true">Male</label>
		<label><input type="radio" value="false">Female</label>
	</div>
</div>

<div class="form-group">
	<label>Salary</label>
	<div class="input-group">
		<div class="input-group-addon">$</div>
		<input class="form-control">
	</div>
</div>