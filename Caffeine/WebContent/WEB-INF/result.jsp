
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>C.A.ffeine</title>
</head>

<body>
	<center>
		<b><font color="#A6DAF7" size="6px">[Result]</font></b>
		<hr/>
		
		
<%--나중에 폰트 디자인 적용하자! --%>


			<c:choose>
				<c:when test = "${code == '00'}" >
				Wrong ID or password.<br/>
				Try Again.<p/>
				<a href="loginForm.do">Login</a>
				</c:when>
				<c:when test = "${code == '10'}" >
				Complete Sing-up.<br/>
				Please Login.<p/>
				<a href="loginForm.do">Login</a>
				</c:when>
				<c:when test = "${code == '11'}" >
				ERROR.<br/>
				Try Again.<p/>
				<a href="userInsertForm.do">Sign up</a>		
				</c:when>
				<c:when test = "${code == '20'}" >
				Update user information.<p/>
				<a href="main.do">Go to main</a>
				</c:when>
				<c:when test = "${code == '21'}" >
				ERROR.<br/>
				Try Again.<p/>
				<a href="userUpdateForm.do">Update User Information</a>
				</c:when>
				<c:when test = "${code == '30'}" >
				ERROR.<br/>
				Try Again.<p/>
				<a href = "postInsertForm.do">Write</a>
				</c:when>
				<c:when test = "${code == '31'}" >
				.<br/>
				.<p/>
				<a href = "#"></a>
				</c:when>
				<c:when test = "${code == '32'}" >
				.<br/>
				.<p/>
				<a href = "#.do"></a>
				</c:when>
				<c:when test = "${code == '40'}" >
				No Subscription Information.<br/>
				Please Sign up<p/>
				<a href = "userInsertForm.do">Sign up</a>
				</c:when>
				<c:when test = "${code == '41'}" >
				 Your ID is
 				<font color="blue" size="4px">[${ findID }]. </font>
 				<br/>
				Please Sign up.<p/>
				<a href = "loginForm.do">Login</a>
				</c:when>
			</c:choose>
	</center>

</body>
</html>