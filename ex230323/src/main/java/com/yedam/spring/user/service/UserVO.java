package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVO {
	//필드 이름 name과 age로만 받을 수 있다.
	
	private String name;
	private Integer age;
	//날짜형식 기본값은 MM/dd/yyyy? 이라서 yyyy-MM-dd라고 입력하면 안 된다.
	//DateTimeFormat을 써야 날짜형식을 yyyy-MM-dd으로 입력해도 된다.
	//시간까지 입력하려면 yyyy-MM-dd HH:mm:ss 라고 할 것
	//만약 시간까지 썼다면 시간까지 입력해야 오류가 안 남
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date today;
	
	private MultipartFile pic;
}
