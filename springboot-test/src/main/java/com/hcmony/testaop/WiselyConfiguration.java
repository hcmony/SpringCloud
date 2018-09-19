package com.hcmony.testaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @FileName package com.hcmony.testaop.WiselyConfiguration.java
 * @Creator hcmony
 * @Created 2017-11-15 16:29:00
 * @Modifier hcmony
 * @Updated 2017-11-15 16:29:00
 * @Description 组合注解 @Configuration @ComponentScan
 * @Version BUILD1001
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
	String[] value() default {};
}
