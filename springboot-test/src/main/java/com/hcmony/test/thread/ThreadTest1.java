package com.hcmony.test.thread;

import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/07/02 09:27
 */
public class ThreadTest1 {

	private static final Logger logger = Logger.getLogger(ThreadTest1.class);


	private static final ExecutorService pool =
			new ThreadPoolExecutor(30, 30, 0, TimeUnit.MILLISECONDS,
					new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());


	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList();
		for (int i=0;i<10000;i++){
			list.add(i);
		}

		List<Future> futures = Lists.newArrayList();
		AtomicLong atomicLong = new AtomicLong(0);
		AtomicInteger atomicInteger = new AtomicInteger(0);
		AtomicLong atomicLong1 = new AtomicLong(0);



		List<Integer> integerList = Lists.newArrayList();
		long begin = System.currentTimeMillis();

		for (Integer i:list){
			Future<Long> future = pool.submit(new Callable<Long>() {
				@Override
				public Long call() throws Exception {
					long start = System.currentTimeMillis();
					if (atomicLong.get()%1000==0){
						atomicInteger.incrementAndGet();
						//logger.info(atomicInteger.get()+"个");
					}
					integerList.add(i);
					Thread.sleep(3);
					return System.currentTimeMillis()-start;
				}
			});
			futures.add(future);
		}


		System.out.println("安全最终大小："+futures.size());
		System.out.print("不安全最终大小："+integerList.size());
		long time = 0;
		for (Future future:futures){
			try {
				time += (Long)future.get();
			}catch (Exception e){
			}
		}
		System.out.println("安全最终时间："+time);
		System.out.print("不安全最终时间："+(System.currentTimeMillis()-begin));
	}
}
