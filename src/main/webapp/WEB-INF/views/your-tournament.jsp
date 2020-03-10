<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="styles.css" type="text/css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Generated Tournament</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<br><br>
	
	<div class="container">
		<div class="card display-players">
			<div class="card-body">
			
			<h2>Players: </h2>
			<c:forEach var="players" items="${bracket.totalTempPlayers}" varStatus="loop">
			
			<td>${players} <br> </td>
			
			</c:forEach>
			
			<br>
			
			<h3>Total Active players: ${bracket.activeTempPlayers.size()}</h3>
			<h3>Total Rounds: ${bracket.totalRounds}</h3>
		
			</div>
		</div>
	</div>
	
	<br><br>
	
	
	
		

	<form action="updateGuestTournament">
	<div class="container">
	 
  
  	<c:forEach var="match" items="${bracket.tempMatches}">
			   
			    <div class="row">
				  <div class="card">
					  <div class="card-body col-sm">
					    <div>
					    	 ${match.player1} <input type="checkbox" id="${match.player1}" name="winner" value="${match.player1}">
					    	 <br><br>
					    	 ${match.player2}<input type="checkbox" id="${match.player2}" name="winner" value="${match.player2}">
					    	
					    </div>
					  </div>
				  </div>
				 </div>
			  <br>
			  
			  
 	  </c:forEach>
 	  
 	  
 	  
 	 </div>

	<div class="container">
		<button type="submit">Generate Next round</button>
	</div>
	
	</form>


</body>
</html>