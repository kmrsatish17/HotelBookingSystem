<%@page import="com.ssdi.project.beans.RoomSearchSelectDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h3>Choose Booking Details</h3>
	

	<p>${emptyMsg}</p>
	<p>${bothPassNoMatchMsg}</p>
	
	

	<%
		RoomSearchSelectDetails selectDetails = (RoomSearchSelectDetails) request.getSession()
				.getAttribute("selectDetails");
	%>

	<form name="bookRoom" action="BookRoomServlet" method="post">
		<table class="table">

			<div class="form-group">
				<tr>
					<td><label path="fromDate">CheckIn Date: </label></td>
					<td>${selectDetails.fromDateSelected}</td>
					<!-- <td><input type="date" name="fromDate" /></td> -->
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="toDate">CheckOut Date: </label></td>
					<td>${selectDetails.toDateSelected}</td>
					<!-- <td><input type="date" name="toDate" /></td> -->
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="roomNeeded">No. of Rooms: </label></td>
					<td>${selectDetails.noOfRoomSelected}</td>
					<!-- <td><input type="number" name="roomNeeded"></td> -->
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfAdults">No. of Adults: </label></td>
					<td>${selectDetails.noOfAdultsSelected}</td>
					<!-- <td><input type="number" name="roomNeeded"></td> -->
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="roomType">Room Type: </label></td>
					<td><select id="roomType" name="roomTypeName">

							<c:forEach items="${selectDetails.roomTypeAvailable}" var="item">
								<option value="${item}">${item}</option>
							</c:forEach>

					</select></td>
					<!-- <td><input type="text" name="roomType"></td> -->
				</tr>
			</div>
			
			<div class="form-group">
				<tr>
					<td><label path="breakfast">Breakfast: </label></td>
					<td><input type="checkbox" name="breakfastChecked"
								value="breakfast"></td>
				</tr>
			</div>
			
			<div class="form-group">
				<tr>
					<td><label path="parking">Onsite Parking: </label></td>
					<td><input type="checkbox" name="parkingChecked"
								value="parking"></td>
				</tr>
			</div>
			
			<div class="form-group">
				<tr>
					<td><label path="cabe">Cab Facility: </label></td>
					<td><input type="checkbox" name="cabeChecked"
								value="cabe"></td>
				</tr>
			</div>


			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->


			<tr>
				<td ><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="right"><input type="submit"
					value="Continue Booking" /></td>
			</tr>

		</table>

	</form>

</body>
</html>