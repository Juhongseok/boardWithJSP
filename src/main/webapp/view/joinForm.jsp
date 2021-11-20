<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="join.do" method="post" onsubmit="return valid()">
		<p>
			id:<br/>
			<input type="text" id="userName" name="id" required>
			<button type="button" onclick="idCheck()">중복체크</button>
			<div id="duplicated" style="display:none;">중복된 아이디 입니다.</div>
			<div id="nonDuplicated" style="display:none;">사용 가능한 아이디 입니다.</div>
		</p>
		<p>
			password:<br/>
			<input type="password" name="password" required>
		</p>
		<p>
			address:<br/>
			<input type="text" name="address" required>
		</p>
		<p>
			<input type="hidden" name="role" value="user">
		</p>
		<input type="submit" value="가입">
	</form>
</body>
<script>
	let isChecking=false;
	function valid(){
		if(!isChecking)
			alert("아이디를 확인해 주세요");
		return isChecking;
	}
	function idCheck(){
		const userName=$("#userName").val();
		
		$.ajax({
			type: "POST",
			url:"/board/check.do",
			data:{userName: userName}
		}).done(function(data){
			if(data === "exist"){
				$("#duplicated").show();
				$("#nonDuplicated").hide();
				isChecking = false;
			}else if(data === "not exist"){
				$("#duplicated").hide();
				$("#nonDuplicated").show();
				isChecking = true;
			}
		});
	}
</script>
</html>