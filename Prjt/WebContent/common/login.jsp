<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><title>

</title>
</head>
<%@ include file= "/common/Header.jsp" %>





<body>

<h3>로그인</h3>
<form action="/edu/Login.do" method = "post">
<input name= "id" placeholder="id"><br>
<input name= "pwd" placeholder="pwd"><br>
<button>로그인</button>
</form>


</body>
<%@ include file = "/common/Footer.jsp" %>
</html>