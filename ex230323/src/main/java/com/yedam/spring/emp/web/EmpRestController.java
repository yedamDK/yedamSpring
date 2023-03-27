package com.yedam.spring.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@CrossOrigin
@RestController
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("/emps")
	public List<EmpVO> getEmpList(Model model){
		return empService.getEmpAll();
	}
	
	//단건조회
	@GetMapping("/emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.getEmp(empVO);
	}
	
	//등록
	@PostMapping("/emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empService.insertEmp(empVO);
		return empVO;
	}
	
	//수정
	@PutMapping("/emps/{employeeId}")
	public EmpVO updateEmpInfo(@PathVariable int employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empService.updateEmp(empVO);
		return empVO;
	}
	//삭제
	@DeleteMapping("/emps/{employeeId}")
	public EmpVO deleteEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		empService.deleteEmp(employeeId);			
		return empVO;
	}	

}
