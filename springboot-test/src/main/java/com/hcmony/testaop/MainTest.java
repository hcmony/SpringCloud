package com.hcmony.testaop;

import com.hcmony.service.UserService;
import com.hcmony.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @FileName package com.hcmony.testaop.MainTest.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-13 15:06:00
 * @Modifier hcmony
 * @Updated 2017-11-13 15:06:00
 * @Description
 * @Version BUILD1001
 */
public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext
				context = new AnnotationConfigApplicationContext(AopConfig.class);


		DemoAnnotationService demoAnnotationService =
				context.getBean(DemoAnnotationService.class);

		/*DemoMethodService demoMethodService =
				context.getBean(DemoMethodService.class);*/

		demoAnnotationService.add("参数是：ss");

		//demoMethodService.add();

		context.close();
	}
}
