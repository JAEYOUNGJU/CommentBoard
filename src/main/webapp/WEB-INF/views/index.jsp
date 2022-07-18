<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<title>이용후기</title>
</head>

<body>
	<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=20><p align=center>
						<b>번호</b>
					</p></td>
				<td width=100><p align=center>
						<b>제목</b>
					</p></td>
				<td width=20><p align=center>
						<b>조회수</b>
					</p></td>
				<td width=50><p align=center>
						<b>등록일</b>
					</p></td>
			</tr>

		<tbody>
			<c:forEach var="comment" items="${comments}">
				<tr>
					<td><p align=center><c:out value="${comment.id}" /></p></td>
					<td><c:out value="${comment.title}" /></td>
					<td><p align=center><c:out value="${comment.viewcnt}" /></p></td>
					<td><p align=center><c:out value="${fn:substring(comment.date, 0, 11)}" /></p></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<table>
		<tr>
			<td width=550></td>
			<td><input type="button" value=신규 "></input></td>
		</tr>
	</table>

</body>
</html>
</head>