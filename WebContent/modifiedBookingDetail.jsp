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
				<td>${modifiedRoomToDisplay.fromDate}</td>
			</tr>

			<tr>
				<td>CheckOut Date:</td>
				<td>${modifiedRoomToDisplay.toDate}</td>
			</tr>

			<tr>
				<td>Room Type:</td>
				<td>${modifiedRoomToDisplay.roomType}</td>
			</tr>

			<tr>
				<td>No. of Rooms:</td>
				<td>${modifiedRoomToDisplay.noOfRooms}</td>
			</tr>
			
			<tr>
				<td>No. of Adults:</td>
				<td>${modifiedRoomToDisplay.noOfAdults}</td>
			</tr>
			
			<tr>
				<td>Basic Price:</td>
				<td>${modifiedRoomToDisplay.basicPrice}</td>
			</tr>
			
			<tr>
				<td>Extra Guest Charge:</td>
				<td>${modifiedRoomToDisplay.extraGuestFee}</td>
			</tr>
			
			<tr>
				<td>Tax Amount:</td>
				<td>${modifiedRoomToDisplay.taxAmount}</td>
			</tr>

			<tr>
				<td>Total Price:</td>
				<td>${modifiedRoomToDisplay.totalPrice}</td>
			</tr>
			
			<tr>
				<td>Net Amount to Pay:</td>
				<td>${modifiedRoomToDisplay.netAmountPay}</td>
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="right"><input type="submit"
					value="Continue Booking" /></td>
			</tr>


		</table>

	</form>

</body>
</html>