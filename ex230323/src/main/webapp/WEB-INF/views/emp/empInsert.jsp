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
	<!-- ContextPath 1) <알파벳씨:url /> 2) el: ${pageContext.request.contextPath }  -->
	<form action="empInsert" method="post">
		<div>
			<label>first_name : <input type="text" id="" name="firstName"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"></label>
		</div>
		<div> 
			<label>email : <input type="email" name="email"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"></label>
		</div>
		<button type="submit">등록</button>
		<button type="button">목록</button>
	</form>
</body>
</html>