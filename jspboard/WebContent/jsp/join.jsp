<%@page import="util.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	MemberDAO dao = new MemberDAO();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
fieldset {
	width: 500px;
}
table {
	width: 490px;
}
.ph{
	width: 60px;
}
</style>

<script type="text/javascript">
	function idcheck(){
		 var sub = window.open("idcheck.jsp", 
 				 "아이디 중복확인", "width=500, height=200, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );
		
		
	}
 

	function check123(){
		var id = document.getElementById('id').value;
		var p1 = document.getElementById('p1').value;
		var p2 = document.getElementById('p2').value;
		var ph1 = document.getElementById('ph1').value;
		var ph2 = document.getElementById('ph2').value;
		var ph3 = document.getElementById('ph3').value;
		var name = document.getElementById('name').value;
		var address = document.getElementById('address').value;
		var same = document.getElementById('same').value;
		
	
		if(same=='0'){
			alert('중복확인을 하세요.');
			return false;
		}
		if(id==''){
			alert('아이디를 입력하세요.');
			return false;
		}
		if(p1==''){
			alert('비밀번호를 입력하세요.');
			return false;
		}
		if(p2==''){
			alert('비밀번호 확인을 입력하세요.');
			return false;
		}
		if(p1!=p2){
			alert('비밀번호가 맞지 않습니다.')
			return false;
		}
		if(name==''){
			alert('이름을 입력하세요');
			return false;
		}
		if(ph1==''){
			alert('핸드폰 번호를 입력하세요.');
			return false;
		}
		if(ph2=='')
		{
			alert('핸드폰 번호를 입력하세요.');
			return false;	
		}
		if(ph3=='')
		{
			alert('핸드폰 번호를 입력하세요.');
			return false;	
		}
		if(address==''){
			alert('주소를 입력하세요.');
			return false;
		}
		return true;
	}

</script>

<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="../member" method="post" onsubmit="return check123()" name="join">
		<input type="hidden" name="action" value="joinmember">
		<input type="hidden" id="same" value="0" name="same">
		<fieldset>
			<legend>회원가입</legend>
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="id" name="id"> 
					<input type="button" value="중복확인" onclick="idcheck()"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="p1" name="password">
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="p2">
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="name" name="name"></td>					
				</tr>
				<tr>
					<td>전화번호</td>
					
					<td>
						<select id="ph1" name="ph1">
							<option>010</option>
							<option>011</option>
							<option>016</option>
							<option>018</option>
							<option>019</option>
						</select>
					- <input type="text" id="ph2" name="ph2" class="ph">
					- <input type="text" id="ph3" name="ph3" class="ph"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="address" name="address"></td>
				</tr>
			</table>
			<input type="submit" value="가입" name="submit">
			<input type="reset" value="다시쓰기" name="re">
		</fieldset>
	</form>

</body>
</html>