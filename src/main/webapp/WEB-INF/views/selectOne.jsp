<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<title>이용후기</title>
</head>

<body>
	<table cellspacing=1 width=600 border=1 >
			<c:forEach var="comment" items="${selectOne}">
				<tr>
					<td style="text-align:center" width=20><b>번호</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=100><b>제목</b></td>
					<td><c:out value="${comment.title}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=20><b>작성자</b></td>
					<td><c:out value="${comment.writer}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=50><b>등록일</b></td>
					<td><c:out value="${fn:substring(comment.date, 0, 11)}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=20><b>내용</b></td>
					<td><c:out value="${comment.content}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=50><b>원글</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=50><b>댓글수준</b></td>
					<td><c:out value="${comment.relevel}" /></td>
				</tr>
				<tr>
					<td style="text-align:center" width=50><b>댓글내 순서</b></td>
					<td><c:out value="${comment.recnt}" /></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<table>
		<tr>
			<td width=550></td>
			<td><a href="../index"><input type="button" value=목록></a></td>
		</tr>
	</table>

</body>
</html>
</head>