package com.hcmony.test;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Synchronized 测试类
 * Created by hcmony on 2017/9/6.
 */
public class SynchronizedTest {
	public static class Counter implements Runnable {
		protected  long count = 0;

		@Override
		public void run() {
			add();
		}


		public  void add(){
			synchronized (this) {
				for (int i = 0; i <1000 ; i++) {
					count++;
					System.out.println(Thread.currentThread().getName());
				}
			}
		}
	}

	public static void main(String[] args) throws  Exception{
		Counter counter = new Counter();
		for (int i = 0; i < 100; i++) {
			new Thread(counter).start();
		}
		System.out.println("==============================");
		Thread.sleep(1000);
		System.out.println(counter.count);

	}


	static  class Myclass implements Runnable{
		int i = 0;

		public synchronized void test1(){
			i++;
			System.out.println("test1"+Thread.currentThread().getName());
		}
		public  void test2(){
			synchronized(this){
				i--;
			System.out.println("test2"+Thread.currentThread().getName());
			}
		}

		@Override
		public void run() {
			test1();
			test2();
		}

		public static void main(String[] args)throws Exception {
			Myclass myclass = new Myclass();
			for (int i = 0; i < 1000; i++) {
				new Thread(myclass).start();
			}

			Thread.sleep(1000);
			System.out.println(myclass.i);
		}
	}

}
