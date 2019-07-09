<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name = "viewport" content="width=device-width", initial-scale="1">

	<link rel="stylesheet" href="css/bootstrap.css">
<title>C.A.ffeine</title>
</head>
	<script>

	function checking() {
		// title : title
		// content : content
		var title = document.getElementById("title").value;
		var content = document.getElementById("content").value;
		if (!title || title.length === 0) {
			alert("제목을 입력해주세요.");	
		} else 
		if (!content || content.length === 0) {
			alert("내용을 입력해주세요.");
		} else {
			var postForm = document.postForm;
			postForm.method = "post";
			postForm.action = "postInsert.do";
			postForm.submit();
		}
	}
	</script>
	
</head>
<body>
	<form name = "postForm">
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-targer="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>	
				<a class="navbar-brand" href="main.do">  MAIN  </a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="welcome.html">Welcome</a></li>
					<li class="active"><a href="main.do">BOARD</a></li>			
				</ul>
	
				<ul class="nav navbar-nav navbar-right">
					<li><a href = "logout.do">LOGOUT</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href = "myFage.do">MY FAGE</a></li>
				</ul>
			</div>
		</nav>
	
		<div class="container">
			<div class="row">
					<table class="table table-striped" style="text-align: center; border : 1px solid #dddddd">
						<thead>
							<tr>
								<th style="background-color : #eeeeee text-align: center;">POST</th> 
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
								<input type="text" id="title" class="form-control" placeholder="title" name="title" maxlength="100">
								</td>
							</tr>
							<tr>
								<td>
								<input type="text" class="form-control" placeholder="writer" name="writer" maxlength="20">
								</td>
							</tr>
							<tr>
								<td>
								<input type="date" class="form-control" placeholder="date" name="date" >
							</tr> 
							<tr>
								<td>
								<input type="text" class="form-control" placeholder="caffeine" name="caffeine" maxlength="30" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"> 
								</td>
							</tr>
							<tr>
								<td colspan="3">
								<img src="image\convenie.jpg" width="50" height="50"/><input type='radio' name='brand' value='image\convenie.jpg' checked/>convenience
								<img src="image\starbuck.png" width="50" height="50" /><input type='radio' name='brand' value='image\starbuck.png'/>starbucks
								<img src="image\Ediya.png" width="50" height="50" /><input type='radio' name='brand' value='image\Ediya.png' />ediya
							</tr>
							<tr>
								<td>
								<textarea id="content" class="form-control" placeholder="content" name="content" maxlength="4096" style="height:350px;"></textarea>
								</td>
							</tr>
						</tbody>
					</table>
					
					<button type="button" class="btn btn-info" value="Input button" onclick="checking()">[POST]</button>
					<button type="button" class="btn btn-info" value="Input button" onclick="location.href='main.do'">[BACK]</button> 

			</div>
		</div>
	</form>
			<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
			<script type="text/javascript" src="js/bootstrap.js"></script>
	
</body>
</html>