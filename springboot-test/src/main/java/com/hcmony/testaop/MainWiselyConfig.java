package com.hcmony.testaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @FileName package com.hcmony.testaop.MainWiselyConfig.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-15 16:34:00
 * @Modifier hcmony
 * @Updated 2017-11-15 16:34:00
 * @Description
 * @Version BUILD1001
 */
public class MainWiselyConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(DemoConfig.class);
		DemoService demoService = context.getBean(DemoService.class);
		demoService.outputResult();
		context.close();
	}
}
