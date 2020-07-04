<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  }* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
  
  
	
</style>

<script type="text/javascript">
	function validate()
	{
		var x = document.getElementById("DIV");
		var y = document.getElementById("DIV1");
		
		if(x.style.display === "none" && y.style.display === "block")
		{
			y.style.display = "none";
			x.style.display = "block";
		}
		else if(x.style.display === "block" && y.style.display === "none")
		{
			x.style.display = "none";
			y.style.display = "block";
		}
		else
		{
			x.style.display = "block";
		}
	}
	
	function validate1()
	{
		var x = document.getElementById("DIV");
		var y = document.getElementById("DIV1");
		
		if(x.style.display === "none" && y.style.display === "block")
		{
			y.style.display = "none";
			x.style.display = "block";
		}
		else if(x.style.display === "block" && y.style.display === "none")
		{
			x.style.display = "none";
			y.style.display = "block";
		}
		else
		{
			y.style.display = "block";
		}
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
	    <a href ="/option">Ideas</a>
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
		<h1>Welcome! ${user.firstName} ${user.lastName } </h1><br>
		<div class="row">
  <div class="column" style="background-color:#aaa;">
    <h2>Column 1</h2>
    <p>Some text..</p>
  </div>
  <div class="column" style="background-color:#bbb;">
    <h2>Column 2</h2>
    <p>Some text..</p>
  </div>
  <div class="column" style="background-color:#ccc;">
    <h2>Column 3</h2>
    <p>Some text..</p>
  </div>
</div>		
		<button onclick="validate()">Events</button>
		<button onclick="validate1()">clubs</button>
		
		<div id="DIV" style="display: none">Division 1</div>
		<div id="DIV1" style="display: none">Division 2</div>
	</div>
</body>
</html>