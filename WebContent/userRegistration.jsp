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
	<h2>User Registration</h2>

    <p class="text-danger">${emptyMsg}</p>
    <p class="text-danger">${bothPassNoMatchMsg}</p>

	<form:errors path="registerProfile.*" />
	<form name="register" action="RegisterServlet" method="post">
		<table class = "table">

			<tr>
				<td><label path="userName">User Name</label></td>
				<!-- <td><input type="label" name="firstName">First Name </input></td> -->
				<td><input type="text" name="userName" /></td>
			</tr>

			<tr>
				<td><label path="firstName">First Name</label></td>
				<!-- <td><input type="label" name="firstName">First Name </input></td> -->
				<td><input type="text" name="firstName" /></td>
			</tr>

			<tr>
				<td><label path="lastName">Last Name*</label></td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td><label path="emailId">Email ID*</label></td>
				<td><input type="email" name="emailId"></td>
			</tr>

			<tr>
				<td><label path="password">Password*</label></td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td><label path="confirmPassword">Confirm Password*</label></td>
				<td><input type="password" name="confirmPassword"></td>

			</tr>
			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<!-- <td colspan="10" align="left">
            <input type="submit" value="Back"/>
        </td> -->

				<td colspan="10" align="left"><input type="submit"
					value="Register" /></td>
			</tr>
		</table>

	</form>
	
</body>
</html>