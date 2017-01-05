<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="description" content="login jsp">
    <meta name="author" content="">
    <title>Login</title>
  </head>

  <body>

	<div class='alert alert-danger' role='alert'>
			<%if (null != request.getAttribute("errorMessage")) {
				request.getAttribute("errorMessage");
    		}%>
   </div>
   
    
    
    <div class="container">
    
      <form action="auth">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
			<div class="checkbox">
			  <label>
				<input type="checkbox" value="remember-me"> Remember me
			  </label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
    </div> 
    
  </body>
</html>
