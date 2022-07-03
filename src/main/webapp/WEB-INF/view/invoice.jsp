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
<body>
	<div class="text-center">
		<h1>Welcome</h1>
		<br> <small class="text-muted">Manage Reservations</small>
	</div>
	<jsp:include page="navRes.jsp"></jsp:include>
	<div class="section">
		<div class="top-section">
			<!-- table 1-->
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td scope="col">Guest Name : ${invoice.guestName}</td>
						<td scope="col">Guest ID : ${invoice.guestId}</td>
						<td scope="col">Bill Date : ${invoice.billDate}</td>
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
						<td scope="col">Room perday charges</td>
						<td scope="col">${invoice.perDayCharges}</th>
					</tr>	
					<tr>
						<td scope="col">GST %</td>
						<td scope="col">${invoice.gst}</th>
					</tr>	
					<tr>
						<td scope="col">Total charges inclusive of all tasxes</td>
						<td scope="col">${invoice.totalAmount}</th>
					</tr>		
					<tr>
						
						<td></td>
					<!-- </tr>
						<th scope="col">Check In</th>
						<th scope="col">Check Out</th>
						<th scope="col">Guest Id</th>
					</tr> -->
				

					<%-- <tr>
						<td>${invoice.reservationId}</td>
						<td>${invoice.roomNumber}</td>
						<td>${invoice.checkInDate}</td>
						<td>${invoice.checkOutDate}</td>
						<td>${invoice.guest.guestId}</td>
					</tr> --%>

				</tbody>
			</table>
			<!-- end of table -->
			<a class="btn btn-light btn-sm" href="/welcome">Back</a>
		</div>
	</div>
</body>
</html>