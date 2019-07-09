<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width", initial-scale="1">

	<link rel="stylesheet" href="css/bootstrap.css">
<title>C.A.ffeine</title>

</head>
<body>

		<br/><br/><br/><br/><br/><br/>
		<div class="container">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="jumbotron" style="padding-top: 30px; ">
					<form method="post" action="login.do">
						<h3 style="text-primary: center; ">Login</h3>
							<div class = "form-group">
								<input type="text" class="form-control" placeholder="ID" name="userID" maxlength="20">
							</div>
							<div class = "form-group">
								<input type="password" class="form-control" placeholder="Password" name="userPassword" maxlength="20">
							</div>
						<input type="submit" class="btn btn-primary form-control" value="LOGIN"><br/><br/>
						<button type="button" class="btn btn-info form-control" value="Input button" onclick="location.href='welcome.html'">BACK</button>
					</form>
				</div>	 
		</div>
		<div class="col-lg-4"></div>
		</div>
	
	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="js/bootstrep.js"></script>

</body>
</html>