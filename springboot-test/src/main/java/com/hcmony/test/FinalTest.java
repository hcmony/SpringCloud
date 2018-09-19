package com.hcmony.test;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by hcmony on 2017/9/7.
 */
public class FinalTest {

	public static void main(String[] args) throws Exception{
		long start  = System.currentTimeMillis();
		ForTest test = null;
		int num ;
		List<ForTest> list = new ArrayList<ForTest>();
		for (int i = 0; i <20000000 ; i++) {
			 test = new ForTest();
			num = i;
			test.setId(i);
			test.setName(UUID.randomUUID().toString()+UUID.randomUUID().toString()+UUID.randomUUID().toString());
			list.add(test);
			if (i==10000000-1){
				System.out.println("totalMemory:"+Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
				System.out.println("freeMemory:"+Runtime.getRuntime().freeMemory()/(1024*1024)+"M");
				System.out.println("maxMemory:"+Runtime.getRuntime().maxMemory()/(1024*1024)+"M");
			}
		}
		System.out.println(""+Runtime.getRuntime().totalMemory()/(1024*1024)+"M");
		System.out.println(""+Runtime.getRuntime().freeMemory()/(1024*1024)+"M");
		System.out.println(""+Runtime.getRuntime().maxMemory()/(1024*1024)+"M");
		System.out.println(System.currentTimeMillis()-start);
	}
}
