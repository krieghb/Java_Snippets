package com.krieghb.javasnips.tutorials.spring.transactionprog;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void create(String name, Integer age, Integer marks, Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			String SQL1 = "INSERT into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1, name, age);
			
			//  Getting the latest student id to be used in marks table;
			String SQL2 = "SELECT max(id) from Student";
			int sid = jdbcTemplateObject.queryForInt(SQL2);
			
			String SQL3 = "INSERT into Marks(sid, marks, year) values(?, ?, ?)";
			jdbcTemplateObject.update(SQL3, sid, marks, year);
			
			System.out.println("Created Name:  " + name + ",  Age:  " + age);
			transactionManager.commit(status);
		}
		catch (DataAccessException e) {
			
			System.out.println("Error in creating record, rolling back.");
			transactionManager.rollback(status);
			throw e;
			
		}
		
		return;
	}
	

	public int insCreate(final String name, final Integer age, final Integer marks, final Integer year) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		int returnedKey = -1;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int sid;

		
		try {
			final String SQL1 = "INSERT into Student (name, age) values (?, ?)";
//			jdbcTemplateObject.update(SQL1, name, age);
			//  Using a prepared statement to update the record.
			jdbcTemplateObject.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(SQL1, new String[] {"id"});
					//  Setting the name field (2nd field of the 3 fields (ID being 1st at 0)).
					ps.setString(1, name);
					//  Setting the age field (3rd field of the 3 fields (ID being 1st at 0)).
					ps.setInt(2, (int) age);
					return ps;
				}
			}, keyHolder);
			
			sid = keyHolder.getKey().intValue();
			
			//  Getting the latest student id to be used in marks table;
//			String SQL2 = "SELECT max(id) from Student";
//			int sid = jdbcTemplateObject.queryForInt(SQL2);
			
			String SQL3 = "INSERT into Marks(sid, marks, year) values(?, ?, ?)";
			jdbcTemplateObject.update(SQL3, sid, marks, year);
			
			System.out.println("Created Name:  " + name + ",  Age:  " + age);
			transactionManager.commit(status);
		}
		catch (DataAccessException e) {
			
			System.out.println("Error in creating record, rolling back.");
			transactionManager.rollback(status);
			throw e;
			
		}
		
		
		return returnedKey;
		
	}
	
	public List<StudentMarks> listStudents() {
		String SQL = "SELECT * from Student, Marks WHERE Student.id=Marks.sid";
		
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,  new StudentMarksMapper());
		
		return studentMarks;
	}
	
	

}
