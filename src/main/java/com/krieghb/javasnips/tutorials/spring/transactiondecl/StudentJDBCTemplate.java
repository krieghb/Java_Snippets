package com.krieghb.javasnips.tutorials.spring.transactiondecl;

import com.krieghb.snippets.utilities.Utility;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, int age, int marks, int year){
		int returnedKey = -1;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int sid;
		Utility myUtil = new Utility();
		
		
		
		try {
			
			String SQL1 = "insert into Student (name, age) values (?, ?)";
	        jdbcTemplateObject.update(myUtil.prepareStatement(SQL1, name, age), keyHolder);
	        sid = keyHolder.getKey().intValue();
	        
	        
	        String SQL2 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
	        jdbcTemplateObject.update( SQL2, sid, marks, year);

	        System.out.println("Created Name = " + name + ", Age = " + age);
	        // to simulate the exception.
	        throw new RuntimeException("Simulating Error condition") ;
	    } 
		catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
	        throw e;
		}
	}

	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";

	    List <StudentMarks> studentMarks=jdbcTemplateObject.query(SQL, 
	    new StudentMarksMapper());
	    return studentMarks;
	}
	
	
}
