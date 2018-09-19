package com.hcmony.test.concurrent;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcmony on 2017/9/11.
 */
public class AtomicIntegerTest {
	private volatile int value;
	private static final long valueOffset;
	private static final Unsafe unsafe = Unsafe.getUnsafe();
	static {
		try {
			valueOffset = unsafe.objectFieldOffset
					(AtomicInteger.class.getDeclaredField("value"));
		} catch (Exception ex) { throw new Error(ex); }
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	public static final boolean compareAndSet(int expect, int update) {
		return unsafe.compareAndSwapInt(AtomicIntegerTest.class, valueOffset, expect, update);
	}
	public static int getV(int a){
		for (int i = 0; i < a; i++) {
			i++;
			if(compareAndSet(i, i+1))
			return i;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(getV(2));
	}

}
