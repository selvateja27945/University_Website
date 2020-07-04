<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: cursive;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #ddd;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
	
</style>

<script type="text/javascript">
function validate(){
	
	var date = document.forms["form"]["date"].value;
	var date1 = document.forms["form"]["date1"].value;
	
	if(date2<date1)
	alert("Password didn't match");
	return false;
}
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
	  <a href="/userhome1" class="logo">ANITS</a>
	  <div class="header-right">
	    <a href="/userhome1">Home</a>
	    <div class="dropdown">
    		<button class="dropbtn">Ideas 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
    			<a href="/ideas">Submit An Idea</a>
      			<a href="/viewideas">View Ideas</a>
    		</div>
  		</div> 
	    <div class="dropdown">
    		<button class="dropbtn">Clubs 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
      			<a href="/clubs">Join The Club</a>
      			<a href="/members">Members of the club</a>
      			<a href="/clubevents">Events of the Club</a>
    		</div>
  		</div> 
	    <div class="dropdown">
    		<button class="dropbtn">Events 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
      			<a href="/getevents">Add Events</a>
      			<a href="/allevents">List Events</a>
      			<a href="/searchevent">Search an Event</a>
    		</div>
  		</div> 
  		<div class="dropdown">
    		<button class="dropbtn">Services 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
      			<a href="/services">Add Services</a>
      			<a href="/volunteers">List of Volunteers</a>
    		</div>
  		</div> 
	    <a href="/logout">Logout</a>
	  </div>
	</div>
		
	<div align="center">
		<h2>Ready to host an Event? </h2>
		<form:form name="form" action="/insertEvents" method="post" modelAttribute="eventdetails" onsubmit="return validate()">
		<table>
			<tr>
				<td><form:label path="eventName">Event Name: </form:label></td>            
	  			<td><form:input  path="eventName" required="true" /></td>
	  		</tr>
	  		<tr>
				<td><form:label path="eventPlace">Event Venue: </form:label></td>
				<td><form:input  path="eventPlace" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="startDate">Event Start Date: </form:label></td>
				<td><form:input type="datetime-local" id="date" path="startDate" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="endDate">Event End Date: </form:label></td>
				<td><form:input type="datetime-local" id="date1" path="endDate" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description">About Event: </form:label></td>
				<td><form:textarea path="description" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="category">Category: </form:label></td>            
	  			<td><form:select  path="category">
 	  					<form:options items= "${cl}" />
	  				</form:select>
	  			</td>
	  		</tr>
			<tr>
				<td><form:label path="enrolnumber">enrol ID: </form:label></td>            
	  			<td><form:input  path="enrolnumber" value="${userSession.enrolnumber }" readonly="true" /></td>
	  		</tr>
		</table>
			<input type="submit" value="submit" /><br>
		</form:form>
		</div>
</body>
</html>