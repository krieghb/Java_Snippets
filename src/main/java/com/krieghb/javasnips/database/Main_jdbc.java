package com.krieghb.javasnips.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.StringBuilder;


/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class Main_jdbc {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String main_Schema = "v_test";
    private String main_Table = "v_sng";
    private String main_SchemTab = main_Schema + "." + main_Table;

    private String colum_list[] = new String[] {"v_sng_c_head", "v_sng_c_dur", "v_sng_c_comp-l", "v_sng_c_comp-f"};
    private String input_list[] = new String[] {"Test Header", "13:25", "Tow", "Mike"};
    private int col_size = colum_list.length;

    private int counter = 1;


    private StringBuilder default_qs = new StringBuilder("?");
    private StringBuilder colum_Str = new StringBuilder("");





    public void readDataBase() throws Exception {

        String url = "jdbc:mysql://localhost:3306/";// + main_Schema;
        String username = "root";
        String password = "admin123";




        Database_MySQL db = new Database_MySQL();

        db.connectToDb(url, username, password);
        db.readFromDb("jdbc:mysql://localhost/" + main_Schema + "?" + "user=root&password=admin123");
        db.disconnectFromDb();

		  /*

		  System.out.println("Loading driver...");

		  try {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Driver loaded!");
		  } catch (ClassNotFoundException e) {
		      throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		  }

		  System.out.println("Connecting database...");

		  try (Connection connection = DriverManager.getConnection(url, username, password)) {
		      System.out.println("Database connected!");
		  } catch (SQLException e) {
		      throw new IllegalStateException("Cannot connect the database!", e);
		  }


	    try {
	      // This will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");

	      // Setup the connection with the DB
	      connect = DriverManager.getConnection("jdbc:mysql://localhost/" + main_Schema + "?" + "user=root&password=admin123");

	      // Statements allow to issue SQL queries to the database
	      statement = connect.createStatement();

	      // Result set get the result of the SQL query
	      resultSet = statement.executeQuery("select * from " + main_SchemTab);
	      writeResultSet(resultSet);



//	      // PreparedStatements can use variables and are more efficient
	      for (int i = 0; i < col_size - 1; i++)
	      {
	    	  default_qs.append(", ?");
	      }
//	      preparedStatement = connect.prepareStatement("insert into " + main_SchemTab + " values (default, ?, ?, ?, ?)");

	      System.out.print("");


	      preparedStatement = connect.prepareStatement("insert into " + main_SchemTab + " values (default, " + default_qs + ")");
//
//	      // "myuser, webpage, datum, summery, COMMENTS from feedback.comments");
//	      // Parameters start with 1

	      for (int i = 0; i < col_size; i++,counter++)
	      {
	    	  System.out.println(counter + "  " + colum_list[i]);
	    	  preparedStatement.setString(counter, input_list[i]);
	      }
	      preparedStatement.executeUpdate();

//	      preparedStatement.setString(1, "Test Name");
//	      preparedStatement.setString(2, "Tes");
//	      preparedStatement.setString(3, "Test District");
////	      preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//	      preparedStatement.setString(4, "123456");
////	      preparedStatement.setString(5, "TestComment");
//	      preparedStatement.executeUpdate();

//	      preparedStatement = connect.prepareStatement("SELECT Name, CountryCode, District, Population from " + main_SchemTab);
	      colum_Str.append("SELECT ");
	      for (int i = 0; i < col_size; i++)
	      {
	    	  colum_Str.append("`" + colum_list[i] + "`");
	    	  if (i != (col_size - 1))
	    		  colum_Str.append(", ");
	      }

	      colum_Str.append(" from " + main_SchemTab);

	      System.out.println("*****     '" + colum_Str.toString() + "'    *****");
//
	      preparedStatement = connect.prepareStatement(colum_Str.toString());

	      // Result set get the result of the SQL query

	      resultSet = preparedStatement.executeQuery();
//	      resultSet = statement.executeQuery("select * from " + main_SchemTab);
	      writeResultSet(resultSet);
	//
//	      // Remove again the insert comment
//	      preparedStatement = connect.prepareStatement("delete from feedback.comments where myuser= ? ; ");
//	      preparedStatement.setString(1, "Test");
//	      preparedStatement.executeUpdate();
//
//	      resultSet = statement
//	      .executeQuery("select * from feedback.comments");
//	      writeMetaData(resultSet);

	    } catch (Exception e) {
	    	System.out.println("Hi \n\n");
	      throw e;
	    } finally {
	      close();
	    }
*/
    }





//	  private void writeMetaData(ResultSet resultSet) throws SQLException {
//	    //   Now get some metadata from the database
//	    // Result set get the result of the SQL query
//
//	    System.out.println("The columns in the table are: ");
//
//	    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
//	    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
//	      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
//	    }
//	  }


    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            // No longer empty.
        }
    }

}
