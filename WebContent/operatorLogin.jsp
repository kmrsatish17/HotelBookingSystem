<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>User Login Page</title>

</head>
<!-- <body style="background-color:#FFF791;"> -->
<body>

	<h1 align="center" class="bg-primary">Hotel Booking System</h1>
	<h2>Operator Login</h2>

	<p class="text-danger">${emptyLogin}</p>
	<p class="text-danger">${userPassNotMatching}</p>
	<p class="text-danger">${messageLogOut}</p>


	<form:errors path="loginProfile.*" />
	<form name="loginForm" action="OprLoginServlet" method="post">
		<table class="table">

			<tr>
				<td><label path="oprUserName">User Name*</label></td>
				<td><input type="text" name="oprUserName" class="form-control"></td>
			</tr>

			<tr>
				<td><label path="oprPassword">Password*</label></td>
				<td><input type="password" name="oprPassword"
					class="form-control"></td>
			</tr>

			<!-- <tr>
				<td>&nbsp &nbsp</td>
			</tr> -->

			<tr>
			
			<td ><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td>
				<td colspan="10" align="left"><input type="submit"
					value="Login" /></td>

				<!-- <td align="left"><INPUT TYPE="button" VALUE="Back" onClick="history.go(-1);"></td> -->
				<!-- <td style="width:10%"> </td> -->

			</tr>
		</table>

	</form>

</body>
</html>