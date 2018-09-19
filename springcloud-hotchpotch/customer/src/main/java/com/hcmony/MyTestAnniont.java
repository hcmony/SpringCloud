package com.hcmony;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/07/20 17:40
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(Test.class)
public @interface MyTestAnniont {
}
