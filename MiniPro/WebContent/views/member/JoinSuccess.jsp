<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
<div align="center">
	<h3>${vo.mName } 님 회원가입되었습니다.</h3>
	<h3>${vo.mAuth } 권한을 갖는다.</h3>
</div>

</body>
</html>