<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form name="updateForm" action="boardUpdate" method="POST" onsubmit="return false">
		<div>
			<h3>게시글 수정</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image }"></td>
			</tr>
			<tr>
				<th>수정날짜</th>
				<td><input type="date" name="updatedate"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='getBoardInfo?bno=${boardInfo.bno}'">취소</button>
	</form>
	<script>
		function formOptionChk(){
			let title = document.getElementsByName('title')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == ""){
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
						
			if(contents.value == ""){
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}
			
			updateForm.submit();
		}
		
		document.querySelector('button[type="submit"]')
				.addEventListener('click', formOptionChk);
		
	</script>
</body>
</html>