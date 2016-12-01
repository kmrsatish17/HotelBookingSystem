<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body class="background-panel">
	<div class="image-as-bg">
		<h1 align="center" class="bg-primary">Hotel Booking System</h1>
		<h2 align="center">Welcome To Hotel Mayura</h2>

		<form name="existingBooking" action="ExistingBookingServlet" method="post">
			<div class="form-group">
				<label path="goToRegister">For Existing Booking Details: </label> 
				&nbsp<input type="submit" value="Go for Existing Booking" size="10" />
			</div>
		</form>

		<form action="searchRoom.jsp" method="POST">
			<div class="form-group">
				<label path="goToLogin">For New Booking: </label> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <input
					type="submit" value="Go for New Booking &nbsp &nbsp " size="2" />
			</div>
		</form>

	</div>

</body>
</html>