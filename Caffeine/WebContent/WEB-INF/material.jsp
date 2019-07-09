<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function download(maskName){
	window.open("download.jsp?mno=" + mno, "", "width=10, heigh=10");
	
	alert(maskName);
}
</script>
</head>
<body>
<b><font color="red">상세보기</font></b>
<hr/>

<table border="1">
<tr>
<th>번호</th>
<td>${material.mno }</td>
</tr>
<tr>
<th>제목</th>
<td>${material.title }</td>
</tr>
<tr>
<th>내용</th>
<td>${material.content }</td>
</tr>
<tr>
<th>작성자</th>
<td>${material.id }</td>
</tr>
<tr>
<th>작성일자</th>
<td>${material.writeDate }</td>
</tr>
<tr>
<th>파일</th>
<td><a href="javascript:download(${material.mno})">${material.realName }</a></td>
</tr>
<tr>
<th>조회수</th>
<td>${material.hit }</td>
</tr>
</table>
<p/>
<c:if test="${member.id == material.id }">
<a href="delete.do?mno=${material.mno }">삭제</a>
<a href="updateForm.do?mno=${material.mno }">수정</a>
</c:if>
<a href="replyForm.do?mno=${material.mno }">답글쓰기</a>
<a href="materialList.do">목록보기</a>
</body>
</html>