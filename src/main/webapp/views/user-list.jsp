<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	
	table,th,td {
  		padding: 5px;
  		text-align: center;
  		border: 1px solid black;
  		font-family: cursive;
	}
	
	body {
	  font-family: Arial, Helvetica, sans-serif;
	}
	
	h1 {
		font-family: cursive;
	}
	
	a, button {
		text-decoration: none;
		font-family: cursive;
	}
	.logout {
		float: right;	
	}
	
	tr:nth-child(even) {background-color: #f2f2f2;}
</style> 
<meta charset="ISO-8859-1">
<title>USERS LIST</title>
</head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>

table,th,td {
  		padding: 5px;
  		text-align: center;
  		border: 1px solid black;
  		font-family: cursive;
	}
	
	tr:nth-child(even) {background-color: #f2f2f2;}

body {
  font-family: Arial, Helvetica, sans-serif;
}

h1 {
	font-family: cursive;
}
.navbar {
  overflow: hidden;
  font-family: cursive;
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
	<c:if test="${userlist.size()==0 }"><h1>No Users Available</h1></c:if>
	<c:if test="${userlist.size() > 0 }">
	<br><br>
	<h1>List of Users</h1>
	<table>
		<tr>
			<th>User_id</th>
			<th>First Name</th>
			<th>Last name</th>
			<th>gender</th>
			<th>Mobile.no</th>
			<th>Email Id</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${userlist }" var="list">
		<tr>
			<td>${list.enrolnumber }</td>
			<td>${list.firstName }</td>
			<td>${list.lastName }</td>
			<td>${list.gender }</td>
			<td>${list.mobile }</td>
			<td>${list.email }</td>
			<td><a href="/deleteUser/${list.enrolnumber }">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
</div>
</body>
</html>