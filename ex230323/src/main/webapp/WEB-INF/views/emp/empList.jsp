<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style>
	table, tr, th, td{
		border : 1px solid black;
	}
</style>
<!-- ajax를 쓰기 위한 jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
  <button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
								
			</tr>
		</thead>
		<tbody>
			<!-- items는 model에서 보낸 이름 그대로 쓰기-->
			<!-- 삭제할 때 location.herf='deleteInfo?=employeeId=${emp.employeeId}'
			 라고 하면 페이지전환형식으로 됨. 그런데 보통 페이지 전환 안 하기 때문에 function으로처리. -->
			<c:forEach items="${empList }" var="emp">
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId }</td>
					<td>${emp.firstName }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.hireDate }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<td><button type="button"
						onclick="deleteInfo(${emp.employeeId}, event)">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function printAlert(message){
			if(message ==  null || message == '') return;
			alert(message);
		}
		
		printAlert(`${result}`);
		
		function deleteInfo(id, event){
			$.ajax({
				url : 'empDelete',
				method : 'post',
				data : { employeeId : id },
				success : function(data){
					console.log(data); 
				},
				error : function(reject){
					console.log(reject);
				}
			});
			
			event.stopPropagation();
		}
	</script>
</body>
</html>