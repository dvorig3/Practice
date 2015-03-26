<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/jpg"
	href="resources/images/favicon.jpg" />
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

.textboxlogin {
	height: 18px;
	width: 15%;
	border-radius: 0px;
	border: rgba(0, 0, 0, .3) 2px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 10px;
}

.textboxlogin:focus {
	outline: none;
	border: rgba(24, 149, 215, 1) 2px solid;
	color: rgba(24, 149, 215, 1);
}

.user-title {
	font-family: serif;
	font-weight: bold; font-size : 15px;
	text-transform: uppercase;
	color: #2E9AFE;
	font-size: 15px;
}
</style>

</head>
<body>

	<img alt="forum.ua" src="resources/images/forum.jpg" />
	<div align="right">
		<form action="Login" method="POST">
			<input type="text" name="nickname" placeholder="Nickname"
				class="textboxlogin" required /> <input type="password"
				name="password" placeholder="Password" class="textboxlogin" required />
			<input type="submit" value="Log in" />
		</form>
	</div>

	<nav id="navigation" class="clearfix">

	<ul>
		<li><a href="Home">Home</a></li>
		<li><a href="registr.jsp">Registration</a></li>
		<li><a href="Login">Log out</a></li>
		<div align="right">
			<a href="#">${userdata}</a>
		</div>
	</ul>
	</nav>

</body>
</html>