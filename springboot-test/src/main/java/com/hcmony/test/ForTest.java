package com.hcmony.test;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcmony on 2017/9/8.
 */
public class ForTest {
	int id ;
	String  name ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		for (String s:getSs()) {
			System.out.println(s);
		}
	}

	public static List<String>  getSs(){
		List<String> ss = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ss.add(""+i);
		}
		System.out.println(ss);
		return ss;

	}

	BeanNameAware beanNameAware;
	BeanFactoryAware beanFactoryAware;
	ApplicationContextAware applicationContextAware;
	MessageSourceAware messageSourceAware;
	ApplicationEventPublisherAware applicationEventPublisherAware;
	ResourceLoaderAware resourceLoaderAware;
}
