<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	width: 50%;
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
	<table>
		<th>Sorter: ${sortTypeName}</th>
		<th>Filter</th>
		<tr>
			<td>
				<center>
					<form action="SortRegistrator" method="POST">
						Sort by: <select name="sort">
							<option value = "default">choose one</option>
							<option value="d">date</option>
							<option value="id">importance-date</option>
							<option value="isd">importance-source-date</option>
							<option value="sd">source-date</option>
						</select> <input type="submit" value="sort" />
					</form>
				</center>
			</td>
			<td></td>
		</tr>
	</table>
</body>
</html>