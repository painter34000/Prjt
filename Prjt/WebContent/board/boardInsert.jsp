<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>홍성우</title>

	<!-- Navigation bar -->
	<%@include file="/common/Header.jsp"%>
	<h3 align="center">간단하지 않은 첫 등록페이지</h3>
	<form action="../BoardInsert.do" align="center" method="post">
		제목 : <input type="text" name="title" id="title"><br> 
		내용 :<input type="text" name="contents" id="contents"><br> 
		작성자: <input type="text" name="id" id="id" value=${loginId}><br>

		<button type="submit">등록하기</button>
	</form>
	<%@inxlude file="/common/Footer.jsp"%>
</body>
</html>
