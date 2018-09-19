package com.hcmony;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcmony on 2017/9/5.
 */
@RestController
public class TestController {

	@Autowired
	private  TestService testService;

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test(){
		return  testService.test();
	}

}
