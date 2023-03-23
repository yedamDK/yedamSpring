package com.yedam.spring.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.spring.emp.mapper.EmpMapper;
import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

//bean으로 등록해야 하기 때문에 어노테이션 service 필요. 필요에 따라 이름도 줄 수 있다. 중복되는 경우
//이름은 변수명으로 사용된다. @SErvice(value=)
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpMapper empMapper;
	//서비스impl 안에 있으면 어떤 맵퍼도 사용 가능 그대신 따로 @Autowired해서 추가해줘야됨
	
	@Override
	public List<EmpVO> getEmpAll() {
		return empMapper.SelectEmpAllList();
	}

	@Override
	public EmpVO getEmp(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override
	public int insertEmp(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		
		if(result == 1 ) {
			return empVO.getEmployeeId();
		}else {
			return -1;
		}
	}

	@Override
	public String updateEmpSal(int empId, int raise) {
		String message = null;
		//결과값에 따라 message를 남기기 위해 초기화
		int result = empMapper.updateEmpSal(empId, raise);
		
		if( result == 1) {
			message = "정상적으로 급여를 갱신하였습니다.";
		}else {
			message = "작업이 실패했습니다. 사원번호를 확인해주세요.";
		}
	
		return message;
	}

	@Override
	public Map<String, String> updateEmp(EmpVO empVO) {
		Map<String, String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empVO.getEmployeeId()));
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}
		
		return map;		
	}

	@Override
	public Map<String, String> deleteEmp(int empId) {
		Map<String, String> map = new HashMap<>();
		
		map.put("사원번호", String.valueOf(empId));
		
		int result = empMapper.deleteEmpInfo(empId);
		
		if(result == 1) {
			map.put("결과", "Success");
		}else {
			map.put("결과", "Fail");
		}
		
		return map;		
	}

}
