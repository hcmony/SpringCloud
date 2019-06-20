package com.hcmony.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author com.hcmony
 * @since V1.0.0, 2019/03/04 16:52
 */

@FeignClient(value = "provider",fallback = HystrixFeignServiceImpl.class)
public interface HystrixFeignService {

	@RequestMapping("/test")
	public String test(@RequestParam("s") String s);

}
