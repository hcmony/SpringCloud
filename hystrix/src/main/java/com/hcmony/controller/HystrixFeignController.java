package com.hcmony.controller;

import com.hcmony.service.HystrixFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author com.hcmony
 * @since V1.0.0, 2019/03/04 16:52
 */
@RestController
public class HystrixFeignController {

	@Autowired
	private HystrixFeignService hystrixFeignService;

	@RequestMapping("test")
	public String test(String s){
		return hystrixFeignService.test(s);
	}
}
