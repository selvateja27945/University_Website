<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	
	body, h1 {
		background-image: url("${pageContext.request.contextPath}/resources/images/Clipart-Email-6525225.png");
		background-position: right bottom, left top;
  		background-repeat: no-repeat;
		font-family: cursive;
	}

</style>  
<!-- <script type="text/javascript">
function formValid(){  
	
	var password=document.form.password.value;  
	var cpassword=document.myform.cpassword.value;  
	
	if(!password.equals(cpassword))
	{
		cpassword.focus();
		document.getElementById("confirmPasswordError").innerHTML = " \t*password didn't match";
		return false;
	}
}
	
	
</script>  -->

<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<div align="center">
		<h1>User Registration Form</h1>
		<form:form id="form" action="/insertUserDetails" method="post" modelAttribute="userdetails" onsubmit="return formValid()" >
		<h5>*Login using enrol number after registration</h5>
		<table>
			<tr>
				<td><form:label path="enrolnumber">Enrol Number: </form:label></td>
				<td><form:input id="enrolnumber" path="enrolnumber" placeholder="Roll number" pattern="^[0-9]+$" required="true" />
				<td><font id="idError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:label path="firstName">First Name: </form:label></td>
				<td><form:input id="firstName" path="firstName" placeholder="Enter first name" pattern="^[A-Za-z]+$" required="true" />
				<td><font id="firstError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name: </form:label></td>
				<td><form:input id="lastName" path="lastName" placeholder="Enter last name" pattern="^[A-Za-z]+$" required="true" />
				<td><font id="lastError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:label path="dob">Date of Birth: </form:label></td>
				<td><form:input id="dob" type="date" path="dob" required="true"/></td>
				<td><font id="dateError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:password id="password" path="password" placeholder="Enter password" required="true" /></td>
				<td><font id="passwordError" style="color: red;"></font></td>
			</tr>
			<!--  <tr>
				<td><form:label path="cpassword">Confirm Password: </form:label></td>
				<td><form:password id="cpassword" path="cpassword" placeholder="confirm password" required="true" /></td>
				<td><font id="confirmPasswordError" style="color: red;"></font> 
			</tr> -->
			<tr>
				<td><form:label path="gender">Gender: </form:label></td>
				<td>Male <form:radiobutton path="gender" value="Male" required="true" />
				Female <form:radiobutton path="gender" value="Female" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile: </form:label></td>
				<td><form:input id="mobile" path="mobile" placeholder="provide a valid mobile number" pattern="[7-9]{1}[0-9]{9}" required="true" /></td>
				<td><font id="mobileError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:label path="email">Email Id: </form:label></td>
				<td><form:input id="email" path="email" placeholder="Enter valid email Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="true" /></td>
				<td><font id="emailError" style="color: red;"></font> 
			</tr>
			<tr>
				<td><form:hidden path="category"></form:hidden></td>
				<td><form:hidden path="category" value="user" readonly="true" /></td>
			</tr>
		</table>
		<input type="submit" value="Sign Up" /><br>
		</form:form>
		</div>
</body>
</html>