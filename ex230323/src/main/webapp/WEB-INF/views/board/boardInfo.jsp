<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단건조회</title>

</head>
<body>
		<table>
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 100px;" readonly>${boardInfo.contents }</textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:choose>
				<c:when test="${not empty boardInfo.image }">
					<td><img						
							src="<c:url value="/resources/images/${boardInfo.image }" />"
							style="width: 50%;"
						    alt="이미지" />
					</td>
				</c:when>
				<c:otherwise>
					<td></td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${boardInfo.regdate }"
					pattern="yyyy/MM/dd" /></td>
		</tr>
	</table>
	<button type="button"
		onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
	<button type="button"
		onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>


	<!--  <form onsubmit="return false">
		<div>
			<span>번호 ${boardInfo.bno }</span>
		</div>
		<div>
			<span>제목 ${boardInfo.title }</span>
		</div>
		<div>
			<span>작성자 ${boardInfo.writer }</span>
		</div>
		<div>
			내용<textarea name="contents">${boardInfo.contents }</textarea>
		</div>
		<div>
			<span><td>
  <c:if test="${not empty boardInfo.image}">
    <img src="<c:url value='/resources/images/${boardInfo.image}' />" style="width: 50%;" alt="이미지" />
  </c:if>
</td>
<td>
  <c:if test="${empty boardInfo.image}">
    <!-- 이미지가 없는 경우에 대한 처리 -->
  <!--</c:if>
</td></span>
		</div>
		<div>			
			<span>작성일자 <fmt:formatDate value="${boardInfo.regdate }" pattern = "yyyy/MM/dd"/></span>
		</div>
		<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
		<button type="button">삭제</button>				
	</form> -->
</body>
</html>