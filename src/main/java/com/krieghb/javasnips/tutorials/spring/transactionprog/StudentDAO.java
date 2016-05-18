package com.krieghb.javasnips.tutorials.spring.transactionprog;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
	/**
	 *  This is a method to be used to initialize the database
	 *  resources, such as connection.
	 */
	public void setDataSource(DataSource ds);
	
	/**
	 *  This is a method to be used to create a record in the Student 
	 *  and Marks tables.
	 */
	public void create(String name, Integer age, Integer marks, Integer year);
	
	/**
	 *   Same as create but returns the integer key of the insertion.
	 */
	public int insCreate(final String name, final Integer age, final Integer marks, final Integer year);
	
	/**
	 *  This is a method to be used to list down all the records from the Student
	 *  and Marks tables.
	 */
	public List<StudentMarks> listStudents();
	

}
