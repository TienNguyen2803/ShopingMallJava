$(function(){
	$("[data-cart-id] .glyphicon-shopping-cart").click(function(){
		var id = $(this).parents("[data-cart-id]").attr("data-cart-id");
		$.ajax({
			url:"cart/add.php",
			data:{id: id},
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
			}
		});
		
		var img = $(this).parents(".panel").find(".panel-body img");
		var src = img.attr("src");
		var css = ".cart-fly{	background-image: url("+src+");background-size: 100% 100%;}";
		$("#cart-fly").html(css);
		img.effect("transfer", {to:"#cart-img", className:"cart-fly"}, 2000);
	});
	
	$("[data-item-id] .glyphicon-trash").click(function(){
		var id = $(this).parents("[data-item-id]").attr("data-item-id");
		$.ajax({
			url:"cart/remove.php",
			data:{id: id},
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
			}
		});
		$(this).parents("[data-item-id]").hide(200);
	});
	
	$(".nn-clear-cart").click(function(){
		$.ajax({
			url:"cart/clear.php",
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
			}
		});
		$(this).parents("table").find("tbody tr").hide(1000);
	});
	
	$("[data-item-id] input").on("input", function(){
		var id = $(this).parents("[data-item-id]").attr("data-item-id");
		var qty = $(this).val();
		
		var price = $(this).parents("[data-item-id]").attr("data-item-price");
		var discount = $(this).parents("[data-item-id]").attr("data-item-discount");
		var amount = price * qty * (1 - discount);
		$(this).parents("[data-item-id]").find(".nn-item-amount").html(amount);
		
		$.ajax({
			url:"cart/update.php",
			data:{id: id, qty: qty},
			dataType:"json",
			success:function(response){
				$("#cart-count").html(response.count);
				$("#cart-amount").html(response.amount);
				
			}
		});
	});
})