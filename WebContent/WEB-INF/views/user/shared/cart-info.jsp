<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}"/>

<div class="nn-cart">
 <div class="panel panel-default">
     <div class="panel-body">
         <img id="cart-img" class="col-sm-5" src="images/shoppingcart.gif" />
         <ul class="col-sm-7">
             <li><span id="cart-count">${cart.count}</span> items</li>
             <li>$ <span id="cart-amount">${cart.amount}</span></li>
             <li><a href="cart/view.php">View Cart</a></li>
         </ul>
     </div>
 </div>
</div>


<style id="cart-fly">

</style>