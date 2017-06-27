<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/RestFullApplication/ui/loginStyle.css">
</head>
<body>
	<div class="page-header">
		<h2>
			Synchrony Financial<small>&nbsp;&nbsp;&nbsp;&nbsp;Browse
				Games for Diffrent Platforms</small>
		</h2>
	</div>
	<div class="container">
		<c:if test="${requestScope.Error_Message!=null}">
			<div class="alert alert-warning">
				<strong>${requestScope.Error_Message}</strong>
			</div>
		</c:if>
		<form class="form-signin"
			action="/RestFullApplication/AuthenticationServlet" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="UserName" class="sr-only">User-Name</label> <input
				type="text" name="username" id="username" class="form-control"
				placeholder="UserName" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" name="password" id="password" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
</body>
</html>
