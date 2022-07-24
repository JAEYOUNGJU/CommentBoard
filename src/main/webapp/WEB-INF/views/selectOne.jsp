<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>
<c:set var="date" value="<%=new java.util.Date()%>" />
<c:set var="today">
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
</c:set>
<html>
<head>
<title>상세보기</title>
</head>
<style>
.button {
	border: solid #cdd0d1;
	cursor: pointer;
	font-size: 12px;
}

.button2 {
	width: 70px;
	height: 26px;
	border: solid #cdd0d1;
	cursor: pointer;
	font-size: 12px;
}

textarea {
	width: 100%;
	text-align: left;
	resize: none;
}
.table {
	border-collapse: collapse;
}

.table2 {
	font-size: 12px;
	border-collapse: collapse;
}

.table3 {
	font-size: 12px;
	border: 2px;
	border-style: solid;
	border-collapse: collapse;
}
</style>
<body>
	<div align=center>
		<br>
		<h4>【이용후기】</h4>
		<table cellspacing=3 width=700 border=1 class="table">
			<c:forEach var="comment" items="${selectOne}">
				<tr>
					<td bgcolor="plum" style="text-align: center" width=20><b>번호</b></td>
					<td><c:out value="${comment.id}" /></td>
				</tr>
				<tr>
					<td bgcolor="plum" style="text-align: center" width=100><b>제목</b></td>
					<td><c:out value="${comment.title}" /></td>
				</tr>
				<tr>
					<td bgcolor="plum" style="text-align: center" width=20><b>작성자</b></td>
					<td><c:out value="${comment.writer}" /></td>
				</tr>
				<tr>
					<td bgcolor="plum" style="text-align: center" width=50><b>등록일</b></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd"
							value="${comment.date}" /></td>
				</tr>
				<tr>
					<td bgcolor="plum" style="text-align: center" width=20><b>내용</b></td>
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

		</table>
		</c:forEach>
		
		<!-- 댓글 등록 -->
		<p>

			<br>
		<form action="ReplyInsert" method="post">
			<c:forEach var="comment" items="${selectOne}">
				<input type="hidden" value="${comment.id}" name="comment">
				<table cellspacing=3 width=700 height=100 border=1px class="table3">

					<tr>
						<td align=center bgcolor="YellowGreen" width=80
							style="text-align: center"><b>작성자</b></td>
						<td width=50><input type="text" name="writer"required "></td>
						<td><input type="submit" value="댓글등록" class="button"></td>
					</tr>
					<tr>
						<td bgcolor="YellowGreen" width=20 style="text-align: center"><b>댓글내용</b></td>
						<td colspan="5"><textarea
								style='width: 500px; height: 50px; overflow-y: scroll'
								name="content" cols=70 row=100 required>${commentReply.content}</textarea></td>
					</tr>
				</table>
			</c:forEach>
		</form>
		
		<!-- 댓글 보기 -->

		<p>

			<br>
			<c:forEach var="commentReply" items="${selectReply}">
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
								name="content" cols=70 row=100 readonly>${commentReply.content}</textarea></td>
					</tr>
				</table>
				<table>
					<tr>
						<td width=550></td>
						<td style="border: 0"><input type="button" value="댓글수정" class="button2" OnClick="location.href='/comment/replyUpdateForm/${commentReply.id}'"></td>
						<td><input type='button' value='댓글삭제' class="button2"	OnClick="location.href='/comment/ReplyDelete/${commentReply.id}'"></td>
					</tr>
				</table>
			</c:forEach>
	</div>

</body>
</html>
</head>


