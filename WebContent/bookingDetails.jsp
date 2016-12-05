<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<h2>${successReg}</h2>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Room Booking Details</h2>

	<p>${emptyMsg}</p>
	<p>${bothPassNoMatchMsg}</p>

	<form name="SubmitBookingDetail" action="SubmitBookingDetail" method="post">

		<table class = "table">

			<tr>
				<td>CheckIn Date:</td>
				<td>${bookingDetails.fromDate}</td>
			</tr>

			<tr>
				<td>CheckOut Date:</td>
				<td>${bookingDetails.toDate}</td>
			</tr>

			<tr>
				<td>Room Type:</td>
				<td>${bookingDetails.roomType}</td>
			</tr>

			<tr>
				<td>No. of Rooms:</td>
				<td>${bookingDetails.noOfRooms}</td>
			</tr>
			
			<tr>
				<td>No. of Adults:</td>
				<td>${bookingDetails.noOfAdults}</td>
			</tr>
			
			<tr>
				<td>Basic Room Charge:</td>
				<td>${bookingDetails.basicPrice}</td>
			</tr>
			
			<tr>
				<td>Breakfast Charge:</td>
				<td>${bookingDetails.breakfastCharge}</td>
			</tr>
			
			<tr>
				<td>Cabe Facility Charge:</td>
				<td>${bookingDetails.cabeCharge}</td>
			</tr>
			
			<tr>
				<td>Onsite Parking Charge:</td>
				<td>${bookingDetails.parkingCharge}</td>
			</tr>
			
			<tr>
				<td>Extra Guest Charge:</td>
				<td>${bookingDetails.extraGuestFee}</td>
			</tr>
			
			<tr>
				<td>Tax Amount:</td>
				<td>${bookingDetails.taxAmount}</td>
			</tr>

			<tr>
				<td>Total Price:</td>
				<td>${bookingDetails.totalPrice}</td>
			</tr>

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