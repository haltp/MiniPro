<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script type="text/javascript">
	function formCheck() {
		var frm = document.frm;
		
		if(frm.mPassword.value != frm.mPassword1.value) {
			alert("패스워드가 일치하지 않습니다.");
			frm.mPassword.value = null;
			frm.mPassword1.value = null;
			frm.mPassword.focus();
			return false;			
		}
		
		return true;
	}
	
	function idCheck(str){
		var url = "idCheck.do?mid="+str;
		if(str == "") {
			alert("아이디를 입력하세요.");
			frm.mId.focus();
		}else {
			window.open(url, "아이디 중복확인", "width=600, height=200, top=100, left=100");
		}
	}
	
	
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>회원가입</h1>
		</div>
		<form id="frm" name="frm" onsubmit="formCheck()" action="memberJoin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="text" id="mId" name="mId" required="required">&nbsp;
							<button type="button" onclick="idCheck(mId.value)">중복체크</button></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" id="mPassword" name="mPassword" required="required"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" id="mPassword1" name="mPassword1" required="required"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="mName" name="mName" required="required"></td>
					</tr>
				</table>
			</div>
			<br /> <input type="submit" value="회원가입">&nbsp;
			<input type="reset" value="취소">
		</form>
	</div>
</body>
</html>