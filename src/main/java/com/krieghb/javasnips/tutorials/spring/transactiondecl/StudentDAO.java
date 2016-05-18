package com.krieghb.javasnips.tutorials.spring.transactiondecl;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
	
	/**
	 *  This is a method to be used to initialize the database resources.
	 *  (Connection)
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 *  This is a method to be used to create a record in the 
	 *  Student and Marks tables.
	 */
	public void create(String name, int age, int marks, int year);
		
	/**
	 *  This is a method to be used to list down all the records
	 *  from the Student and Marks tables
	 */
	public List<StudentMarks> listStudents();
	

}
