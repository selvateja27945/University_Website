<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
}

h1 {
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
<title>Admin events</title>
</head>
<body>
<div class="header">
	  <a href="/dashboard" class="logo">ANITS (${userSession.category })</a>
	  <div class="header-right">
	    <a href="/dashboard">Home</a>
	    <div class="dropdown">
    		<button class="dropbtn">Events 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
      			<a href="/gevents">Add Events</a>
      			<a href="/listevents">List Events</a>
    		</div>
  		</div> 
  		 <div class="dropdown">
    		<button class="dropbtn">Clubs 
      			<i class="fa fa-caret-down"></i>
    		</button>
    		<div class="dropdown-content">
      			<a href="/addClub">Add Club</a>
      			<a href="/Adminclubs">List Club</a>
    		</div>
  		</div> 
	    <a href="/logout">Logout</a>
	  </div>
	</div>
		
	<div align="center">
		<h2>Ready to host an Event? </h2>
		<form:form action="/insertEventsAd" method="post" modelAttribute="eventdetails">
		<table>
			<tr>
				<td><form:label path="eventName">Event Name: </form:label></td>            
	  			<td><form:input  path="eventName" required="true"/></td>
	  		</tr>
	  		<tr>
				<td><form:label path="eventPlace">Event Venue: </form:label></td>
				<td><form:input  path="eventPlace" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="startDate">Event Start Date: </form:label></td>
				<td><form:input type="datetime-local" path="startDate" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="endDate">Event End Date: </form:label></td>
				<td><form:input type="datetime-local" path="endDate" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description">About Event: </form:label></td>
				<td><form:textarea path="description" required="true"/></td>
			</tr>
			<tr>
				<td><form:label path="category">Category: </form:label></td>            
	  			<td><form:select  path="category" required="true">
 	  					<form:options items= "${cl}" />
	  				</form:select>
	  			</td>
	  		</tr>
		</table>
			<input type="submit" value="submit" /><br>
		</form:form>
		</div>
</body>
</html>