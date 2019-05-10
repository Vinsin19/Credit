<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Status</title>
</head>
<body>
<table border=2px>
<tr><td>UID</td><td>${uid} </td></tr>
<tr><td>Application ID</td><td> ${appid} </td></tr>
<tr><td>Date and Time</td><td>${appdt}</td></tr>
<tr><td>Status</td><td> ${appst} </td></tr>
</table>
<form action="Dashboard" method="POST">
<button id="Dash" type="Submit" class="btn btn-primary">Dashboard</button>
</form>
</body>
</html>