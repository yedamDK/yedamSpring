package com.yedam.app.spring;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");

		TV tv = (TV)ctx.getBean("tv");
		//오브젝트 (TV)
		tv.on();
		
	}

}
