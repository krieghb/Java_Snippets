package com.krieghb.javasnips.tutorials.spring.inj_coll;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestCollection {
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("Beans/Beans_Collection.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_Collection.xml");
		
		JavaCollection myCollection = (JavaCollection) context.getBean("javaCollection");
		
		myCollection.getAddressList();
		myCollection.getAddressSet();
		myCollection.getAddressMap();
		myCollection.getAddressProp();
		
		((AbstractApplicationContext) context).close();
	}

}
