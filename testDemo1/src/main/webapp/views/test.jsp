<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LDAP Registration Form</title>
</head>
<body>
	<h1>LDAP Register Form</h1>
	<form action="../employee/register" method="post">
		<table style="with: 50%">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name" required /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name" required /></td>
			</tr>
			<tr>
				<td>Emp No</td>
				<td><input type="text" name="empNo" required /></td>
			</tr>
			
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>