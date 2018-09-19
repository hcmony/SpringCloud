package com.hcmony.test;

/**
 * Created by hcmony on 2017/9/7.
 */
public class CowTest {

	/**
	 * 问题：一个农夫养了一头牛，三年后，这头牛每年会生出一头牛，
	 * 生出来的牛三年后又可以内年生出一头牛,不考虑牛的性别和生死
	 * 问农夫10年后有多少头牛？
	 */

	public static void main(String[] args) {
		int count = 0;
		for(int i=1;i<=10;i++){
			count+=getCount(i);
		}
		System.out.println("第10年后总共有："+ count+"头牛！");
	}
	public static int getCount(int n){
		int count = 0;
		if(n>=3){
			count = 1;
			for(int i=1;i<=n-2;i++){
				count += getCount(i);
			}
		}else{
			count = 1;
		}
		return count;
	}
}
