<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Management</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body style="background-color: #e2e4c0;">
	<div class="text-center">
		<h1 style="color: red;"font-family:georgia,garamond,serif;font-size:16px;font-style:italic;">NIRVANA
			Inn</h1>
		<hr size="8" width="100%" color="red">
		<h1>
			<small class="text-muted">
				Welcome to Management Page<br>
				Select management
			</small>
		</h1>
	</div>
	<div class="text-right">
		<a href="/">Logout</a>
	</div>
	<jsp:include page="nav.jsp"></jsp:include>
	<div style="margin-top: 10%;">
		<a class="btn btn-info btn-lg btn-block" href="/guests">Guests
			Info</a> <a class="btn btn-info btn-lg btn-block" href="/reservations">Reservations
			Info</a>
	</div>
</body>
</html>