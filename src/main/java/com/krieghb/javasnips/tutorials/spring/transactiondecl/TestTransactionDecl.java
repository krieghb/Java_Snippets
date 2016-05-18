package com.krieghb.javasnips.tutorials.spring.transactiondecl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestTransactionDecl {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/Beans/Beans_TransactionDecl.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_TransactionDecl.xml");
		
		StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");
		
		System.out.println("----------Records creation----------" );
	    studentJDBCTemplate.create("Leslie", 11, 99, 2015);
	    studentJDBCTemplate.create("Sandy", 20, 97, 2014);
	    studentJDBCTemplate.create("Crystal", 25, 100, 2013);
	    
	    System.out.println("----------Listing all the records------------" );
	    List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
	    for (StudentMarks record : studentMarks) {
	    	System.out.println(record.printStudent());
	    }
	    
	}

}
