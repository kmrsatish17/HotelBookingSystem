<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<%-- <%
		RoomSearchSelectDetails selectDetails = (RoomSearchSelectDetails) request.getSession().getAttribute("selectDetails");
	%> --%>
	
	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Available Rooms</h2>

	<form name="bookRoom" action="userBooking.jsp" method="post">
		<table class="table">

			<tr>
				<td><label path="fromDate">From Date</label></td>
				<td><label path="toDate">To Date</label></td>
				<td><label path="roomType">Room Type</label></td>
				<td><label path="priceDay">Price Per Day</label></td>
			</tr>

			<c:forEach items="${roomSearchListReq}" var="item">
				<tr>
					<td><c:out value="${item.fromDate}" /></td>
					<td><c:out value="${item.toDate}" /></td>
					<td><c:out value="${item.roomType}" /></td>
					<td><c:out value="${item.pricePerDay}" /></td>
				</tr>
			</c:forEach>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="right"><input type="submit" value="Continue to Book" /></td>
			</tr>
		</table>

	</form>



</body>
</html>