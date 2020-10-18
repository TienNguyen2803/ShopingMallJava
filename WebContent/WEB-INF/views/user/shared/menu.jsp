<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

        <div class="navbar navbar-inverse row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
			<!--Menu-->
                <ul class="nav navbar-nav">
                    <li><a href="home/index.php"><span class="glyphicon glyphicon-home"></span> <s:message code="g.home"/></a></li>
                    <li><a href="home/about.php"><span class="glyphicon glyphicon-th-list"></span> Giới thiệu</a></li>
                    <li><a href="home/contact.php"><span class="glyphicon glyphicon-earphone"></span> Liên hệ</a></li>
                    <li><a href="home/feedback.php"><span class="glyphicon glyphicon-envelope"></span> Góp ý</a></li>
                    <li><a href="home/faq.php"><span class="glyphicon glyphicon-question-sign"></span> Hỏi đáp</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Tài khoản <span class="caret"></span></a>
                        <ul class="dropdown-menu">
	                        <c:choose>
	                        	<c:when test="${empty sessionScope.user}">
		                            <li><a href="account/login.php">Đăng nhập</a></li>
		                            <li><a href="account/forgot.php">Quên mật khẩu</a></li>
		                            <li><a href="account/register.php">Đăng ký thành viên</a></li>                        	
	                        	</c:when>
	                        	<c:otherwise>
		                            <li><a href="account/logoff.php">Đăng xuất</a></li>
		                            <li><a href="account/change.php">Đổi mật khẩu</a></li>
		                            <li><a href="account/edit.php">Cập nhật hồ sơ</a></li>
		                            <li class="divider"></li>
		                            <li><a href="order/list.php">Đơn hàng</a></li>
		                            <li><a href="order/items.php">Hàng đã mua</a></li>                        	
	                        	</c:otherwise>
	                        </c:choose>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" data-lang="en">English</a></li>
                    <li><a href="#" data-lang="vi">Tiếng Việt</a></li>
                </ul>
			<!--Menu-->
            </div>
        </div>

<script>
$(function(){
	$("[data-lang]").click(function(){
		var lang = $(this).attr("data-lang");
		$.ajax({
			url:"home/about.php",
			data:{lang: lang},
			success:function(response){
				location.reload();
			}
		});
		return false;
	});
})
</script>