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
	
	<h3>Contact Details</h3>

	<p class="text-danger">${emptyContactMsg}</p>
	<p class="text-danger">${phNumMsg}</p>
	
	<form:errors path="registerProfile.*" />
	<form name="contactDetails" action="ContactDetailServlet" method="post">
		<table class="table">

			<tr>
				<td><label path="address1">Address Line 1</label></td>
				<td><input type="text" name="address1" /></td>
			</tr>

			<tr>
				<td><label path="address2">Address Line 2</label></td>
				<td><input type="text" name="address2" /></td>
			</tr>

			<tr>
				<td><label path="city">City</label></td>
				<td><input type="text" name="city" /></td>
			</tr>
			
			<tr>
				<td><label path="state">State</label></td>
				<td><input type="text" name="state" /></td>
			</tr>

			<tr>
				<td><label path="country">Country</label></td>
				<td><input type="text" name="country" /></td>
			</tr>

			<tr>
				<td><label path="zip">Zip Code </label></td>
				<td><input type="number" name="zip"></td>
			</tr>

			<tr>
				<td><label path="phoneNumber">Phone Number </label></td>
				<td><input type="number" name="phoneNumber"></td>
			</tr>


			<tr>
                <td><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="left"><input type="submit"
					value="Continue Booking" /></td>
			</tr>
		</table>

	</form>

</body>
</html>