<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

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
	<!--<form:form action="/ideas" onclick="validate()" modelAttribute="ideaList"> -->
	<button onclick="validate()">Submit An idea</button>
	<!--</form:form> -->
	<button onclick="validate1()">List Ideas</button>
		
		<div id="DIV1" align="center" class="club" style="display: none">
		<br>
		<c:if test="${ideas.size()==0 }"><h1>No Ideas Available</h1></c:if>
		<c:if test="${ideas.size() > 0 }">
			<h1>List of Ideas</h1>
			<br>
			<table class="idea">
				<tr>
					<th>Idea Id</th>
					<th>Category</th>
					<th>Description</th>
					<th>Likes</th>
					<th>Dislikes</th>
					<th>User Id</th>
				</tr>
				<c:forEach items="${ideas }" var="list">
				<tr>
					<td>${list.ideaId }</td>
					<td>${list.category }</td>
					<td>${list.description }</td>
					<td>${list.voteup }</td>
					<td>${list.votedown }</td>
					<td>${list.enrolnumber }</td>
					<td><a href="/Updateidea1/${list.ideaId }">like</a></td>
					<td><a href="/Updateidea2/${list.ideaId }">Dislike</a></td>
					<td>
						<form action="/comments/${list.ideaId}" method="post">
							<label for="comments">Add Comments: </label>
							<input type="text" name="comments" id="comments" >
							<input type="submit" value="submit">
						</form>
					</td>
					
				</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
		
		
	<div id="DIV" style="display: none" align="center">
		<h1>What's in your Mind?</h1>
		<form:form action="/insertidea" method="post" modelAttribute="ideaList" >
			<table>
			<tr>
				<td><form:label path="category">Category: </form:label></td>            
	  			<td><form:select  path="category">
 	  					<form:options items= "${cl}" />
	  				</form:select>
	  			</td>
	  		</tr>
	  		<tr>
				<td><form:label path="description">Describe about the idea: </form:label></td>
				<td><form:textarea  path="description" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="enrolnumber">User Id: </form:label></td>            
		  		<td><form:input  path="enrolnumber" value="${userSession.enrolnumber }" readonly="true" /></td>
	  		</tr>
	  		</table>
	  		
			<br><input type="submit" value="submit" /><br>
		</form:form>
		<br><br>
		
		<div align="center" class="club">
		<c:if test="${idea == true }"><h3>*Successfully Added</h3></c:if>
		<c:if test="${idea == false }"><h3>*failed to Add Idea</h3></c:if>
		</div>
	</div>
	
	
</body>
</html>