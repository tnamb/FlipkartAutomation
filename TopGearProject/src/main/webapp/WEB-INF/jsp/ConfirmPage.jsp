<!DOCTYPE html>
<html>
<title></title>
<head>
<%@page import="java.sql.*"%>
<style>
.class1 {
	margin: auto;
	width: 50%;
}
</style>
</head>

<body class="class1">

	<%
		String car = request.getParameter("car");
	%>

	<div>
		<h2>BESTChoice Cars</h2>
		<h3>
			Congratulations! Your car
			<%=car%>
			is successfully booked
		</h3>
		<h3>Thank you and have a good day!</h3>
	</div>
</body>
</html>