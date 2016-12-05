<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>User Login Page</title>

</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Search Available Rooms for CheckIn</h2>

	<p class="text-danger">${emptySearch}</p>
	<p class="text-danger">${roomNotAvailable}</p>
	
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

	<table align="right">

		<tr>
			<td align="right">
				<form action="RoomEntryDetailServlet" method="POST">
					<div class="form-group">
						<!-- <label path="goToRegister">For User: </label> &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp -->
						<input type="submit" value="Room CheckIn Detail" size="10" />&nbsp
						&nbsp &nbsp
					</div>
				</form>
			</td>

		</tr>
	</table>

	<form name="loginForm" action="SearchRoomEntryServlet" method="post">
		<table class="table">

			<div class="form-group">
				<tr>
					<td><label path="roomType">Room Type: </label></td>
					<td><select id="roomType" name="roomTypeName">
							<option value="deluxe">deluxe</option>
							<option value="luxury">luxury</option>
							<option value="super deluxe">super deluxe</option>
					</select></td>
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfRooms">No. of Rooms: </label></td>
					<td><input type="number" name="noOfRooms"></td>
				</tr>
			</div>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
					
					<td ><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
					<td colspan="10" align="left"><input type="submit"
					value="Search Room" /></td>
			</tr>
		</table>

	</form>

</body>
</html>