package com.hcmony.service;

import org.springframework.stereotype.Component;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author com.hcmony
 * @since V1.0.0, 2019/03/04 16:52
 */
@Component
public class HystrixFeignServiceImpl implements HystrixFeignService {

	@Override
	public String test(String s) {
		return "error"+s;
	}
}
