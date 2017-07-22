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
<link rel="stylesheet"
	href="/RestFullApplication/ui/styles/loginStyle.css">
<script src="/RestFullApplication/ui/scripts/filter.js"></script>

</head>
<body>
	<div class="page-header">
		<h3>
			Synchrony Financial<small>&nbsp;&nbsp;&nbsp;&nbsp;Browse
				Games for Diffrent Platforms</small>
		</h3>
		<h5>
			<c:if test="${requestScope.Welcome_Message!=null}">
				<div class="welcomeMessage alert-success">
					<strong>${requestScope.Welcome_Message}</strong>
				</div>
			</c:if>
		</h5>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<input type="text" name="search" id="search"  placeholder="Search">
			</div>
			<c:if test="${requestScope.Error_Message!=null}">
			<div class="col-md-2 col-md-offset-1">
					<div class="alert alert-warning">
						<strong>${requestScope.Error_Message}</strong>
					</div>
			</div>
			</c:if>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<h1 class="display-4">List of Games:</h1>
			</div>
			<div class="col-md-10 col-md-offset-1">
				<table class="table table-striped results">
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
					<tbody id="tbody">
						<c:forEach items="${requestScope.APP_DATA}" var="element"
							varStatus="loop">
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
		</div>
		<div class="row">
			<form action="AuthenticationServlet" method="post">
				<input type="hidden" name="next" value="${requestScope.PAGE_NUM+1}">
				<input type="hidden" name="previous"
					value="${requestScope.PAGE_NUM-1}">
				<table class="table">
					<tr>
						<th style="padding-left: 90px"><input type="submit"
							class="btn btn-info" name="page" value="previous"></th>
							<th style="padding-top: 10px;"><label class="label label-default">Page Number<span
							class="badge"><c:out value="${requestScope.PAGE_NUM}">PageNumber</c:out></span></label></th>
						<th ><input type="submit"
							class="btn btn-info" name="page" value="next"></th>
						
					</tr>
				</table>
			</form>

		</div>

	</div>

</body>
</html>
