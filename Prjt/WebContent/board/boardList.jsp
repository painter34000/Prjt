<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
</head>

<jsp:include page="/common/Header.jsp"></jsp:include>


	<h3 align="center">게시판</h3>
	<table border="1">
	
	<tr><th>번호</th><th>제목</th><th>작성자</th></tr>
	<c:forEach var= "vo" items="${list }">
	<tr><td>${vo.seq }</td><td>${vo.title }</td>
		<td><a href="BoardUpdate.do?seq=${vo.seq }">${vo.title }</a></td>
		<td>${vo.name }</td>
		
		<td>
		<fmt:parseDate value = "${vo.regdt }" var="fmtDt" pattern ="yyyy-mm-dd hh:mm:ss" />
		<fmt:formatDate value = "${fmtDt }" type="time" /></td>
		</tr>
	</c:forEach>	
	</table>
	<%@include file = "/common/Footer.jsp" %>
</body>
</html>