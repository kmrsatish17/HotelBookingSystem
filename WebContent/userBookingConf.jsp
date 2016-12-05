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
    
    <h2>Booking Confirmation</h2>
    
	<%-- <p>${bookSuccessful}</p> --%>
	<p class="text-success">${bookSuccessful}</p>
	<h3>Booking Receipt</h3>
	
	
	<form name="userPayment" action="searchRoom.jsp" method="post">

		<table class ="table">

			<tr>
				<td>First Name:</td>
				<td>${bookSuccessfulDetails.contactDetail.firstname}</td>
			</tr>
			
			<tr>
				<td>Last Name:</td>
				<td>${bookSuccessfulDetails.contactDetail.lastname}</td>
			</tr>
			
			<tr>
				<td>Address Line 1:</td>
				<td>${bookSuccessfulDetails.contactDetail.address1}</td>
			</tr>
			
			<tr>
				<td>Address Line 2:</td>
				<td>${bookSuccessfulDetails.contactDetail.address2}</td>
			</tr>
			
			<tr>
				<td>City:</td>
				<td>${bookSuccessfulDetails.contactDetail.city}</td>
			</tr>
			
			<tr>
				<td>State:</td>
				<td>${bookSuccessfulDetails.contactDetail.state}</td>
			</tr>
			
			<tr>
				<td>Country:</td>
				<td>${bookSuccessfulDetails.contactDetail.country}</td>
			</tr>
			
			<tr>
				<td>Zip:</td>
				<td>${bookSuccessfulDetails.contactDetail.zip}</td>
			</tr>
			
			<tr>
				<td>Phone Number:</td>
				<td>${bookSuccessfulDetails.contactDetail.phoneNumber}</td>
			</tr>
			
			
			
			
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
				<td>Number of Adults:</td>
				<td>${bookSuccessfulDetails.noOfAdults}</td>
			</tr>

			<tr>
				<td>Basic Price:</td>
				<td>${bookSuccessfulDetails.basicPrice}</td>
			</tr>
			
			<tr>
				<td>Breakfast Charge:</td>
				<td>${bookSuccessfulDetails.breakfastCharge}</td>
			</tr>
			
			<tr>
				<td>Cabe Facility Charge:</td>
				<td>${bookSuccessfulDetails.cabeCharge}</td>
			</tr>
			
			<tr>
				<td>Onsite Parking Charge:</td>
				<td>${bookSuccessfulDetails.parkingCharge}</td>
			</tr>
			
			
			<tr>
				<td>Extra Guest Charge:</td>
				<td>${bookSuccessfulDetails.extraGuestFee}</td>
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
			<td><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="left"><input type="submit"
					value="Go to Homepage" /></td>
			</tr>


		</table>

	</form>

</body>
</html>