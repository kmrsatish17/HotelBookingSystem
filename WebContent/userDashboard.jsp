<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>

	<!-- <div class="image-as-bg"> -->
	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2 align="center">Welcome To Hotel Mayura</h2>

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

	<h3 align="left">Room Booking History</h3>

	<p class="text-success">${succCancleMsg}</p>
	<p class="text-danger">${unSuccCancleMsg}</p>
	<p class="text-danger">${radioNotSelected}</p>


	<!-- action="CancelBooking"  -->

	<!-- <table align="right">

		<tr>
			<td align="right">
				<form name="logout" action="ExistingLogoutServlet" method="post"
					align="right">
					<input type="submit" name="logout" value="logout" /> <input
						type="hidden" name="action" value="logout" />
				</form>
			</td>

		</tr>
	</table> -->

	<form name="bookRoom" method="post">
		<table class="table">

			<tr>
				<td><label path="radioBtn"></label></td>
				<!-- <td><label path="radioBtn"></label></td> -->
				<td><label path="bookingId">Booking ID</label></td>
				<td><label path="fromDate">From Date</label></td>
				<td><label path="toDate">To Date</label></td>
				<td><label path="roomType">Room Type</label></td>
				<td><label path="noOfRooms">No. of Rooms</label></td>
				<!-- <td><label path="radioBtn"></label></td>
				<td><label path="radioBtn"></label></td> -->
			</tr>

			<c:forEach items="${bookingDetailList}" var="item">
				<tr>
					<td><input type="radio" name="myradio"
						value="${item.bookingId}" /></td>
					<!-- <td><label path="radioBtn"></label></td> -->
					<td><c:out value="${item.bookingId}" /></td>
					<td><c:out value="${item.fromDate}" /></td>
					<td><c:out value="${item.toDate}" /></td>
					<td><c:out value="${item.roomType}" /></td>
					<td><c:out value="${item.noOfRooms}" /></td>
					<!-- <td>
						<form action="ModifyBooking" method="POST">
						<div class="form-group">
							<input type="submit" formaction="ModifyBooking" value="Modify"
								size="10" />
						</div> </form>
					</td> -->
					<!-- <td>
						<form action="CancelBooking" method="POST">
						<div class="form-group">
							<input type="submit" formaction="CancelBooking" value="Cancel"
								size="10" />
						</div> </form>

					</td> -->

				</tr>
			</c:forEach>

			<tr>

				<td><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>

				<td>
					<!-- <form action="CancelBooking" method="POST"> -->
					<div class="form-group">
						<input type="submit" formaction="CancelBooking" value="Cancel"
							size="10" />
					</div> <!-- </form> -->

				</td>

				<!-- <td style="width:10%"> </td> -->
			</tr>

		</table>

	</form>

	<!-- </div> -->

</body>
</html>