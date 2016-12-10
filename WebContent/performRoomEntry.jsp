<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Search for Rooms</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>title</title>
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
	<h3 align="left">Available Rooms for CheckIn</h3>
	<p class="text-danger">${emptyEntryMsg}</p>
	<p class="text-danger">${roomReqNotMatchingMsg}</p>
	<p class="text-danger">${dateNotProper}</p>
	
	<table align="right">

		<tr>
			<td>
				<form name="logout" action="ExistingLogoutServlet" method="post"
					align="right">
					<input type="submit" name="logout" value="logout" &nsbp &nsbp /> <input
						type="hidden" name="action" value="logout" />
				</form>
			</td>
		</tr>
	</table>

	<form name="enterRoom" action="RoomEntryServlet" method="post">
		<table class="table">


			<div class="form-group">
				<tr>
					<td><label path="firstName">First Name: </label></td>
					<td><input type="text" name="firstName"></td>

				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="lastName">Last Name: </label></td>
					<td><input type="text" name="lastName"></td>

				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="roomBookingId">Booking Id: </label></td>
					<td><input type="number" name="roomBookingId"></td>
				</tr>
			</div>

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
					<td><label path="roomType">Room Type: </label></td>
					<td>${roomTypeName}</td>
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfRooms">No. of Rooms: </label></td>
					<td>${noOfRooms}</td>

				</tr>
			</div>



			<div class="form-group">
				<tr>
					<td><label path="roomNumber">Available Room Number: </label></td>
					<td style="width: 50%"></td>
					<c:forEach items="${roomList}" var="item">
						<tr>

							<td style="width: 50%"></td>
							<td><input type="checkbox" name="roomNumberChecked"
								value="${item}">${item}</td>
						</tr>
					</c:forEach>
				</tr>
			</div>

			<tr>
			    <td ><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="right"><input type="submit"
					value="CheckIn Rooms" /></td>
			</tr>
		</table>

	</form>

</body>
</html>