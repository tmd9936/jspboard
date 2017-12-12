<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인</title>
</head>
<body>
<%Member member = (Member)session.getAttribute("member"); 
String id = (String)session.getAttribute("id");%>
	
	<%if(member==null){ %>
		<h1><a href="member?action=join">회원가입</a></h1>
		<h1><a href="member?action=login">로그인</a></h1>
	<%}else{ %>
		<h1><%=id %>님 환영합니다.</h1>
		<!-- <h1><a href="jsp/writeBoard.jsp">글쓰기</a></h1> -->
		
		<h1><a href="jsp/updateForm.jsp">회원정보 수정</a></h1>
		<h1><a href="member?action=removeMember">로그아웃</a></h1>	
	<%} %>
		<h1><a href="jsp/board?action=boardlist">게시판</a></h1>
		

		
		
</body>
</html>