<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>User Registration Page</title>
</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Payment Gateway</h2>

	<p class="text-danger">${emptyPayMsg}</p>
	<p class="text-danger">${bookNotSuccessful}</p>
	<%-- <p>${emptyPayMsg}</p>
	<p>${bookNotSuccessful}</p> --%>


	<form name="paymentServlet" action="PaymentServlet" method="post">
		<table class="table">

			<tr>
				<td><label path="cardNumber">Card Number: </label></td>
				<td><input type="number" name="cardNumber" /></td>
			</tr>

			<tr>
				<td><label path="cardName">Name on Card: </label></td>
				<td><input type="text" name="cardName" /></td>
			</tr>

			<tr>
				<td><label path="cvvNumber">CVV Number: </label></td>
				<td><input type="number" name="cvvNumber"></td>
			</tr>

			<tr>
				<td><label path="amount">Amount: </label></td>
				<td>${totalAmount}</td>
				<!-- <td><input type="number" name="amount"></td> -->
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="right"><input type="submit"
					value="Pay Amount" /></td>
			</tr>
		</table>

	</form>

</body>
</html>