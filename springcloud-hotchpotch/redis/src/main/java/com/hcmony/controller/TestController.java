package com.hcmony.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hcmony on 2017/9/5.
 */
@RestController
public class TestController {

	@Value("${server.port}")
	String port;


	@ApiOperation(value = "查询单个", notes = "")
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public String test(){
		return "server被调用了！:" +port;
	}

}
