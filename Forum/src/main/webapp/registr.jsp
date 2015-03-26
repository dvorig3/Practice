<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registration</title>
<link rel="shortcut icon" type="image/jpg" href="resources/images/favicon.jpg"/>
<style>


body {
	font-family: helvetica;
}

#bg {
	position: relative;
	top: 10px;
	height: 500px;
	width: 800px;
	margin-left: auto;
	margin-right: auto;
}

.module {
	position: relative;
	height: 80%;
	width: 450px;
	margin-left: auto;
	margin-right: auto;
	border-radius: 5px;
	background: RGBA(255, 255, 255, 1);
	-webkit-box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
}

.form {
	float: left;
	height: 86%;
	width: 100%;
	box-sizing: border-box;
	padding: 40px;
}

.textbox {
	height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 2px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
}

.textbox:focus {
	outline: none;
	border: rgba(24, 149, 215, 1) 2px solid;
	color: rgba(24, 149, 215, 1);
}

.button {
	height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
	background: #2E9AFE;
	color: #FFF;
	font-weight: bold;
	font-size: 12pt;
	transition: background .4s;
	cursor: pointer;
}

.fs-title {
	font-size: 15px;
	text-transform: uppercase;
	color: #2C3E50;
	margin-bottom: 10px;
}

.button:hover {
	background: #2E64FE;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="bg">
		<div class="module">
			<form class="form">
				<center>
					<h2 class="fs-title">Create your account</h2>
				</center>
				<input  type="text" name= "nick" placeholder="Nickname" class="textbox" /> <input
					type="text" placeholder="Password" class="textbox" /> <input
					type="text" placeholder="Confirm password" class="textbox" /> <input
					type="button" value="Sign up" class="button" />
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>