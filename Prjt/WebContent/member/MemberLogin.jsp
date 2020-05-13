<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>홍성우</title>
</head>
<body>
	<!-- Navigation bar -->
	<%@include file="/common/Header.jsp"%>
	<h3>로그인</h3>
	<br>
	<div>${errorMsg }</div>
	<form action="MemberLogin.do" method="post">
		<input name="id" placeholder="id" value="${param.id }"><br>
		<input name="pwd" placeholder="pwd"><br>
		<button>로그인</button>
	</form>

	<%@include file="/common/Footer.jsp"%>
</body>
</html>