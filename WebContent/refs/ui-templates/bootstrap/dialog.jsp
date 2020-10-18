<%@ page pageEncoding="utf-8"%>
<!-- Hộp thoại -->
<div class="modal fade" id="my-dailog" role="dialog" aria-labelledby="modalTitle">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modalTitle">Tiêu đề hộp thoại</h4>
			</div>
			<div class="modal-body">
				Nội dung hộp thoại
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">Đóng</button>
			</div>
		</div>
	</div>
</div>

<!-- Mở hộp thoại -->
<button class="btn btn-default" data-toggle="modal" data-target="#my-dialog">Open</button>