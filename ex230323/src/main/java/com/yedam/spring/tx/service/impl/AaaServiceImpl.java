package com.yedam.spring.tx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.AaaMapper;
import com.yedam.spring.tx.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional
	@Override
	public void insert() {
		aaaMapper.insert("101");
		aaaMapper.insert("907");
	}

}
