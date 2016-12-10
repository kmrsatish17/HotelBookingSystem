<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>User Registration Page</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : +0
		});
	});
</script>

</head>
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h3>Payment Gateway</h3>

	<p class="text-danger">${emptyPayMsg}</p>
	<p class="text-danger">${bookNotSuccessful}</p>
	<p class="text-danger">${cardNumLengthMsg}</p>
	<p class="text-danger">${cvvNumLengthMsg}</p>
	
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
				<td><label path="expDate">Card Expiry Date: </label></td>
				<td><input type="text" name="expDate" id="datepicker" /></td>
			</tr>

			<tr>
				<td><label path="cvvNumber">CVV Number: </label></td>
				<td><input type="password" name="cvvNumber"></td>
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

				<td><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="right"><input type="submit"
					value="Pay Amount" /></td>
			</tr>
		</table>

	</form>

</body>
</html>