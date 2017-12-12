<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@page import="vo.Board"%>
<%@page import="util.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<!-- prefix는 c라는 이름의 태그를 쓰는것
uri는 내가 쓸 태그의 라이브러리 --> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
h1 {
	text-align: center;
}

table {
	float: center;
	width: 800px;
	border: 1px solid;
}

body {
	width: 900px;
	margin: 0 auto;
	padding: 0;
}

.no {
	text-decoration: none;
}

.no:visited {
	color: black;
}

.main {
	background-color: teal;
	color: white;
	font-weight: bold;
	width: 150px;
	margin-top: 20px;
}

tr:hover {
	background-color: #aacc13;
}
.title{
	font-weight: bold;
}
</style>
<script type="text/javascript">
function read(num){
	location.href="board?action=read&num="+num;
}
</script>
<title>글목록</title>
<%BoardDAO dao = new BoardDAO();
List<Board> list = (List<Board>)request.getAttribute("boardlist");%>
<%Member member = (Member)session.getAttribute("member");
String id = (String)session.getAttribute("id");%>
</head>
<body>
	<h1>글목록</h1>
	<table border="1">
		<%for(int i=0; i<list.size(); i++){ %>
			<tr>
				<td> <div onclick="read(<%=list.get(i).getBoardnum() %>)">
				<span style="color: blue;" class="title">[제목]</span>
				&nbsp;<span class="title"><%=list.get(i).getTitle() %></span><br></div>
				<%=list.get(i).getId() %> |  
				조회:<%=list.get(i).getHits() %> | 
				<%String s = list.get(i).getInputdate(); %>
				<%s = s.substring(10,16); %>
				<%=s %>	
				</td>
			</tr>		
		<%} %>
	</table>
	
	
	<%-- <table border="1">
		<c:forEach items="${list }" var="b">
			<%int i = 0; %>
			<tr>
				<td>
				<div onclick="read(${b.id})">
				<span style="color: blue;" class="title">[제목]</span>
				&nbsp;<span class="title">${b.title }</span><br></div>
				${b.id } |  
				조회:${b.hits} | 
				<%String s = list.get(i).getInputdate(); i++;%>
				<%s = s.substring(10,16); %>
				<%=s %>
				</td>
			</tr>
		</c:forEach>
	</table> --%>
	
	<%-- <%List<Board> blist = dao.getBoardList();
	//listsize는 한 화면에 나오는 페이지 개수
	//수정하려면 dao에서도 수정 해야됨..
	int listsize = 5;
	//pagenum은 페이지 갯수
	int pagenum = blist.size()/listsize;
	//남은거 있으면 보여줘야됨
	if(blist.size()%listsize != 0){
		pagenum++;
	}

	%>
	<%for(int i = 1; i<=pagenum; i++){ %>
		<a href="board?action=boardlist&page=<%=i%>">[<%=i %>]</a>
	<%} %> --%>
	
	<%//현재 페이지의 번호를 얻는다
		int cpage = (int)request.getAttribute("cpage"); 
	%>
	<p>cpage는 <%=cpage %></p>
	<%
	//보여줄 페이지의 시작과 긑 정의
	int start = 1; int end = 5;
	//-----전체페이지의 개수를 구한다.
	List<Board> rlist = dao.getBoardList();
	//listsize는 보여줄 글의 개수 만약 바꾸면 dao에서도 바꿔야됨
	int listsize = 5;
	int pagenum = rlist.size()/listsize;
	//남은 글 보여주려면 더해줘야 됨
	if(rlist.size()%listsize!=0){
		pagenum++;
	}
	//---------------------------
	
	int st= 1;//시작점 구하기 위한 변수
	int en = 5;//끝점 구하기 위한 변수
	//아래 while문은 시작점과 끝점을 구하기 위한 구문
	while(true){
		if(cpage>=st && cpage<=en){
			//만약 현재 페이지가 st와 en사이면 
			//start와 end를 st와 en으로 정해준다.
			start = st;
			end = en;
			//만약 end가 pagenum보다 많으면 end를 pagenum으로 바꿔줌
			if(end>pagenum)
				end = pagenum;
			break;
		}
		//없을 경우 둘다 5를 더해줌
		else{
			st+=5;
			en+=5;
		}
	}
	%>
	
	<p>start = <%=start %> end = <%=end %></p>
	
	<%if(!(cpage>=1&&cpage<=5)){
		//만약 현재페이지가 1~5가 아니면 이전을 만듬%>
		<a href="board?action=boardlist&page=<%=start-5%>">이전</a>
		
	<%} %>
	
	<%for(int i = start; i<=end; i++){ %>
		<a href="board?action=boardlist&page=<%=i%>">[<%=i %>]</a>
	<%} %>
	
	<%if(end<pagenum){ 
		//만약 현재 end보다 전체 pagenum이 크면 다음을 만듬%>
		<a href="board?action=boardlist&page=<%=end+1%>">다음</a>	
	<%} %>
	
	<br>
	
	<input type="button" value="메인" class="main" onclick="location.href='../index.jsp'">
	<c:if test="${id != null}">
		<input type="button" value="글쓰기" class="main" onclick="location.href='writeBoard.jsp'">
	</c:if>
	
	
	
		
</body>
</html>