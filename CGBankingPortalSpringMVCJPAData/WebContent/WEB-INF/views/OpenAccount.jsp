<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>OpenAccount</title>
<style >
error{
color:red;
font-weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h2>Enter Details here to open savings account</h2>
<table>
<form:form action="openAccount1" method="post" modelAttribute="account">
<tr>
<td>Account</td>
<td><form:input path="accountBalance" size="30"/></td>
<td><form:errors path="accountBalance" cssClass="error"/></td>

</form:form>
</table>
</div>

</body>
</html>