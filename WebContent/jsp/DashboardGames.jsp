<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h6>
			<c:if test="${requestScope.Welcome_Message!=null}">
				<div class="welcomeMessage alert-success">
					<strong>${requestScope.Welcome_Message}</strong>
				</div>
			</c:if>
		</h6>
	</div>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Serial</th>
					<th>Title</th>
					<th>Platform</th>
					<th>Score</th>
					<th>Genre</th>
					<th>Editor's Choice</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.APP_DATA}" var="element" varStatus="loop">
					<tr>
						<td>${loop.index+1}</td>
						<td>${element.title}</td>
						<td>${element.platform}</td>
						<td>${element.score}</td>
						<td>${element.genre}</td>
						<td>${element.editorsChoice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
