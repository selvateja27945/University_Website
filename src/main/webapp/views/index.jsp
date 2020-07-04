<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html>
<html>
<head>
<style>
	body, h1 {
		font-family: cursive;
	}
	
	span {
		color: red;
	}
</style>
<meta charset="ISO-8859-1">
<title>User Login</title> 


<!-- Java Script -->
<script type="text/javascript">
	function validate(){
		
	//	alert("Inside Validation")
		var user_id = document.forms["userLoginForm"]["enrolnumber"];
		var pass = document.forms["userLoginForm"]["password"];
		
		
		//var n = user_id.value.toString();
		
		//System.out.println(n);
		//var length = n.length;
		/*var u = user_id.value;
		var p = pass.value;*/
		
		if(user_id.value == "" || user_id.length < 6)
		{
			user_id.focus();
			document.getElementById("msg").innerHTML = " \t*Please provide valid userIid";
			return false;
		}
		if(pass.value == "")
		{
			pass.focus();
			document.getElementById("msg1").innerHTML = " \t*Invalid password";
			return false;
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h1>Welcome to Login Page</h1>
		<form:form name="userLoginForm" action="/alllogins" method="post" modelAttribute="logins" onsubmit="return validate()">
			<table>
			<tr>
			<td><form:label path="enrolnumber">User_id:</form:label> </td>
			<td><form:input path="enrolnumber" placeholder="Enter Enrol number" id="enrolnumber" /></td>
			<td> <span id="msg"></span> </td>
			</tr> 
			<tr>
			<td><form:label path="password">Password: </form:label></td>
				<td><form:password id="password" path="password" placeholder="Enter password" /></td>
			<td> <span id="msg1"></span> </td>
			</tr>
			</table>
			<br> <input type="submit" value="Login"> <br>
		</form:form>
		<br>
		Didn't have an account?<a href="/registration"> click here!</a>
	</div>
</body>
</html>