package com.hcmony.test;

import java.util.concurrent.locks.Lock;

/**
 * Wait 与 Notify 与线程之间的通信 测试类
 * Created by hcmony on 2017/9/6.
 */
public class MyWaitNotify {
	SynchronizedTest.Myclass myclass = new SynchronizedTest.Myclass();
	boolean wasSignalled = false;

	public void doWait(){
		synchronized(myclass){
			if(!wasSignalled){
				try{
					System.out.println(Thread.currentThread().getName()+"doWait()-----------"+wasSignalled);
					wasSignalled = true;
					myclass.wait();
				} catch(InterruptedException e){

				}
			}
			//clear signal and continue running.
		}
	}

	public void doNotify(){
		synchronized(myclass){
			if(wasSignalled) {
				System.out.println(Thread.currentThread().getName()+"doNotify()---" + wasSignalled);
				wasSignalled = false;
				myclass.notify();
			}
		}
		//Lock
	}

	public static void main(String[] args) {
		MyWaitNotify my = new MyWaitNotify();
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					my.doWait();
					my.doNotify();
				}
			}).start();
		}
	}
}

