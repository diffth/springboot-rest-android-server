package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Test;
import com.example.service.TestService;

@RestController
@RequestMapping("app/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(method = RequestMethod.GET)
	List<Test> getList(){
		
		List<Test> testList = testService.findAll();
		return testList;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	void insertTest(Test test){
		
		testService.create(test);
	}
	
	@RequestMapping(value="{no}", method = RequestMethod.GET)
	Test getTest(@PathVariable int no){
		
		Test testView = testService.findOne(no);
		return testView;
	}
	
	@RequestMapping(value="{no}", method = RequestMethod.PUT)
	void updateTest(@PathVariable int no, Test test){
		
		testService.update(no, test);
	}
	
	@RequestMapping(value="{no}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteTest(@PathVariable int no){
		
		testService.delete(no);
	}
}
