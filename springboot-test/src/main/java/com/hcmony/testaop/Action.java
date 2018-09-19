package com.hcmony.testaop;

import java.lang.annotation.*;

/**
 * @FileName package com.hcmony.testaop.Action.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司:
 * @Creator hcmony
 * @Created 2017-11-13 14:51:00
 * @Modifier hcmony
 * @Updated 2017-11-13 14:51:00
 * @Description 自己写一个注解，定义拦截规则
 * @Version BUILD1001
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
	String name();
}
