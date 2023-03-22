package com.yedam.app.spring;

import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV {

	@Override
	public void on() {
		System.out.println("스프링 방식으로 SamsungTV 켬");

	}

}
