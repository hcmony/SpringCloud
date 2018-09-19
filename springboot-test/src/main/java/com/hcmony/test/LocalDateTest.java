package com.hcmony.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/05/11 15:29
 */
public class LocalDateTest {
	private static AtomicLong atomicLong = new AtomicLong();
	public static void main(String[] args)throws Exception {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						long a = System.currentTimeMillis();
						Thread.sleep(100);
						long b = System.currentTimeMillis();
						atomicLong.getAndSet(b-a);
					}catch (Exception e){

					}

				}
			}).start();
		}
		System.out.println(atomicLong.intValue());
	}
}
