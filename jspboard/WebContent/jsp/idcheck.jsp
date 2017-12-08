<%@ page language='java' contentType='text/html; charset=UTF-8'
	pageEncoding='UTF-8'%>
<%String message = (String)session.getAttribute("message");
if(message==null){
	message = " ";
}%>
<%String state = (String)session.getAttribute("state"); 
if(state==null)
	state = "null";
%>
<%String id = (String)session.getAttribute("id"); 
if(id==null)
	id="dd";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<title>ID 중복확인</title>
<script type="text/javascript">
function end(){
	var use = document.getElementById.value;
	use = "<%=id%>";
	opener.document.join.id.value = use;
	opener.document.join.same.value = '1';
	window.close();
}
</script>
</head>
<body>
	<h3>ID 중복확인</h3>
	<form action='../member' method='post'>
		<input type='hidden' name='action' value='idcheck'>
		<input type="hidden" id="state" name="state">
		<h4>아이디입력</h4><br>
		<input type='text' name='id' id="ids" value="1"> 
		<input type="submit" value='중복확인'><br>
		<h4 id="inText"><%=message%><%=id %></h4>
	</form>
	
	<%if(state.equals("true")){ %>
		<input type="hidden" name="action" value="useid">
		<input type="hidden" name="use" id="use">
		사용하시겠습니까?
		<input type="button" value="사용" onclick="end();"> 
	<%} %>
</body>
</html>