package com.hcmony.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by hcmony on 2017/9/6.
 */
public class MyLock {

	private boolean isLocked      = false;

	private Thread lockingThread = null;

	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}

	public synchronized void unlock(){

		if(this.lockingThread != Thread.currentThread()){
			throw new IllegalMonitorStateException(
				"Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
	}

	static class LockTest{
		int num = 0;

		MyLock myLock = new MyLock();
		void addNum() throws Exception{
			myLock.lock();
			for (int i = 0; i < 10; i++) {
				num++;
			}
			myLock.unlock();
		}

		public static void main(String[] args)throws Exception {
			LockTest lockTest = new LockTest();
			for (int i = 0; i < 100; i++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							lockTest.addNum();
						}catch (Exception e){

						}

					}
				}).start();
			}
			Thread.sleep(500);
			System.out.println(lockTest.num);
		}
	}
	AtomicLong atomicLong = new AtomicLong();

}
