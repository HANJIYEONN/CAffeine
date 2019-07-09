<%@page import="exe.entity.PostEntity"%>
<%@page import="java.util.ArrayList"%>
<%@page import="exe.dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">

<link rel="stylesheet" href="css/bootstrap.css">
<title>C.A.ffeine</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-targer="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.do"> MAIN </a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="welcome.html">Welcome</a></li>
				<li class="active"><a href="main.do">BOARD</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout.do">LOGOUT</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="myFage.do">MY FAGE</a></li>
			</ul>
		</div>
	</nav>
	<%-- 
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee text-align: center;">Number</th>
						<th style="background-color: #eeeeee text-align: center;">Title</th>
						<th style="background-color: #eeeeee text-align: center;">Writer</th>
						<th style="background-color: #eeeeee text-align: center;">Date</th>
					</tr>
				</thead>

--%>
	<div class = "container">
	<table border="1" class = "table table-striped table-bordered table-hover">
		<tr>
			<th>Number</th>
			<th>Brand</th>
			<th>Title</th>
			<th>Name</th>
		</tr>

		<c:forEach items="${list}" var="post">
			<tr>
				<c:set var="space" />

				<c:forEach begin="1" end="3">
					<c:set var="space">${space }&nbsp;&nbsp;&nbsp;</c:set>
				</c:forEach>
				<td>${post.num }</td>
				<td><img src="${post.picture}" width="50" height="50" /></td>
				<td><a href="post.do?num=${post.num}">${post.title}</a></td>
				<td>${post.writer }</td>
			</tr>
		</c:forEach>

		<tr>
			<th colspan="6">
				<c:if test="${ groupStartNum - 1 > 0 }">
					<a href="main.do?page=${ groupStartNum - 1 }">[prev]</a>
				</c:if>
				<c:forEach begin="${ groupStartNum }" end="${ groupStartNum + pageGroupCount - 1 }" var="pageNum">
					<c:if test="${ pageNum <= totalPage }">
						<a href="main.do?page=${ pageNum }">[${ pageNum }]</a>
					</c:if>
				</c:forEach>
				<c:if test="${ groupStartNum + pageGroupCount <= totalPage }">
					<a href="main.do?page=${ groupStartNum + pageGroupCount }">[next]</a>
				</c:if></th>
		</tr>

	</table>
	<a href="postInsertForm.do" class="btn btn-primary pull-right">POST</a>

	<script type="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	</div>

</body>
</html>