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
    
    <h3>Cancelled Booking Details</h3>
    
	<%-- <p>${bookSuccessful}</p> --%>
	<p class="text-success">${succCancleMsg}</p>
	
	
	
	<form name="userCancelled" action="GotoUserDashboard" method="post">

		<table class ="table">

            <tr>
				<td>Booking ID:</td>
				<td>${bookingDetailSelected.bookingId}</td>
			</tr>
  
			<tr>
				<td>First Name:</td>
				<td>${userProfile.firstName}</td>
			</tr>
			
			<tr>
				<td>Last Name:</td>
				<td>${userProfile.lastName}</td>
			</tr>
			
			<tr>
				<td>From Date:</td>
				<td>${bookingDetailSelected.fromDate}</td>
			</tr>

			<tr>
				<td>To Date:</td>
				<td>${bookingDetailSelected.toDate}</td>
			</tr>

			<tr>
				<td>Room Type:</td>
				<td>${bookingDetailSelected.roomType}</td>
			</tr>

			<tr>
				<td>Number of Rooms:</td>
				<td>${bookingDetailSelected.noOfRooms}</td>
			</tr>
			
			<tr>
				<td>Number of Adults:</td>
				<td>${bookingDetailSelected.noOfAdults}</td>
			</tr>


			<tr>
				<td>Amount Refunded:</td>
				<td>${bookingDetailSelected.totalPrice}</td>
			</tr>

			<tr>
				<td>Booking Status:</td>
				<td>Cancelled</td>
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
			<td><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="left"><input type="submit"
					value="Go to Booking History" /></td>
			</tr>


		</table>

	</form>

</body>
</html>