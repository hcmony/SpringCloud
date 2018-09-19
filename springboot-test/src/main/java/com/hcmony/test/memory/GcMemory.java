package com.hcmony.test.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p>
 *    java.lang.OutOfMemoryError:GCoverheadlimitexceeded
 *　　【解释】：JDK6新增错误类型，当GC为释放很小空间占用大量时间时抛出；一般是因为堆太小，导致异常的原因，没有足够的内存。
 *　　【解决方案】：
 *　　1、查看系统是否有使用大内存的代码或死循环；
 *　　2、通过添加JVM配置，来限制使用内存：
 *　　-XX:-UseGCOverheadLimit
 * </p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/09/04 14:42
 */
public class GcMemory {

	private static List<User> userList = new ArrayList<User>();

	public static void main(String[] args) {
		while (true){
			int i = 0 ;
			User user = new User(i++, UUID.randomUUID().toString());
			userList.add(user);
		}
	}
}

