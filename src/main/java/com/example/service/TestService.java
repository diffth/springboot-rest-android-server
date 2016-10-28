package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Test;
import com.example.mapper.TestMapper;

@Service
@Transactional
public class TestService {
	
	@Autowired
	TestMapper testMapper;
	
	public List<Test> findAll() {
		return testMapper.findAll();
	}

	public Test findOne(int no) {
		return testMapper.findOne(no);
	}

	public void delete(int no) {
		testMapper.delete(no);
	}

	public void create(Test test) {
		testMapper.create(test.getName(), test.getAge());
	}

	public void update(int no, Test test) {
		
		testMapper.update(no, test.getName(), test.getAge());
	}

}
