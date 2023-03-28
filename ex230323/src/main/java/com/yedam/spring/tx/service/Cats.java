package com.yedam.spring.tx.service;

import lombok.Data;

@Data
public class Cats {

	private String name;
	private int age;
	private String color;
	
	public void printInfo() {
		System.out.println(this.name + ", " + this.age + ", " + this.color);	
	}
}
