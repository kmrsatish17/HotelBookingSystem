<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Search for Rooms</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : +0
		});
	});
</script>

<script>
	$(function() {
		$("#datepicker2").datepicker({
			minDate : +0
		});
	});
</script>

</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2 align="center">Welcome To Hotel Mayura</h2>
	<p class="text-danger">${emptySearch}</p>
	<p class="text-danger">${roomNotAvailable}</p>
	<p class="text-danger">${dateNotProper}</p>
	<p class="text-danger">${messageLogOut}</p>

	<table align="right">

		<tr>
			<td align="right">
				<form action="existingUserLogin.jsp" method="POST">
					<div class="form-group">
						<!-- <label path="goToRegister">For User: </label> &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp -->
						<input type="submit" value="User Login" size="10" />&nbsp &nbsp
						&nbsp
					</div>
				</form>
			</td>

			<td align="right">
				<form action="operatorLogin.jsp" method="POST">
					<div class="form-group">
						<!-- <label path="goToLogin">For Receptionist: </label>  -->
						<input type="submit" value="Operator Login" size="2" />
					</div>
				</form>
			</td>

		</tr>
	</table>

	<!-- <table>
		<tr>
			<td>&nbsp &nbsp</td>
		</tr>
	</table> -->

	<h2>Search for Rooms</h2>

	<form name="searchRoom" action="SearchServlet" method="post">
		<table class="table">

			<div class="form-group">
				<tr>
					<td><label path="fromDate">From Date: </label></td>
					<!-- <td><input type="date" name="fromDate" /></td> -->
					<td><input type="text" name="fromDate" id="datepicker" /></td>
				</tr>

			</div>

			<div class="form-group">
				<tr>
					<td><label path="toDate">To Date: </label></td>
					<!-- <td><input type="date" name="toDate" /></td> -->
					<td><input type="text" name="toDate" id="datepicker2" /></td>
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfRooms">No. of Rooms: </label></td>
					<td><input type="number" name="noOfRooms"></td>
				</tr>
			</div>
			
			<div class="form-group">
				<tr>
					<td><label path="noOfAdults">No. of Adults: </label></td>
					<td><input type="number" name="noOfAdults"></td>
				</tr>
			</div>


			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Check Availability" /></td>
			</tr>
		</table>

	</form>

</body>
</html>