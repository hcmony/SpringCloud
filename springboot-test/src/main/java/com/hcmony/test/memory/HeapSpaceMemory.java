package com.hcmony.test.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p>
 *     java.lang.OutOfMemoryError:Javaheapspace：这种是java堆内存不够，
 *     一个原因是真不够（如递归的层数太多等），
 *     另一个原因是程序中有死循环；
 *　　   如果是java堆内存不够的话，可以通过调整JVM下面的配置来解决：
 *　　   -Xms3062m
 *　　   -Xmx3062m
 * </p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/09/04 14:44
 */
public class HeapSpaceMemory {

	public static void main(String[] args) {
		List<byte[]> list = new ArrayList<>();
		int i=0;
		while(true){
			list.add(new byte[5*1024*1024]);
			System.out.println("分配次数："+(++i));
		}
	}
}

