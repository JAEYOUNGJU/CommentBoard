<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>
<c:set var="date" value="<%=new java.util.Date()%>" />
<c:set var="today">
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
</c:set>

<html>
<head>
<title>글수정</title>
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
<h4>【이용후기 수정】</h4>
<c:forEach var="comment" items="${selectOne}">
	<form action="update/${comment.id}" method="post">
		<table cellspacing=3 width=700 border=1>

			<tr>
				<td bgcolor="plum" width=20 style="text-align: center"><b>번호</b></td>
				<td><input type="number" id="id" value="${comment.id}" readonly></td>

			</tr>
			<tr>
				<td bgcolor="plum" width=100 style="text-align: center"><b>제목</b></td>
				<td><input type="text" name="title" value="${comment.title}"></td>
			</tr>
			<tr>
				<td bgcolor="plum" width=20 style="text-align: center"><b>작성자</b></td>
				<td><input type="text" name="writer" value="${comment.writer}" readonly></td>
			</tr>
			<tr>
				<td bgcolor="plum" width=50 style="text-align: center"><b>등록일</b></td>
				<td><c:out value="${today}" /></td>
			</tr>
			<tr>
				<td bgcolor="plum" width=20 style="text-align: center"><b>내용</b></td>
				<td><textarea style='width: 500px; height: 250px; overflow-y: scroll'
						name="content" cols=70 row=600 required>${comment.content}</textarea></td>
			</tr>
		</table>
		<table>
			<tr>
			
				<td width=600></td>
				<td><input type="submit" value="저장"	class="button"></a></td>
				<td><a href="../index"><input type="button" value="목록"	class="button"></a></td>
			</tr>
		</table>
	</form>
	</c:forEach>
	</div>
</body>
</html>
</head>