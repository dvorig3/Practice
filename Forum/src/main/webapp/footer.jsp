<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	font: .875em/1.618 Helvetica, Sans-serif;
}

#navigation {
	background-color: #626262;
}

#navigation ul {
	margin: 0;
	padding: 0;
}

#navigation li {
	border-right: 1px solid #626262;
	display: block;
	float: left;
	margin: 0;
}

#navigation li:last-child {
	border-right-width: 0;
}

#navigation a {
	background-color: #626262;
	color: #ffffff;
	display: block;
	padding: .75em 1.5em;
	text-decoration: none;
	transition: all .25s ease-in-out;
	-moz-transition: all .25s ease-in-out;
	-webkit-transition: all .25s ease-in-out;
}

#navigation a:hover {
	background-color: #000000;
}

.clearfix {
	*zoom: 2;
}

.clearfix:after, .clearfix:before {
	content: '';
	display: table;
}

.clearfix:after {
	clear: both;
}
</style>
</head>
<body>
	<nav id="navigation" class="clearfix">
	<ul>
		<li><a href="#">Home</a></li>
		<li><a href="#">About</a></li>
		<li><a href="#">Registration</a></li>
		<li><a href="#">Log in</a></li>
		<li><a href="#">Log out</a></li>
	</ul>
	</nav>
	<p>
	<p>
	<center>
		<img alt="forum.ua" src="resources/images/footerforum.jpg" />
		<p><p>&copy; 2015, Forum.ua
	</center>
</body>
</html>