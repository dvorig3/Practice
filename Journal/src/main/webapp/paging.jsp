<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Journal</title>
<style>
table, td, th {
	border: 1px solid blue;
}

table {
	width: 60%;
}

th {
	background-color: blue;
	color: white;
}

h1 {
	text-align: center;
	text-transform: uppercase;
	color: #A7C942;
}

p {
	text-indent: 50px;
	text-align: justify;
	letter-spacing: 3px;
}
</style>
</head>
<body>


	<jsp:include page="/header.jsp"></jsp:include>
	<p />
	<table>
		<th>1</th>
		<th>2</th>
		<th>3</th>
		<th>4</th>
		<c:forEach var="record" items="${records}">
			<tr>
			<td bgcolor = "${record.importance.color}" width="1%">	${record.stringDate}</td>
			<!--  	<td>${record.importance.signing}</td> -->
				<td>${record.source}</td>
				<td>${record.message}</td>
				<td><form><input type="submit" value = "details"/></form></td>
			</tr>
		</c:forEach>
	</table>

	<table>
		<th width="20%">FIRST</th>
		<th width="20%">PREVIOUS</th>
		<th width="20%">CURRENT</th>
		<th width="20%">NEXT</th>
		<th width="20%">LAST</th>

		<tr>

			<td><a href="Paginator?pageN=1">1</a></td>
			<td><a href="Paginator?pageN=${previous}">${previous}</a></td>
			<td>${current}</td>
			<td><a href="Paginator?pageN=${next}">${next}</a></td>
			<td><a href="Paginator?pageN=${pageA}">${pageA}</a></td>
		</tr>
	</table>



</body>
</html>