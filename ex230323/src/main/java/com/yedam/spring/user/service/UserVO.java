package com.yedam.spring.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	//필드 이름 name과 age로만 받을 수 있다.
	
	private String name;
	private Integer age;
	//날짜형식 기본값은 MM/dd/yyyy? 이라서 yy-dd-mm라고 입력하면 안 된다.
	//날짜형식을 yy-dd-mm으로 입력하면 안 되는 것을 되게 한다. 시간까지 가능 yyyy-MM-dd hh:mm:ss 라고 입력했다면
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date today;
}
