package com.yedam.app.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Autowired를 쓰면 @Component도 해줘야 됨
public class Restaurant {
	
	@Autowired
	Chef chef;
	
	public void open() {
		chef.coooking();
	}
}
