<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	
	function check(){
		var id = document.getElementById('id').value;
		var password = document.getElementById('password').value;
		
		if(id==''){
			alert('id를 입력하세요');
			return false;
		}
		if(password==''){
			alert('비밀번호를 입력하세요');
			return false;
		}
		return true;
	}
</script>
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="../member" method="post" onsubmit="return check()">
		<input type="hidden" name="action" value="memberLogin">
		<fieldset>
			<legend>로그인</legend>
			아이디 <input type="text" name="id" id="id"> <br>
			비밀번호 <input type="password" name="password" id="password"><br>
			<input type="submit" value="로그인">
		</fieldset>
	</form>
</body>
</html>