package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

//페이지를 반환할 것이기 때문에 rest안 붙임
@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET,  등록 수정 삭제 -> POST
	
	//전체조회
	@GetMapping("/empList")
	//페이지를 반환할 것이기 때문에 String
	public String getEmpAllList(Model model) {
		//같이 딸려오는 데이터가 없어서 모델만 쓰면 된다. 모델에 데이터를 담아서 전달
		model.addAttribute("empList", empService.getEmpAll());
		//views 밑에 emp폴더에 empLIst.jsp파일로 간다는 의미(new others로 jsp 검색해서 만들기)
		return "emp/empList";
	}
	
	//단건조회
	//내부 필드명을 기반으로 데이터를 받는다.-커맨드 객체
	//내부 필드명이 키가 된다.
	//각 타입에 맞는 format으로 값을 보내야 한다.(double은 정수나 실수 가능)
	//Date는 java.util.Date에 따라서 yyyy/MM/dd로 해야 됨.
	//input은 통신하면 return이 항상 string이라서 숫자 0을 넣어도 "0"으로 넘어간다.
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		//getEmp가 정보를 조회하는 메소드
		return "emp/empInfo";
	}
	
	//등록 - Form 페이지 호출
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	//등록 - Process
	//	public String empInsertProcess(EmpVO empVO, Model model) {
	//	model.addAttribute("result", result);
	//redirect: 컨트롤러 요청. 하지만 model은 컨트롤러를 호출하는 순간 새로운 모델이 생성되어서
	//데이터 손실이 일어나기 때문에 model을 부분은 변경 필요 RedirectAttributes addFlashAttribute
	//커맨드 객체 EmpVO empVO를 썼기 때문에 annotation이 필요 없다.
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다."
					+"\n 등록된 사원의 사번은 " + empId +" 입니다.";
		}		
		rrtt.addFlashAttribute("result", result);
		return "redirect:empList";
	}
	
	//수정 - Process 
		// 1) Client -JSON-> Server
		// 2) Server -text-> Client
		//empMapper.xml에서 firstName, email.salary만 수정되게 설정
		//넘어온 데이터를 
	@PostMapping("/empUpdate")
	@ResponseBody
	//json으로 보낼 때 @RequestBody 필요(fetch나 ajax에 들어가있는지 확인)
	//@RequestBody json을 받아서 EmpVO에 넣겠다. 
	//'Content-Type' : 'application/json'
    //데이터를 json으로 인코딩(자바스크립트 기본타입을 json으로)
    //parse: json타입을 일반 타입으로 바꾸는 것
	//body: JSON.stringify
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	//삭제
	@PostMapping("/empDelete")
	//@ResponseBody 데이터를 보내는 역할 page만 아니면 반환 가능.(그래서 무조건 json을 처리하는 것으로 하면 안된다.)
	@ResponseBody
	//데이터를 여러개로 주고 받을 때는 커맨드
	//데이터 하나를 주고 받을 때는 리퀘스트파람
	//변수명이 키값과 같으면 따로 안 줘도 되지만 다르면 리퀘스트파람에 따로 지정해야 됨.
	//보내는 데이터가 string이니까 ajax에서 따로 string이 아닌 dataType을 줬으면 못 받는다.
	//@RequestParam 객체가 아니라 기본타입 값 하나만 받을 때 보통 쓴다
	//아래는 변수명과 key값이 다를 때 아래처럼 같으면 맨 마지막 처럼.
	
	public String empDeleteProcess(@RequestParam("employeeId") int empId) {
		//employeeId는 키값으로  empList ajax에 있는 employeeId, empId는 EmpService.java에 있음
		/*즉, 이 메서드는 클라이언트(AJAX)에서 전달한 employeeId 매개변수 값을 받아오는 것입니다.
		 * 이렇게 받아온 empId 변수를 이용하여, 해당 직원 정보를 삭제하는 등의 작업을 수행할 수 있습니다.		
		Mapper에서는 이 값을 사용하여 데이터베이스에서 직원 정보를 삭제하는 등의 작업을 수행할 수 있습니다.*/
		Map<String, String> map = empService.deleteEmp(empId);

//  똑같지만 다른 방식		
//	public String empDeleteProcess(@RequestParam int employeeId) {
		//EmpMapper.java에 int employeeId가 있어서 동일하므로 파람에 이름을 주지 않아도 정상 작동
//		Map<String, String> map = empService.deleteEmp(employeeId);
/*@RequestParam("employeeId")와 같이 요청 파라미터의 이름을 명시하는 경우와 생략하는 경우의 차이점은 매개변수 이름과 요청 파라미터 이름이 일치하지 않을 때,
 * 즉 요청 파라미터의 이름과 매개변수의 이름이 다를 때 유용하게 사용할 수 있습니다.
예를 들어, HTTP 요청 파라미터의 이름이 emp_id일 경우에는 @RequestParam("employeeId") int empId와 같이 명시하는 것이 좋습니다.
반면에, 요청 파라미터의 이름이 employeeId와 같이 매개변수 이름과 동일한 경우에는
@RequestParam int employeeId와 같이 생략하는 것이 간편하고 가독성이 좋습니다.*/		
		return map.get("결과");
		
	}	
		
}
