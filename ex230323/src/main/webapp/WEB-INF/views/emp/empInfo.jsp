<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
	<form onsubmit="return false">
		<div>
			<label>id : <input type="text" name="employeeId" value="${empInfo.employeeId }" readonly></label>
		</div>
		<div>
			<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName }"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName" value="${empInfo.lastName }"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email" value="${empInfo.email }"></label>
		</div>
		<div>
			<label>phone_number : <input type="text" name="phoneNumber" value="${empInfo.phoneNumber }"></label>
		</div>
		<div>
			
			<label>hire_date : <input type="date" name="hireDate" value='<fmt:formatDate value="${empInfo.hireDate }" pattern = "yyyy-MM-dd"/>'></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId" value="${empInfo.jobId }"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary" value="${empInfo.salary }"></label>
		</div>
		<div>
			<label>commission_pct : <input type="number" name="commissionPct" value="${empInfo.commissionPct }"></label>
		</div>
		<div>
			<label>manager_id : <input type="number" name="managerId" value="${empInfo.managerId }"></label>
		</div>
		<div>
			<label>department_id : <input type="number" name="departmentId" value="${empInfo.departmentId }"></label>
		</div>
		<button type="submit">수정</button>
		<button type="button">취소</button>
	</form>
	<script>
	
		function updateEmpInfo(){
			//fetch는 함수 안에 안 들어가면 페이지 열면 의도치 않아도 바로 실행
			fetch('empUpdate', {
				method : 'post',
				headers : {
					'Content-Type' : 'application/json'
				},
				//데이터를 json으로 인코딩(자바스크립트 기본타입을 json으로)
				//parse: json타입을 일반 타입으로 바꾸는 것
				//
				body: JSON.stringify(serializeObject())
				/*'Content-Type': 'application/json'은
				서버에게 요청 본문이 JSON 형식으로 인코딩된 데이터임을 알리는 HTTP 요청 헤더이고,
				JSON.stringify은 자바스크립트 객체를 JSON 형식의 문자열로 변환하는 메서드*/
			})
			.then(response => response.json())
			//.then(data => console.log(data))
			//데이터가 넘어온 지 console.log로 확인 후 가리고 밑에 alert창으로 나오게 만듦.
			//동시에 두 개가 안 됨.
			.then(data => {
						if(data != null && data['결과'] == 'Success'){
							alert('사원번호 : ' + data['사원번호'] + '의 정보가 수정되었습니다.');
						}else{
							alert('해당 사원의 정보가 정상적으로 수정되지 않았습니다.');
						}
					})
			.catch(reject => console.log(reject));
		}

		function serializeObject() {
			let formData = $('form').serializeArray();
			// [{ name : 'firstName', value : 'Steven'}, { name : 'lastName', value : ''}, ...]
			//form 태그 안의 각 열의 데이터를 따로 각각의 객체로 본다.
			let objectData = {}
			formData.forEach(function (obj, idx) {
				objectData[obj.name] = obj.value
			});
			//우리가 원하는 형태로 한 행을 하나의 객체로 만듦.

			return objectData;
		}
		
		document.querySelector('button[type="submit"]')
		.addEventListener('click', updateEmpInfo);

	</script>
</body>
</html>