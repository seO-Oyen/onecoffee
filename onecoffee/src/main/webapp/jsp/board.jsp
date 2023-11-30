<%@page import="vo.Board"%>
<%@page import="java.util.List"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<script src="jquery-3.1.1.js"></script>
<script>
	function writeBoard() {
		location.href='boardWrite.jsp'
	}
	
	function boardDetail(boardNum) {
		location.href = 'readBoard.jsp?boardNum=' + boardNum
	}
</script>
</head>
<body>
	<%
	BoardDAO boardDao = new BoardDAO();
	String userNumStr = request.getParameter("userNum");
	int userNum = Integer.parseInt(userNumStr);
	
	List<Board> boards = boardDao.getBoards();
	
	%>
	<!-- 메뉴바 -->
	<div>
		<span>one coffee</span> <span>메뉴소개</span> <span>매장 안내</span> <span>주문하기</span>
		<span>커뮤니티</span>
	</div>
	<div class="container">
		<input type="button" onclick="writeBoard()" value="게시글 등록">
		<table class="table table-hover table-striped">
			<col width="10%">
			<col width="50%">
			<col width="15%">
			<col width="15%">
			<col width="10%">
			<thead>

				<tr class="table-success text-center">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>처리 여부</th>
				</tr>
			</thead>
			<tbody>
			<%
			for (Board board : boards) {
			%>
				<tr style="text-align:center;" onclick="boardDetail(<%=board.getNo()%>)">
					<td><%= board.getNo() %></td>
					<td><%= board.getTitle() %></td>
					<td>작성자</td>
					<td><%= board.getFirstDate() %></td>
					<td><%= board.isEnd() ? "처리완료" : "처리 전" %></td>
				</tr>
			<% } %>
			</tbody>
		</table>

	</div>
</body>
</html>