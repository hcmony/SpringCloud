package com.hcmony.testaop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @FileName package com.hcmony.testaop.AopConfig.java
 * @Creator hcmony
 * @Created 2017-11-13 15:04:00
 * @Modifier hcmony
 * @Updated 2017-11-13 15:04:00
 * @Description 开启aspectJ代理
 * @Version BUILD1001
 */
@Configuration
@ComponentScan("com.hcmony.testaop")
@EnableAspectJAutoProxy
public class AopConfig {
}
