<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<title>이용후기</title>
</head>
<style>
.button {
	/* background:lightblue; */
	border: solid #cdd0d1;
	cursor: pointer;
}
</style>
<body>

	<div align=center>
		<h2>『자전거 무료대여 이용후기』</h2>
		<h4>
			<b> ♡이용 후기를 남겨주세요♡</b>
		</h4>
		<table cellspacing=3 width=600 height=100 border=1>
			<tr>
				<td bgcolor="plum" width=20 height=50><p align=center>
						<b>번호</b>
					</p></td>
				<td bgcolor="plum" width=100><p align=center>
						<b>제목</b>
					</p></td>
				<td bgcolor="plum" width=50><p align=center>
						<b>작성자</b>
					</p></td>
				<td bgcolor="plum" width=50><p align=center>
						<b>등록일</b>
					</p></td>
			</tr>

			<tbody>
				<c:forEach var="comment" items="${comments}">
					<tr>
						<td><p align=center>
								<c:out value="${comment.id}" />
							</p></td>
						<td><a href="<c:out value="selectOne/${comment.id}"/>"><c:out
									value="${comment.title}" /></a></td>
						<td><p align=center>
								<c:out value="${comment.writer}" />
							</p></td>
						<td><p align=center>
								<fmt:formatDate pattern="yyyy-MM-dd" value="${comment.date}" />
							</p></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table>
			<tr>
				<td width=535></td>
				<td><a href="./insertForm"><input type="button" value=글쓰기
						class="button"></a></td>
			</tr>
		</table>
	</div>
</body>
</html>
</head>