<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%Member member = (Member)session.getAttribute("member"); %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<style type="text/css">
textarea {
	border: 1px solid;
	resize: none;
}
body {
	width: 900px;
}

h1 {
	width: 800px;
	text-align: center;
	background-color: gray;
}

form {
	width: 850px;
}

table {
	width: 800px;
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
<h1>게시판</h1>

<form action="board" method="post" onsubmit="">
	<table>
		<tr>
			<td>아이디</td>
			<td><%=member.getId() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="100" cols="30" name="content" id="content">
			</textarea>
		</tr>
	</table>
	<input type="submit" value="작성">
	<input type="reset" value="다시쓰기">
</form>

</body>
</html>