<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
	<form name="insertForm" action="boardInsert" method="POST" onsubmit="return false">
	<!-- onsubmit="return false 자동동작을 막음. name="insertForm" 을 이용해 function으로 등록하기"
	필수항목은 input 태그 안에 name 뒤에 required를 써도됨 <input type="text" name="title" required>
	아니면 아래 forOptionChk() 함수처럼 하면 됨. 
	 -->
		<div>
			<h3>게시글 등록</h3>
		</div>
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${boardInfo.bno}" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td><input type="text" name="image"></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='getBoardList'">목록</button>
	</form>
	<script>
		function formOptionChk(){
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];
			let contents = document.getElementsByName('contents')[0];
			
			if(title.value == ""){
				alert("제목이 입력되지 않았습니다.");
				title.focus();
				return;
			}
			
			if(writer.value == ""){
				alert("작성자가 입력되지 않았습니다.");
				writer.focus();
				return;
			}
			
			if(contents.value == ""){
				alert("내용이 입력되지 않았습니다.");
				contents.focus();
				return;
			}
			
			insertForm.submit();
		}
		
		document.querySelector('button[type="submit"]')
				.addEventListener('click', formOptionChk);
		
	</script>







	<!-- <form action="boardInsert" method="post">
		<div>
			<label>번호 : <input type="text" name="bno" value="${boardInfo.bno }" readonly></label>
		</div>
		<div>
			<label>제목 : <input type="text" name="title"></label>
		</div>
		<div>
			<label>작성자 : <input type="text" name="writer"></label>
		</div>
		<div> 
			<label>내용 : <textarea name="contents"></textarea></label>
		</div>
		<div>
			<label>첨부이미지 : <input type="text" name="image"></label>
		</div>		
		<button type="submit">등록</button>
		<button type="button">목록</button>
	</form>-->

</body>
</html> 