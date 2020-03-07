<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<title>Login</title>
</head>
<body>

	<jsp:include page="header.jsp"/>


	<br><br>
	
	<div class="container">
	
		<div class="card" style="width: 25rem;">
			<div class="card-body">
				<div>
					<h2>${msg}</h2>
				</div>
		    <form action="${action}" method="post">
			  <div class="form-group">
			    <label for="exampleUsername">Username</label>
			    <input type="text" name="username" class="form-control" id="username" aria-describedby="emailHelp"/>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Password</label>
			    <input type="password" name="password" class="form-control" id="password"/>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
			</div>
		</div>
	</div>
	 
	
	
	

</body>
</html>