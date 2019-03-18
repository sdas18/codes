<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="netSalary" method="post">
<table>
<td>AssociateId</table>
<td><input type="text" name="associateId"></td>
<td><input type="submit" value="Click"></td>
<td><a href="index">||home||</a></td>
</tr>
</table>
</form>
</div>
<div align="center" class="error">${errorMessage }
<table>
<tr>

<th>netSal</th>
</tr>
<tr>
<td>${associateId}</td>
</tr>
</table>
</div>
</body>
</html>