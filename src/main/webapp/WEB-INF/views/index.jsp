<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>이용후기 게시판</title>
</head>
<style>
.button {
	border: solid #cdd0d1;
	cursor: pointer;
}

.button1 {
	overflow: hidden;
	border-radius: 5px;
}

.table {
	border-collapse: collapse;
}
</style>
<body>

	<div align=center>


		<img
			src="https://user-images.githubusercontent.com/33750251/64987392-f9eead80-d8c0-11e9-84a9-e2a4a7f624db.png"
			width="80" height="80">
		<h2>서울자전거 따릉이 이용후기</h2>

		<table cellspacing=3 width=600 height=100 border=1 class="table">
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

		<!-- 페이징 -->
		<a href='/comment/index/${pagination.ppPage}'><c:out value="<<" /></a>
		<a href='/comment/index/${pagination.pPage}'><c:out value="<" /></a>

		<c:forEach var="i" begin="${pagination.startPage}"
			end="${pagination.lastPage}">
			<b><a href='/comment/index/${i-1}'>${i}</a></b>
		</c:forEach>

		<a href='/comment/index/${pagination.nPage}'><c:out value=">" /></a> <a
			href='/comment/index/${pagination.nnPage}'><c:out value=">>" /></a> <br>
		<br>

		<!-- 검색 -->
		<form action="search" method="get" role="search">

			<select name="condition" id="condition">
				<option value="title"
					<c:if test="${condition eq 'title' }">selected</c:if>>제목</option>
				<option value="writer"
					<c:if test="${condition eq 'writer' }">selected</c:if>>작성자</option>
			</select> <input type="text" name="keyword" id="search"
				placeholder="Search..." />
			<button class="icon">
				<i class="fa fa-search"></i>
			</button>
		</form>
	</div>
</body>
</html>
</head>