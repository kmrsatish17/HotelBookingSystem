<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>

	<h2>${successReg}</h2>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Room CheckIn Details</h2>

	<p>${emptyMsg}</p>
	<p>${bothPassNoMatchMsg}</p>

	<form name="SubmitBookingDetail" action="searchRoomForEntry.jsp" method="post">

		<table class="table">
		
		    <tr>
				<td>First Name:</td>
				<td>${roomEntryDetails.firstName}</td>
			</tr>
			
			<tr>
				<td>Last Name:</td>
				<td>${roomEntryDetails.lastName}</td>
			</tr>
			
			<tr>
				<td>Booking ID:</td>
				<td>${roomEntryDetails.bookId}</td>
			</tr>

			<tr>
				<td>CheckIn Date:</td>
				<td>${roomEntryDetails.fromDate}</td>
			</tr>

			<tr>
				<td>CheckOut Date:</td>
				<td>${roomEntryDetails.toDate}</td>
			</tr>

			<tr>
				<td>Room Type:</td>
				<td>${roomEntryDetails.roomType}</td>
			</tr>

			<tr>
				<td>No. of Rooms:</td>
				<td>${roomEntryDetails.noOfRooms}</td>
			</tr>
			
			<tr>
				<td>Allocated Room No.:</td>
				<td style="width:50%"> </td>
				<c:forEach items="${roomEntryDetails.roomNumberChecked}" var="item">
					<tr>
						<td></td>
						<td><c:out value="${item}" /></td>

					</tr>
				</c:forEach>
			</tr>



			<tr>
				<td colspan="10" align="right"><input type="submit"
					value="Go to Room Entry Search Page" /></td>
			</tr>


		</table>

	</form>

</body>
</html>