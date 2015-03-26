<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="shortcut icon" type="image/jpg"
	href="resources/images/favicon.jpg" />
<style>
a {
	color: #000;
	display: inline-block;
	text-decoration: none;
	display: block;
}

a:hover {
	color: #FFF;
}
/* Cells a in even rows (2,4,6...) are one color */
tr:nth-child(even) a {
	background: #F1F1F1;
}

tr:nth-child(odd) a {
	background: #FEFEFE;
}

tr:nth-child(even) a:hover {
	background: #000;
}

tr:nth-child(odd) a:hover {
	background: #000;
}

/* Cells in odd rows (1,3,5...) are another (excludes header cells)  */
tr:nth-child(odd) a {
	background: #FEFEFE;
}

table {
	color: #333;
	font-family: Helvetica, Arial, sans-serif;
	width: 640px;
	border-collapse: collapse;
	border-spacing: 0;
}

td, th {
	border: 1px solid transparent; /* No more visible border */
	height: 30px;
	transition: all 0.3s; /* Simple transition for hover effect */
}

th {
	background: #DFDFDF; /* Darken header a bit */
	font-weight: bold;
	text-align: left;
}

td {
	background: #FAFAFA;
	text-align: left;
}

/* Cells in even rows (2,4,6...) are one color */
tr:nth-child(even) td {
	background: #F1F1F1;
}

/* Cells in odd rows (1,3,5...) are another (excludes header cells)  */
tr:nth-child(odd) td {
	background: #FEFEFE;
}

tr:hover td {
	background: #666;
	color: #FFF;
} /* Hover cell effect! */
tr:hover a {
	background: #666;
	color: #FFF;
} /* Hover cell effect! */
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>
	<p>
	<table align="center">
		<tr>

			<th width="70%">Topic</th>
			<th>Questions</th>
		</tr>
		<c:forEach var="topic" items="${topics}">
			<tr>
				<td><a href="Question?topic=${topic.id}">${topic.content}</a></td>
				<td>${topic.questionsAmount}</td>
			</tr>
		</c:forEach>

	</table>
	<p>
	<p>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>