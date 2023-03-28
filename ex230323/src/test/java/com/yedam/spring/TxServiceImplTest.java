package com.yedam.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.spring.tx.service.AaaService;
import com.yedam.spring.tx.service.Cats;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml")
public class TxServiceImplTest {
	
	@Autowired
	AaaService aaaService;
	
	@Autowired
	Cats myCat;
	
	//@Test
	public void txTest() {
		aaaService.insert();
	}
	
	@Test
	public void aopTest() {
		myCat.printInfo();
	}
}
