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
<link rel="stylesheet"
	href="/RestFullApplication/ui/styles/loginStyle.css">
</head>
<body>
	<div class="page-header">
		<h2>
			Synchrony Financial<small>&nbsp;&nbsp;&nbsp;&nbsp;Browse
				Games for Diffrent Platforms</small>
		</h2>
	</div>
	<div class="container">
		<c:if test="${requestScope.APP_MESSAGE!=null}">
			<div class="alert alert-success">
				<strong>${requestScope.APP_MESSAGE}</strong>
			</div>
		</c:if>
		<c:if test="${requestScope.Error_Message!=null}">
			<div class="alert alert-warning">
				<strong>${requestScope.Error_Message}</strong>
			</div>
		</c:if>
		<div id="signInBox" style="margin-top: 2px">
			<form class="form-signin" action="AuthenticationServlet" method="post">
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
			<div class="form-group">
				<div class="col-md-12 control">
					<div
						style="padding-top: 15px; font-size: 85%">
						Don't have an account! <a href="#"
							onClick="$('#signInBox').hide(); $('#signupbox').show()"> Sign
							Up Here </a>
					</div>
				</div>
			</div>
		</form>
		</div>
		

		<div id="signupbox" style="display: none; margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">

					<div class="panel-title">Sign Up</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="#"
							onclick="$('#signupbox').hide(); $('#signInBox').show()">Sign
							In</a>
					</div>
				</div>
				<div class="panel-body">
					<form id="signupform" class="form-horizontal"
						action="UserRegistrationServlet" method="post">
						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email/UserId</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="email"
									placeholder="Email Address">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="firstname"
									placeholder="First Name">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="lastname"
									placeholder="Last Name">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="passwd"
									placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-info">
									<i class="icon-hand-right"></i>&nbsp; Sign Up
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
