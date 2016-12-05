<%@page import="com.ssdi.project.beans.RoomBookingDetails"%>
<%@page import="com.ssdi.project.beans.RoomSearchSelectDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>

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


	
	<%!
	
	String roomType = "gbybhunjmk";
	%>

</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Modify Booking</h2>
	<p class="text-danger">${emptyModification}</p>
	<p class="text-danger">${dateNotProper}</p>
	
	<%
	  RoomBookingDetails roomDetail = (RoomBookingDetails) request.getSession().getAttribute("bookingDetailSelected");
	
	%>

	<form name="searchRoom" action="ModifyBookingProcessServlet"
		method="post">
		<table class="table">

			<div class="form-group">
				<tr>
					<td><label path="fromDate">From Date: </label></td>
					<!-- <td><input type="date" name="fromDate" /></td> -->
					<td><input type="text" name="fromDate" id="datepicker" <%-- value ="<%=roomDetail.getFromDate()%>" --%> /></td>
				</tr>

			</div>

			<div class="form-group">
				<tr>
					<td><label path="toDate">To Date: </label></td>
					<!-- <td><input type="date" name="toDate" /></td> -->
					<td><input type="text" name="toDate" id="datepicker2" <%-- value ="<%=roomDetail.getToDate()%>" --%> /></td>
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfRooms">No. of Rooms: </label></td>
					<td><input type="number" name="noOfRooms" value ="<%=roomDetail.getNoOfRooms()%>"></td> 
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="noOfAdults">No. of Adults: </label></td>
					<td><input type="number" name="noOfAdults" value ="<%=roomDetail.getNoOfAdults()%>" ></td>
				</tr>
			</div>

			<div class="form-group">
				<tr>
					<td><label path="roomType">Room Type: </label></td>
					<td><select id="roomType" name="roomTypeName">
					    <option value="deluxe"><%=roomDetail.getRoomType()%></option>
					    <option value="deluxe">deluxe</option>
					    <option value="luxury">luxury</option>
					    <option value="super deluxe">super deluxe</option>
				</select></td>
				</tr>
			</div>


			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Submit Modification" /></td>
			</tr>
		</table>

	</form>


</body>
</html>