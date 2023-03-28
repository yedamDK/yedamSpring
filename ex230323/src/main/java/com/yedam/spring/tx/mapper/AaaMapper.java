package com.yedam.spring.tx.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	@Insert("INSERT INTO aaa VALUES ( #{value} )")
	public void insert(String value);
}
