<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="main.css"> -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body class="background-panel">
	<div class="image-as-bg">
		<h1 align="center" class="bg-primary">Hotel Booking System</h1>
		<h2 align="center" >Welcome To Hotel Mayura</h2>

		<!-- <table class ="table">
			<tr>
				<form action="userRegistration.jsp" method="POST">
					<td><form:label path="goToRegister">If you are a new user, please click to Register</form:label></td>
					<td>&nbsp</td>
					<td colspan="10" align="center"><input type="submit"
						value="Go to Register" size="10" /></td>
				</form>
			</tr>
	
			<tr>
				<td>&nbsp</td>
			</tr>
	
			<tr>
				<form action="userLogin.jsp" method="POST">
					<td><form:label path="goToLogin">If you are a registered user, please click to Login</form:label></td>
					<td>&nbsp</td>
					<td colspan="10" align="center"><input type="submit"
						value="Go to Login &nbsp &nbsp " size="2" /></td>
				</form>
			</tr>
	
		</table> -->


		<form action="userRegistration.jsp" method="POST">
			<div class="form-group">
				<label path="goToRegister">If you are a new user, please
					click to Register</label> &nbsp &nbsp  &nbsp &nbsp<input type="submit" value="Go to Register"
					size="10"/>
			</div>
		</form>


		<form action="userLogin.jsp" method="POST">
			<div class="form-group">
				<label path="goToLogin">If you are a registered user, please
					click to Login</label>  &nbsp <input type="submit"
					value="Go to Login &nbsp &nbsp " size="2" />
			</div>
		</form>


	</div>

</body>
</html>