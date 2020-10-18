<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Language', 'Speakers (in millions)'],
          <c:forEach var="item" items="${items}">
          ["${item[0]}",  ${item[2]}],
          </c:forEach>
        ]);

      var options = {
        legend: 'none',
        pieSliceText: 'label',
        title: 'Swiss Language Use (100 degree rotation)',
        pieStartAngle: 100,
      };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>	
</head>
<body>

	<h2>Inventory by ${group}</h2>
	<div id="piechart" style="width: 900px; height: 500px;"></div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>${group}</th>
				<th>Total Quantity</th>
				<th>Total Value</th>
				<th>Min Price</th>
				<th>Max Price</th>
				<th>Average Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item[0]}</td>
					<td>${item[1]}</td>
					<td>$<f:formatNumber value="${item[2]}" maxFractionDigits="3"/></td>
					<td>$${item[3]}</td>
					<td>$${item[4]}</td>
					<td>$<f:formatNumber value="${item[5]}" maxFractionDigits="3"/></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>Total: ?</th>
			</tr>
		</tfoot>
	</table>
</body>
</html>