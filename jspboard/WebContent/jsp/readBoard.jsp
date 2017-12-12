<%@page import="java.util.List"%>
<%@page import="vo.Reply"%>
<%@page import="util.ReplyDAO"%>
<%@page import="vo.Member"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<%Board board = (Board)request.getAttribute("board"); %>
<%Member member = (Member)session.getAttribute("member"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function checkreply(){
	var retext = document.getElementById('retext').value;
	if(retext == ''){
		alert('댓글을 입력하세요.');
		return false;
	}
	return true;
}
</script>
<style type="text/css">
h1 {
	text-align: center;
}

table {
	float: center;
	width: 690px;
	border: 1px solid;
}

body {
	width: 700px;
	margin: 0 auto;
	padding: 0;
}
.showreply{
	border : 1px solid gray;
	width: 690px;
}
.ids{
	font-weight: bold;
}
.writereply{
	width: 690px;
	background-color: gray;
	padding-top: 7px;
	padding-left: 7px;
	position: relative;
}
textarea {
	border: 1px solid ;
	resize: none;
}
.submit{
	width: 55px;
	height: 50px;
	position: absolute;
	
}
.deletetext{
	text-align: right;
}

</style>
<title>게시글 읽기</title>
</head>
<body>
	<h1>게시글</h1>
	<a href="../index.jsp">메인화면</a>
	<a href="board?action=boardlist">게시판</a>
	<table border="1">
		<tr>
			<td>제목 &nbsp;
			<%=board.getTitle() %><br>
			<%=board.getId() %> | 
			조회: <%=board.getHits() %> | 
			<%=board.getInputdate() %></td>
		</tr>
		<tr>
			<td>
				<pre><%=board.getContent() %></pre>
				<div class="udbox">
					<%if(member !=null){ %>
						<%if(board.getId().equals(member.getId())) {%>
							<a href="board?action=boardUpdate&num=<%=board.getBoardnum() %>" class="ud">수정</a>|
							<a href="board?action=delete&num=<%=board.getBoardnum() %>" class="ud">삭제</a>
						<%} %>
					<%} %>
				</div>
			</td>
		</tr>
		
	</table>
	<br><hr>
	<h3>댓글</h3>
	<%ReplyDAO dao = new ReplyDAO(); 
	List<Reply> rlist = dao.listReply(board.getBoardnum());%>
	
	<%for(Reply r : rlist){ %>			
		<div class="showreply">
			<span class="ids">[ID] <%=r.getId()%></span> ||
			(<%=r.getInputdate() %>)
			<%if(member != null){
				if(r.getId().equals(member.getId())){ %>
				<a href="reply?action=delete&replynum=<%=r.getReplynum()%>&
				boardnum=<%=board.getBoardnum()%>">
				<span class="deletetext">삭제</span></a>
				<%}
			} %>
			<br><br>
			<%=r.getRetext() %>		
		</div>
	<%} %>
	
	<br>
	<%if(member != null) {%>
	<div class="writereply">
		<form action="reply" onsubmit="return checkreply()" method="post">
			<input type="hidden" name="action" value="replywrite">
			<input type="hidden" name="boardnum" value="<%=board.getBoardnum()%>">
			<textarea rows="3" cols="84" 
			id="retext" name="retext"></textarea>
			<input type="submit" value="등록" class="submit">
		</form>
	</div>
	<%} %>

</body>
</html>