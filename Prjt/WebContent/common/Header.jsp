<%@page import="co.yedam.app.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 30%;
	height: 300px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	min-height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>
<body>

	<header>
		<h2>Cities</h2>
	</header>

	<section>
		<nav>
			<ul>
				<li>${sessionScope.loginId }${sessionScope.loginId}님<br> <%-- 					<%= 
    			session.getAttribute("loginMember") != null?
   		((MemberVO)session.getAttribute("loginMember")).getName() : "" %></li> --%>
				<li><a href="./">메인 </a></li>
				<c:if test="${loginId ==null }">
					<li><a href="MemberLogin.do">로그인</a></li>
					<li><a href="MemberInsert.do">회원가입</a></li>
				</c:if>
				<c:if test="${loginId != null }">
					<li><a href="MemberLogout.do">로그아웃</a></li>
					<li><a href="MemberUpdate.do">정보수정</a></li>
				</c:if>
				<li><a href="BoardList.do">게시판</a></li>

				<!-- loginId == 'admin' -->
				사원관리

			</ul>
		</nav>

		<article>