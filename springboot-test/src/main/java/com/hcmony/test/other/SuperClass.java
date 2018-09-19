package com.hcmony.test.other;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/09/10 19:07
 */
public class SuperClass {
	public SuperClass(){
		System.out.println("SuperClass");
	}

	static  class Clazz extends SuperClass{
		public Clazz(){
			//super();
			System.out.println("Clazz");
		}
	}

	public static void main(String[] args) {
		Clazz clazz = new Clazz();
		//System.out.println();
	}
}
