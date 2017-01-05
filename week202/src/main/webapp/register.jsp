<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="signin.css" rel="stylesheet">
		<title>register page</title>
	</head>

	<body>
		<div class="has-error" >

			<%if(null!=request.getAttribute("errorMessage")) {
        		request.getAttribute("errorMessage");
    		}%>
    	</div>
		<form action="signin">
			<h2 class="form-signin-heading">Register Now !</h2>
			<div class="form-group has-error">
				Firstname <input type="text" name="firstname" value="" class="form-control"/>
				Lastname <input type="text" name="lastname" value="" class="form-control"/>
				Email <input type="email" name="email" class="form-control">
				Password <input type="password" name="password" class="form-control">
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</body>
</html>