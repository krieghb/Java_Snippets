package com.krieghb.javasnips.tutorials.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class TestJdbc {
	
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("/resources/Beans/Beans_Jdbc.xml");
		ApplicationContext context = new FileSystemXmlApplicationContext("/resources/Beans/Beans_Jdbc.xml");
		
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("----------Records Creation----------");
		studentJDBCTemplate.create("Kristin", 11);
		studentJDBCTemplate.create("Anne", 8);
//		studentJDBCTemplate.create("Sarah",  2);
		int sarahID = studentJDBCTemplate.newCreate("Sarah", 5);

		System.out.println("\n----------Listing Multiple Records----------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print(record.printStudent());
		}
		
		System.out.println("\n----------Updating Record with sarah's ID----------");
		studentJDBCTemplate.update(sarahID,  20);
		

		System.out.println("\n----------Listing Record with sarah's ID----------");
		Student student = studentJDBCTemplate.getStudent(sarahID);
		System.out.print("ID:  " + student.getId());
		System.out.print(", Name:  " + student.getName());
		System.out.print(", Age:  " + student.getAge());
		
		
		System.out.println("\n----------Deleting Created Records----------");
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		for (int i = 0; i < students.size(); i++) {
			if (i == (students.size() - 3)) {
				student3 = students.get(i);
			}
			else if (i == (students.size() - 2)) {
				student2 = students.get(i);
			}
			else if (i == (students.size() - 1)) {
				student1 = students.get(i);
			}
		}
		System.out.print("Student 1:  " + student3.printStudent());
		System.out.print("Student 2:  " + student2.printStudent());
		System.out.print("Student 3:  " + student1.printStudent());
		studentJDBCTemplate.delete(student1.getId());
		studentJDBCTemplate.delete(student2.getId());
		studentJDBCTemplate.delete(student3.getId());

	}

}
