<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

    <h1 align="center" class="bg-primary">Hotel Booking System</h1>
    <h2>Booking Confirmation</h2>
	<p>${bookSuccessful}</p>
	
	
	<form name="userPayment" action="searchRoom.jsp" method="post">

		<table class ="table">

			<tr>
				<td>CheckIn Date:</td>
				<td>${bookSuccessfulDetails.fromDate}</td>
			</tr>

			<tr>
				<td>CheckOut Date:</td>
				<td>${bookSuccessfulDetails.toDate}</td>
			</tr>

			<tr>
				<td>Room Type:</td>
				<td>${bookSuccessfulDetails.roomType}</td>
			</tr>

			<tr>
				<td>Number of Rooms:</td>
				<td>${bookSuccessfulDetails.noOfRooms}</td>
			</tr>

			<tr>
				<td>Basic Price:</td>
				<td>${bookSuccessfulDetails.basicPrice}</td>
			</tr>

			<tr>
				<td>Tax Amount:</td>
				<td>${bookSuccessfulDetails.taxAmount}</td>
			</tr>

			<tr>
				<td>Total Price:</td>
				<td>${bookSuccessfulDetails.totalPrice}</td>
			</tr>

			<tr>
				<td>Booking Status:</td>
				<td>Confirmed</td>
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Go to Search" /></td>
			</tr>


		</table>

	</form>

</body>
</html>