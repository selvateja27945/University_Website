<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
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
<title>Admin Clubs</title>
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
		<h2>Welcome to Club Edit page</h2>
		<form:form action="/updatClubDetail" method="post" 	modelAttribute="clubdetails">
			<form:label path="clubId">Club Id</form:label>
			<input type="text" name="id" value="${club.clubId }" disabled="disabled">
			<form:hidden path="clubId" value="${club.clubId }" />
			<br>
			<br>
			
			<form:label path="clubName">Club name</form:label>
			<form:input path="clubName" value="${club.clubName }" />
			<br>
			<br>
			<form:label path="clubStrength">Club Strength</form:label>
			<form:input path="ClubStrength" value="${club.clubStrength }" />
			<br>
			<br>
			<form:label path="eligibility">eligibility</form:label>
			<form:input path="eligibility" value="${club.eligibility }" />
			<br><br>
			<input type="submit" value="Update">
		</form:form>


		<a href="/Adminclubs">Click for Clubs</a>
	</div>
</body>
</html>