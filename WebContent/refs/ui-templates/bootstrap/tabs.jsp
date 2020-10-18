<%@ page pageEncoding="utf-8"%>
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
			Edit Tab Content
		</div>
		<div id="list" class="tab-pane fade">
			List Tab Content
		</div>
	</div>
</div>