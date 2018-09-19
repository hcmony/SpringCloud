package com.hcmony.test.concurrent;



import java.util.concurrent.*;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/03/12 14:43
 */
public class QueueDemo {
	public static void main(String[] args) throws Exception{
		/*BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		for (int i = 0; i <11 ; i++) {
			queue.put("1="+i);
		}

		for (int i = 0; i <10 ; i++) {
			System.out.println(queue.take());
		}*/

		BlockingDeque queue1 = new LinkedBlockingDeque(20);

		for (int i = 0; i <11 ; i++) {
			queue1.put("1="+i);
		}
		queue1.addFirst("1=");
		queue1.addLast("2=");
		for (int i = 0; i <13 ; i++) {
			System.out.println(queue1.take());
		}
	}
}
