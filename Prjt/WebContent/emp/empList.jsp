<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>사원목록</h3>

<table border="1">
	<tr><th>사번</th><th>이름</th></tr>
	<c:forEach items = "${list }" var="vo">
	<tr><td>${vo.employee_id }</td>
	 		<td>${vo.employee_id }${vo.last_name }</td>
	</tr>
	</c:forEach>




</table>

</body>
</html>