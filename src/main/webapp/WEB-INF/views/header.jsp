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
<link rel="stylesheet" href="styles.css" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title></title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/">MyBracket</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          
          <li class="nav-item">
            <a class="nav-link" href="guest-tournament">Host a Tournament</a>
          </li>
          
          <c:choose>
          	<c:when test="${empty loggedInUser}">
          		<li class="nav-item">
          			<a class="nav-link" href="login">Login
           			</a>
         		</li>
         		<li class="nav-item">
          			<a class="nav-link" href="signup">Sign Up
           			</a>
         		</li>
          	</c:when>
          	<c:otherwise>
          		<li class="nav-item">
          			<a class="nav-link" href="profile">${loggedInUser.username}
           			</a>
         		</li>
         		<li class="nav-item">
          			<a class="nav-link" href="logout">Logout
           			</a>
         		</li>
          	</c:otherwise>
          </c:choose>
          
          

          <li class="nav-item">
            <a class="nav-link" href="about">About</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

</body>
</html>