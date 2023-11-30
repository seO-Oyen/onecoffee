<%@page import="vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<script src="jquery-3.1.1.js"></script>
<script>
function goMain() {
	location.href = 'board.jsp'
}
</script>
</head>
<body>
	<%
	BoardDAO boardDao = new BoardDAO();
	
	String title = request.getParameter("title");
	String text = request.getParameter("text");
	
	if(title != null && text != null) {
		boardDao.createBoard(title, text, 2);
		%>
		<script>
			location.href = 'board.jsp'
		</script>
		<%
	}
	
	%>
	<!-- 메뉴바 -->
	<div>
		<span>one coffee</span> <span>메뉴소개</span> <span>매장 안내</span> <span>주문하기</span>
		<span>커뮤니티</span>
	</div>
	<div class="container">
		<!-- <form id="frm01" class="form-inline" method="post">
			<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
				<input class="form-control mr-sm-2" placeholder="제목" /> <input
					class="form-control mr-sm-2" placeholder="내용" />
				<button class="btn btn-info" type="submit">Search</button>
			</nav>
		</form> -->
		<form>
			<input name="title" type="text" placeholder="제목을 입력하세요">
			<div>
			<textarea name="text" cols="50" lows="10" placeholder="내용"></textarea>
			</div>
			<input type="submit" value="등록" />
			<input type="button" onclick="goMain()" value="게시판 목록" />
		</form>

	</div>
</body>
</html>