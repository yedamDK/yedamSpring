package com.yedam.spring.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.spring.emp.service.EmpVO;

public interface EmpMapper {
	//맵퍼가 가장 기본이 되는 기능이라 여러가지를 갖고 있으면 우리가 못 쓰므로 sql문 하나에 맵퍼하나
	//전체조회
	public List<EmpVO> SelectEmpAllList();
	
	//단건조회
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
	
	
	//수정 -급여를 정해진 비율로 인상
	public int updateEmpSal(
			@Param("empId") int employee_id,
			@Param("raise")	int raise);
	//마이바티스에서 지원하는 어노테이션 @Param sql문 안에서 사용할 이름 지칭
	//@Param("empId") EmpVO empVO 이면 empMapper에서 empId.employeeId라고 써야됨
	
	//수정 -사원 정보 수정
	public int updateEmpInfo(EmpVO empVO);
	
	//삭제
	public int deleteEmpInfo(int EmplyeeId);
}
