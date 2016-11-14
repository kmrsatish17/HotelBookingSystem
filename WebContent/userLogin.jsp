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
	<h2>User Login</h2>

	<p>${emptyLogin}</p>
	<p>${userPassNotMatching}</p>
	<p>${contLoginMsg}</p>
	<p>${userExist}</p>
	
	<form:errors path="loginProfile.*" />
	<form name="loginForm" action="LoginServlet" method="post">
		<table class = "table">

			<tr>
				<td><label path="userName">User Name*</label></td>
				<td><input type="text" name="userName" class="form-control"></td>
			</tr>

			<tr>
				<td><label path="password">Password*</label></td>
				<td><input type="password" name="password" class="form-control"></td>
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
				<td colspan="10" align="left"><input type="submit"
					value="Login" /></td>
			</tr>
		</table>

	</form>


</body>
</html>