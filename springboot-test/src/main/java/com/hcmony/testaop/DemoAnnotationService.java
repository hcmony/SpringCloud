package com.hcmony.testaop;

import org.springframework.stereotype.Service;

/**
 * @FileName package com.hcmony.testaop.DemoAnnotationService.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-13 14:53:00
 * @Modifier hcmony
 * @Updated 2017-11-13 14:53:00
 * @Description 编写使用注解的被拦截的类
 * @Version BUILD1001
 */
@Service
public class DemoAnnotationService {
	@Action(name="注解式拦截的add操作")
	public void add(String a){}
}
