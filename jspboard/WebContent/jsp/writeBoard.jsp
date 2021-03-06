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
<script type="text/javascript">
function check(){
	var title = document.getElementById('title').value;
	var content = document.getElementById('content').value;
	
	if(title==''){
		alert('제목을 입력하세요.');
		return false;
	}
	else(content==''){
		alert('내용을 입력하세요.');
		return false;
	}
	return true;
}

</script>

</head>
<body>
<h1>게시판</h1>

<form action="board" method="post" onsubmit="return check()">
	<input type="hidden" name="action" value="write">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<%=member.getId() %>
				<input type="hidden" name="id" value="<%=member.getId()%>">
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows="30" cols="100" name="content" id="content"></textarea>
		</tr>
	</table>
	<input type="submit" value="작성">
	<input type="reset" value="다시쓰기">
</form>

</body>
</html>