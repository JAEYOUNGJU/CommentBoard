<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<title>상세보기</title>
</head>
<style>
.button {
	border: solid #cdd0d1;
	cursor: pointer;
}

textarea {
	width: 100%;
	text-align: left;
	resize: none;
}
</style>
<body>
	<div align=center>
		<br>
		<h4>【이용후기】</h4>
		<table cellspacing=3 width=700 border=1>
			<c:forEach var="comment" items="${selectOne}">
				<tr>
					<td bgcolor="lightpink" style="text-align: center" width=20><b>번호</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td bgcolor="lightpink" style="text-align: center" width=100><b>제목</b></td>
					<td><c:out value="${comment.title}" /></td>
				</tr>
				<tr>
					<td bgcolor="lightpink" style="text-align: center" width=20><b>작성자</b></td>
					<td><c:out value="${comment.writer}" /></td>
				</tr>
				<tr>
					<td bgcolor="lightpink" style="text-align: center" width=50><b>등록일</b></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${comment.date}" /></td>
				</tr>
				<tr>
					<td bgcolor="lightpink" style="text-align: center" width=20><b>내용</b></td>
					<td><textarea
							style='width: 500px; height: 250px; overflow-y: scroll'
							name="content" cols=70 row=600 readonly>${comment.content}</textarea></td>
				</tr>
		</table>
		<table>
			<tr>
				<td width=550></td>
				<td><a href="../index"><input type="button" value=목록
						class="button"></a></td>
				<td><a href="../updateForm/${comment.id}"><input
						type="button" value=수정 class="button"></a></td>
				<td><a href="../delete/${comment.id}"><input type="button"
						value=삭제 class="button"></a></td>
			</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>
</head>