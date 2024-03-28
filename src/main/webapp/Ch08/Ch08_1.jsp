<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		function checkform(){
			alert("아이디 : "+document.loginForm.id.value+"\n"+
					"비밀번호 : "+document.loginForm.passwd.value);
		}
	</script>
	<title>Validation</title>
</head>
<body>
	<form name="loginForm">
		<p> 아 이 디 : <input type="text" name="id">
		<p> 비밀번호 : <input type="text" name="passwd">
		<p> <input type="submit" value="전송" onclick="checkform()">
	</form>
</body>
</html>