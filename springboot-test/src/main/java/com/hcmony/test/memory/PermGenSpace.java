package com.hcmony.test.memory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p>
 *    java.lang.OutOfMemoryError:PermGenspace：这种是P区内存不够，可通过调整JVM的配置：
 *　　
 *　　【注】运行时的参数 -Xms10m -Xmx10m -XX:PermSize=1m -XX:MaxPermSize=2m
 *
 *　　JVM的Perm区主要用于存放Class和Meta信息的,Class在被Loader时就会被放到PermGenspace，
 * 这个区域成为年老代，GC在主程序运行期间不会对年老区进行清理，默认是64M大小，
 * 当程序需要加载的对象比较多时，超过64M就会报这部分内存溢出了，需要加大内存分配，一般128m足够。
 *
 *
 *
 * </p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/09/04 17:20
 */
public class PermGenSpace {
	public static void main(String[] args) {
		URL url = null;
		List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
		try {
			url = new File("D:\\tmp").toURI().toURL();
			URL[] urls = {url};
			while (true){
				ClassLoader loader = new URLClassLoader(urls);
				classLoaderList.add(loader);
				loader.loadClass("com.hcmony.test.memory.User");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
