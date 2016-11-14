<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Search for Rooms</title>
</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Search for Rooms</h2>

	<p>${emptySearch}</p>
	<p>${roomNotAvailable}</p>

	<form name="searchRoom" action="SearchServlet" method="post">
		<table class="table">

			<div class="form-group">
			<tr>
				<td><label path="fromDate">From Date: </label></td>
				<td><input type="date" name="fromDate" /></td>
			</tr>
			</div>

			<div class="form-group">
			<tr>
				<td><label path="toDate">To Date: </label></td>
				<td><input type="date" name="toDate" /></td>
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
				<td colspan="10" align="left"><input type="submit"
					value="Check Availability" /></td>
			</tr>
		</table>

	</form>

	<%-- <% if ("true".equals(request.getAttribute("searchFlag"))) { %>
	<form name="bookRoom" action="BookRoomServlet" method="post">
		<table class = "table">

			<tr>
				<td><label path="select">Select</label></td>
				<td><label path="roomType">Room Type</label></td>
				<td><label path="priceDay">Price/Day</label></td>
				<td><label path="roomNo">No. Of Rooms</label></td>

			</tr>
			
			<% List<RoomSearchDetail> myList = (ArrayList<RoomSearchDetail>) request.getAttribute("roomSearchListReq"); %>

			<c:forEach items="${roomSearchListReq}" var="item">
				<tr>
					<td><input type="checkbox" name="checkPls" value="checkPls"></td>
					<td><c:out value="${item.roomType}" /></td>
					<td><c:out value="${item.pricePerDay}" /></td>
					<% request.setAttribute("roomType", "${item.roomType}"); %>
					<% request.setAttribute("pricePerDay", "${item.pricePerDay}"); %>
					<td><input type="number" name="roomNeeded" /></td>
				</tr>
			</c:forEach>
			
			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Submit" /></td>
			</tr>
		</table>

	</form>
	<% } %> --%>

</body>
</html>