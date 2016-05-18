package com.krieghb.javasnips.tutorials.spring.transactionprog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class TestTransactionProg {
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("/resources/Beans/Beans_TransactionProg.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_TransactionProg.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("----------Creating Records----------");
		studentJDBCTemplate.create("Sarah", 11, 99, 2010);
		studentJDBCTemplate.create("Lisa", 20, 97, 2010);
		studentJDBCTemplate.create("Beth", 25, 100, 2011);
		
		

		System.out.println("----------Listing all the records----------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
	    for (StudentMarks record : studentMarks) {
	    	System.out.println(record.printStudent());
	    }
		
	}

}

