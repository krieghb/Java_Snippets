package com.krieghb.javasnips.tutorials.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(String name, Integer age) {
		String SQL = "INSERT INTO Student (name, age) VALUES (?, ?)";
		
		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record name = " + name + ", Age = " + age);
		return;
	}
	
	public Student getStudent(Integer id) {
		String SQL = "SELECT * from Student where id = ?";
		
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
		return student;
	}
	
	public List<Student> listStudents() {
		String SQL = "SELECT * from student";
		
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}
	
	public void delete(Integer id) {
		String SQL = "DELETE from Student where id = ?";
		
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID: " + id);
		return;
	}
	
	public void update(Integer id, Integer age) {
		String SQL = "UPDATE Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID: " + id);
		return;
	}
	
	
	//  This create statement also returns the auto-generated id number of the insert.
	public int newCreate(final String name, final Integer age) {
		final String INSERT_SQL = "INSERT into Student (name, age) VALUES (?, ?)";
		//  To hold the returned key (inserted automatic increment)
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int idKey;
		//  Using a prepared statement to update the record.
		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] {"id"});
				//  Setting the name field (2nd field of the 3 fields (ID being 1st at 0)).
				ps.setString(1, name);
				//  Setting the age field (3rd field of the 3 fields (ID being 1st at 0)).
				ps.setInt(2, (int) age);
				return ps;
			}
		}, keyHolder);

		idKey =  keyHolder.getKey().intValue();
		

		System.out.println("Created Record name = " + name + ", Age = " + age + ";  with ID:  " + idKey);
		
		return idKey;
	}
	
	

}
