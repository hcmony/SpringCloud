package com.hcmony.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author com.hcmony
 * @since V1.0.0, 2019/03/04 16:52
 */
@RestController
public class HystrixRestTemplateController {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "error")
	@RequestMapping("test1")
	public String test(String s){
		return restTemplate.getForObject("http://provider/test?s="+s,String.class);
	}

	public String error(String s){
		return "error"+s;
	}
}
