<%@ page pageEncoding="utf-8"%>

<div class="nn-cart">
    <div class="panel panel-default">
        <div class="panel-body">
            <form method="post" action="product/search.php">
                <input placeholder="Keywords"  class="form-control" 
                	name="keywords" value="${param.keywords}" />
            </form>
        </div>
    </div>
</div>