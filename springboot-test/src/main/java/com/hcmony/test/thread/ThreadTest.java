package com.hcmony.test.thread;

/**
 * Thread 测试类
 * Created by hcmony on 2017/8/31.
 */
public class ThreadTest {

	//多线程要执行的方法
	public static void getInt(int i){
		System.out.println(Thread.currentThread().getName()+"-"+i);
	}

	static  class ThreadTest1{
		public static void main(String[] args) throws Exception{
			//开启一个新线程去做另外的事情，比如我们公司是通过api加载其它的数据。
			new Thread(){
				@Override
				public void run() {
					for (int i=0;i<100000;i++) {
						try {
							getInt(i);
						}catch (Exception e){

						}
					}
				}
			}.start();

			//单线程要执行的方法
			for (int i=0;i<1000000;i++){
				System.out.println(i);
			}
		}
	}

	static class ThreadTest2{
		public static void main(String[] args) {
			for (int i = 0; i < 10; i++) {
				new Thread(""+i){
					@Override
					public void run() {
						System.out.println(Thread.currentThread().getName());
					}
				}.start();
			}
		}
	}

	static class ThreadTest3{
		public static void main(String[] args) throws Exception {
			Counter counter = new Counter();
			for (int i = 0; i < 1000; i++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						counter.add(1);
					}
				}).start();
			}
		}
	}

	public static class Counter {
		protected volatile long count = 0;
		public void add(long value){
			this.count = this.count + value;
			System.out.println(count);
		}

	}

}
