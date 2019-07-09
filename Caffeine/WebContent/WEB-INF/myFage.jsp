<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width", initial-scale="1">

	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/site.css">
<title>C.A.ffeine</title>

	<style>
		p {
			text-align : center;
			}
	</style>

</head>

<script>
	function UpdateAccount() {
		var myFage = document.myFage;
		myFage.method = "post";
		myFage.action = "userUpdateForm.do";
		myFage.submit();
	}
	
	function CaffeineIdentity() {
		var myFage = document.myFage;
		myFage.method = "post";
		myFage.action = "userIntakeForm.do";
		myFage.submit();
	}
	
	
	</script>

<body>
		<form name="myFage">
				<p>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
					<button type="button" class="btn btn-info btn-lg" value="Input button" onclick="UpdateAccount()">[Modifying Information]</button>
					<button type="button" class="btn btn-info btn-lg" value="Input button" onclick="CaffeineIdentity()">[Check Caffeine]</button>
					<br/><br/>
					<button type="button" class="btn btn-primary " value="Input button" onclick="location.href='main.do'">BACK</button>
		</form>
					<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
					<script type="text/javascript" src="js/bootstrap.js"></script>
				<p/>

</body>
</html>