<%@page import="com.idvorskij.forum.controlers.Login"%>
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
.fs-topic {
	font-family: serif;
	font-weight: bold;
	text-transform: uppercase;
	color: #2E9AFE;
}

.publ_user {
	font-family: serif;
	font-weight: bold;
	font-size: 15px;
	text-transform: uppercase;
	color: #2E9AFE;
	font-size: 15px;
}

/* ----------------------------------- */
.form_add_quest {
	float: left;
	height: 60%;
	width: 100%;
	padding: 40px;
}

.textbox_add_quest {
	height: 75px;
	width: 83%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 2px solid;
	box-sizing: border-box;
	margin-bottom: 20px;
}

.textbox_add_quest:focus {
	outline: none;
	border: rgba(24, 149, 215, 1) 2px solid;
	color: rgba(24, 149, 215, 1);
}

.button_add_quest {
	height: 30px;
	width: 83%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	background: #2E9AFE;
	color: #FFF;
	font-weight: bold;
	font-size: 10pt;
	transition: background .4s;
	cursor: pointer;
}

.fs-title_add_quest {
	font-weight: bold;
	text-transform: uppercase;
	color: #2E9AFE;
	text-transform: uppercase;
}

.button_add_quest:hover {
	background: #2E64FE;
}

#bg_add_quest {
	position: relative;
	top: 10px;
	height: 400px;
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
}

.module_add_quest {
	position: relative;
	height: 60%;
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	border-radius: 5px;
	background: RGBA(255, 255, 255, 1);
	-webkit-box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>
	<p>
	<center>
		<h1>
			Questions to topic <span class="fs-title_add_quest">
				${topicdata} </span>
		</h1>
	</center>
	<table align="center" width="80%">
		<tr>
			<th width="50%">Questions</th>
			<th>Publish date</th>
			<th>Published by</th>
			<th>Answers</th>
		</tr>
		<c:forEach var="quest" items="${questions}">
			<tr>
				<td><a href="Answer?question=${quest.id}">${quest.content}</a></td>
				<td>${quest.stringDate}</td>
				<td><span class="publ_user"> ${quest.user.nickname}</span></td>
				<td>${quest.answerNumber}</td>
			</tr>
		</c:forEach>

	</table>
	<p>
	<p>
		<%
		session = request.getSession();
			if (Login.isLoggedAnyone(session)) {
		%>
	
	<div id="bg_add_quest">
		<div class="module_add_quest">
			<form action="Question" method="POST" class="form_add_quest">

				<h4>
					<span class="fs-title">Publish your question to topic</span><span
						class="fs-title_add_quest"> ${topicdata} </span>
				</h4>

				<textarea name="question" class="textbox_add_quest"></textarea>
				<input type="submit" name="question" class="button_add_quest"
					value="Publicate">
			</form>
		</div>
	</div> 
	<%
		}
	%>
	<p>
	<p>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>