package com.hcmony;

import java.lang.annotation.Annotation;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/07/20 17:39
 */
public class Test {
	public Test(){

	}

	public static void main(String[] args) {
		Annotation annotation = MyTest1.class.getAnnotation(MyTest1.class);

		System.out.println();
	}
}
