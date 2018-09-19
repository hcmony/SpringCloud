package com.hcmony.test.memory;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p>
 *     java.lang.StackOverflowError
 *     【原因】：这也内存溢出错误的一种，即线程栈的溢出，要么是方法调用层次过多（比如存在无限递归调用），要么是线程栈太小。
 *　　   【解决】：优化程序设计，减少方法调用层次；调整-Xss参数增加线程栈大小。
 *  </p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/09/04 15:00
 */
public class StackOverflowError {

	int depth = 0;

	public void sofMethod(){
		depth ++ ;
		sofMethod();
	}

	public static void main(String[] args) {
		StackOverflowError error = null;
		error = new StackOverflowError();
		error.sofMethod();
	}
}
