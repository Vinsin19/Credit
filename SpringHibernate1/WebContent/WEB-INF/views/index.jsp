<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en-US" prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb#">
<head>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Customer Login</title>
<link  rel="stylesheet" href="https://stackp.w3layouts.com/wp-content/themes/w3layouts/css/login_style.css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,700,800" rel="stylesheet" type="text/css">
<link href='//fonts.googleapis.com/css?family=Oxygen:400,700,300' rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- login -->
		<div class="login-section">
	        <div class="login">
				<div class="modal-content modal-info">
					<div class="modal-header">
						<h3>AXA Bank</h3>
					</div>
					<div class="modal-body modal-spa">
						<div class="login-form">
							<form action="validate" method="post">
								<input type="text" class="user" name="uid" placeholder="Enter UID" required />
								<input type="password" class="lock" name="password" placeholder="Enter Password" required value="" />
								<input type="submit" value="Login">
							</form>
							<p>New User? <a href="regis">Register Here</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
