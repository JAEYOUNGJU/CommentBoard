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
<title>댓글수정</title>
</head>
<style>
.button {
	border: solid #cdd0d1;
	cursor: pointer;
	font-size: 12px;
}

.table2 {
	font-size: 12px;
	border-collapse: collapse;
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
		<h4>【댓글 수정】</h4>
		<c:forEach var="commentReply" items="${updateReply}">
			<input type="hidden" value="${commentReply.id}" name="comment">
			<form name="replyUpdateForm" action="ReplyUpdate/${commentReply.id}" method="post">
				<table cellspacing=3 width=700 height=100 border=1 class="table2">

					<tr>
						<td bgcolor="YellowGreen" width=80 style="text-align: center"><b>번호</b></td>
						<td colspan="2" width=30 align=center><c:out
								value="${commentReply.id}" /></td>
						<td align=center bgcolor="YellowGreen" width=150
							style="text-align: center"><b>작성자</b></td>
						<td align=center><c:out value="${commentReply.writer}" /></td>

						<td width=100 bgcolor="lightgrey" align=center><c:out
								value="${today}" /></td>

					</tr>
					<tr>
						<td bgcolor="YellowGreen" width=20 style="text-align: center"><b>댓글내용</b></td>
						<td colspan="5"><textarea
								style='width: 500px; height: 50px; overflow-y: scroll'
								name="content" cols=70 row=100 required>${commentReply.content}</textarea></td>
					</tr>
				</table>
				<table>
					<tr>

						<td width=600></td>
						<td><input type="submit" value="저장" class="button"></td>
						<td><a href="../index"><input type="button" value="목록"
								class="button"></a></td>
					</tr>
				</table>
			</form>
		</c:forEach>
	</div>
</body>
</html>
</head>