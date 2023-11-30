<%@page import="vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script src="jquery-3.1.1.js"></script>
<script>
	function goMain() {
		location.href = 'board.jsp'
	}
</script>
</head>
<body>
	<%
	String boardNumStr = request.getParameter("boardNum");
	// TODO : 유저 번호로 유저 조회 => 어드민일시 처리완료 버튼 뜨게
	String userNumStr = request.getParameter("userNum");
	String re = request.getParameter("re");
	if (re != null && !re.isEmpty()) { %>
		<script>
			alert("댓글 입력했네?")
			alert(re)
		</script>
	<% }
	BoardDAO boardDao = new BoardDAO();
	
	if (boardNumStr == null) { %>
		<script>
			alert("잘못된 정보입니다.")
			location.href = "board.jsp"
		</script>
	<% } else {
		int boardNum = Integer.parseInt(boardNumStr);
		Board board = boardDao.getBoard(boardNum);
	
	%>
	<script>
		function updateRe() {
			location.href = 'readBoard.jsp?boardNum=' + <%= boardNumStr %> + '&userNum' + <%= userNumStr %> + '&re=' + $("[name=re]").val()
		}
	</script>
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
			<div><%= board.getNo() %></div>
			<div><%= board.getTitle() %></div>
			<div>작성자</div>
			<div><%= board.getText() %></td>
			<div><%= board.getFirstDate() %></td>
			<div><%= board.isEnd() ? "처리완료" : "처리 전" %></div>
	<% } %>
	</div>
	<input type="button" onclick="goMain()" value="게시판 리스트로" >
	<br>
	<!-- <form>
	<div>댓글</div>
		<textarea name="re" width="50" height="10"></textarea>
		<input type="button" onclick="updateRe()" value="등록"/>
	</form> -->
</body>
</html>