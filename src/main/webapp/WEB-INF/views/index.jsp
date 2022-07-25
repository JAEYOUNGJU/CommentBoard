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

	<form method=post action='/comment/index'>
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
						<td><a href="<c:out value="/comment/selectOne/${comment.id}"/>"><c:out
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
				<td>
					<a href="./insertForm"><input type="button" value=글쓰기 class="button"></a>
				</td>
			</tr>
		</table>

		<!-- 페이징 -->
		<!-- 검색 결과 -->
		<c:forEach var="searchItem" items="${searchItems}">
		   <tr height=80px align=center>
		      <td><c:out value="${searchItem.id}"/></td>
		      <td><a href= <c:url value='/comment/selectOne/${searchItem.id}'/>><c:out value="${searchItem.title}"/></a></td>
		      <td><c:out value="${searchItem.writer}"/></td>
		      <td><c:out value="${fn:substring(searchItem.date,0,11)}"/></td>
		   </tr>
		</c:forEach>
   
		<c:if test="${keyword != null }">
			<input type="text" name="title" value="${keyword}">
		</c:if>
		
		<c:if test="${keyword == null }">
			<input type="text" name="title" >
		</c:if>
		
		<input type="submit" value="검색">
	</form>
      
	<br><br>

	<a href='/comment/index/${searchpagination.ppPage}/${keyword}'><c:out value="<<"/></a>
	<a href='/comment/index/${searchpagination.pPage}/${keyword}'><c:out value="<"/></a>
	
	<c:forEach var="i" begin="${searchpagination.startPage}" end="${searchpagination.lastPage}">
		<b><a href = '/comment/index/${i-1}/${keyword}'>${i}</a></b>
	</c:forEach>
	
	<a href='/comment/index/${searchpagination.nPage}/${keyword}'><c:out value=">"/></a>
	<a href='/comment/index/${searchpagination.nnPage}/${keyword}'><c:out value=">>"/></a>

 </div>
 </body>
</html>