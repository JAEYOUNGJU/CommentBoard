<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<title>글쓰기</title>
</head>

<body>
<form action="insert.jsp" method="post">
	<table cellspacing=1 width=600 border=1>
			<c:forEach var="comment" items="${insertForm}">
				<tr>
					<td width=20><b>번호</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td width=100><b>제목</b></td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td width=20><b>작성자</b></td>
					<td><c:out value="${comment.writer}" /></td>
				</tr>
				<tr>
					<td width=50><b>등록일</b></td>
					<td><c:out value="${fn:substring(comment.date, 0, 11)}" /></td>
				</tr>
				<tr>
					<td width=20><b>내용</b></td>
					<td><c:out value="${comment.content}" /></td>
				</tr>
				<tr>
					<td width=50><b>원글</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td width=50><b>댓글수준</b></td>
					<td><c:out value="${comment.relevel}" /></td>
				</tr>
				<tr>
					<td width=50><b>댓글내 순서</b></td>
					<td><c:out value="${comment.recnt}" /></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<table>
		<tr>
			<td width=550></td>
			<td><a href="./insert"><input type="submit" value="입력"></td>
 			<td><a href="../index"><input type="button" value=목록></a></td>
		</tr>
	</table>
</form>
</body>
</html>
</head>