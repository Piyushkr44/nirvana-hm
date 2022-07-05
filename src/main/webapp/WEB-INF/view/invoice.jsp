<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Reservations</title>
<jsp:include page="bootstrap.jsp"></jsp:include>

<style>
.section {
	background-color: #F0F8FF;
	display: flex;
}

.bottom-section {
	flex: 1;
	padding: 12px;
}

.top-section {
	flex: 1;
	padding: 12px
}
</style>
</head>
<body style="background-color:#e2e4c0;">
	<div class="text-center">
		<h1 style="color:red;"font-family:georgia,garamond,serif;font-size:16px;font-style:italic;">NIRVANA Inn</h1>
		<hr size="8" width="100%" color="red"> 
		<br> <small class="text-muted">Invoice Details</small>
	</div>
	<div class="text-right">
		<a href="/">Logout</a>
	</div>
	<jsp:include page="navRes.jsp"></jsp:include>
	<div class="section">
		<div class="top-section">
			<!-- table 1-->
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td style="font-weight:bold" scope="col">Guest Name : ${invoice.guestName}</td>
						<td style="font-weight:bold" scope="col">Guest ID : ${invoice.guestId}</td>
						<td style="font-weight:bold" scope="col">Bill Date : ${invoice.billDate}</td>
					</tr>
				</tbody>
			</table>
			<!-- table 2-->
			<table class="table table-bordered">
				<tbody>
					<tr>	
						<td scope="col">Reservation Id : ${invoice.reservationId}</td>
						<td scope="col">Room Number : ${invoice.roomNumber}</th>
					</tr>
					<tr>
						<td scope="col">Check In Date : ${invoice.checkInDate}</td>
						<td scope="col">Check Out Date : ${invoice.checkOutDate}</th>
					</tr>	
					<tr>
						<td scope="col">Room per day charges</td>
						<td scope="col">${invoice.perDayCharges}</th>
					</tr>	
					<tr>
						<td scope="col">GST 18%</td>
						<td scope="col">${invoice.gst}</th>
					</tr>	
					<tr>
						<td scope="col">No. of days</td>
						<td scope="col">${invoice.totalDay}</th>
					</tr>	
					<tr>
						<td style="font-weight:bold" scope="col">Total charges inclusive of all taxes</td>
						<td style="font-weight:bold" scope="col">${invoice.totalAmount}</th>
					</tr>		
					<tr>											
				</tbody>
			</table>
			<a class="btn btn-light btn-sm" href="/welcome">Back</a>
		</div>
	</div>
</body>
</html>