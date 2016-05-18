package com.krieghb.javasnips.utilities;

import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Utility {
	
	public Utility() {
		
	}

	public PreparedStatementCreator prepareStatement(String SQL1, String name, int age) {
		
		PreparedStatementCreator myPSCreator = new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL1, new String[] {"id"});
				//  Setting the name field (2nd field of the 3 fields (ID being 1st at 0)).
				ps.setString(1, name);
				//  Setting the age field (3rd field of the 3 fields (ID being 1st at 0)).
				ps.setInt(2, (int) age);
				return ps;
			}
		};
		
		
		return myPSCreator;
		
	}

}
