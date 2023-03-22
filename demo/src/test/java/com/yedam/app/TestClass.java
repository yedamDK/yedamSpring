package com.yedam.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.junit.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//com.test.java에서는 컨테이너가 없기 때문에 위에 위치를 지정해줘야 사용할 수 있다. 네번째 import
//xml은 읽었지만 컨테이너가 없다. 그래서 위에 runwith추가
//이렇게 되면 @Autowired ApplicationContext ctx;가 필요없어진다.
public class TestClass {
	
	//@Autowired //구현 클래스는 autowired로 인터페이스 한다.(클래스x) 두번째 import
	//ApplicationContext ctx;
	//세번째 import
	
	@Autowired
	Restaurant res;
	
	@Test //첫번째 import
	public void beanTest() {
		//컨테이너에 등록된 bean이 필요하지만
		//junit은 컨테이너에 다룰 수 없기 때문에
		//스프링에서 보조적으로 지원하는 라이브러리가 필요해서 pom.xml 가서 추가하기
		/*junit 밑에 넣기 120번째 줄
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-test</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
		  */
		//Restaurant res = ctx.getBean(Restaurant.class);
		assertNotNull(res);
		//ctx에서 bean을 가져오는데 클래스로 가져온다.(이름이 따로 없기 컴포넌트 되어있어서) 
	}
}
