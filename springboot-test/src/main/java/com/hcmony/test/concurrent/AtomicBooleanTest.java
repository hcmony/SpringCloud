package com.hcmony.test.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/07/19 16:47
 */
public class AtomicBooleanTest {
	private  static  AtomicBoolean atomicboolean = new AtomicBoolean(true);

	public static void main(String[] args) {
		System.out.println(atomicboolean.compareAndSet(true,false));
		System.out.println(atomicboolean.get());
		System.out.println(atomicboolean.compareAndSet(true,false));
		System.out.println(atomicboolean.get());
		System.out.println(atomicboolean.compareAndSet(false,true));
		System.out.println(atomicboolean.get());
		System.out.println(atomicboolean.get());
		System.out.println(atomicboolean.get());
	}
}
