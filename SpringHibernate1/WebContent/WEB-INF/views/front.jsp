<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dashboard</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
            <h2 id="form_header" class="text-warning" align="center">CREDIT CARD APPLICATION</h2>
            <div> </div>
     
            <!-- User input form to validate a user -->
            <form id="user_form" action="validateuser" method="POST">
                <div class="form-group">
                    <label for="first_name">First Name:</label>
                    <input type="text" class="form-control" id="first_name" placeholder="Enter First Name" name="first_name" required>
                </div>
                <div class="form-group">
                    <label for="last_name">Last Name:</label>
                    <input type="text" class="form-control" id="last_name" placeholder="Enter Last Name" name="last_name" required>
                </div>
                <div class="form-group">
                    <label for="name">UID:</label>
                    <input type="text" class="form-control" id="uid" placeholder="Enter uid" name="uid" required>
                </div>
                <div class="form-group">
                    <label for="sec_que">Security Question:</label>
                    <input type="text" class="form-control" id="sec_que" placeholder="Enter Security Question" name="sec_que" required>
                </div>
                <div class="form-group">
                    <label for="sec_ans">Security Answer:</label>
                    <input type="text" class="form-control" id="sec_ans" placeholder="Enter Security Answer" name="sec_ans" required>
                </div>
                <button id="Submit_app" type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
</body>
</html>