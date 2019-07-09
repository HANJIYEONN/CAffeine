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

<style>
	span {
	    font-weight: bold;
	    font-size: 2em;   
	    text-align: center; 
	}

</style>
<body>

		<br/><br/><br/><br/><br/><br/>
		<div class="container">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="jumbotron" style="padding-top: 30px; ">
					<form method="post" action="userUpdate.do">
						<h3>
							<span class = 'text-info'>Modifying Information</span>
						</h3>
						<p><br/>
						<div class = "form-group">
							<input type="text" class="form-control" placeholder="ID" name="userID" maxlength="20">
						</div>
m-group">
							<input type="password" class="form-control" placeholder="#" name="userPassword" maxlength="20">
						</div>
						<div class = "form-group">
							<input type="text" class="form-control" placeholder="name" name="userName" maxlength="20">
						</div>
						<div class = "form-group">
							<input type="text" class="form-control" placeholder="nickname" name="userNickname" maxlength="20">
						</div>
						<div class = "form-group">
							<input type="email" class="form-control" placeholder="email" name="userEmail" maxlength="50">
						</div>
						<input type="submit" class="btn btn-primary form-control" value="Modify">
						<br/><br/>
						<button type="button" class="btn btn-info form-control" value="Input button" onclick="location.href='myFage.do'">BACK</button>
					</form>
				</div>	 
		</div>

		<div class="col-lg-4"></div>
	</div>
	



	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="js/bootstrep.js"></script>
</body>
</html>