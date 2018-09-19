package com.hcmony.testaop;

import org.springframework.stereotype.Service;

/**
 * @FileName package com.hcmony.testaop.DemoService.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-15 16:31:00
 * @Modifier hcmony
 * @Updated 2017-11-15 16:31:00
 * @Description
 * @Version BUILD1001
 */
@Service
public class DemoService {
	public void outputResult(){
		System.out.println("从组合注解获取的bean");
	}
}
