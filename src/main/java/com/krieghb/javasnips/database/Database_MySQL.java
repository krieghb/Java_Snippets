package com.krieghb.javasnips.database;

import java.sql.*;

/**
 * Created by krido02 on 5/18/2016.
 *
 *
 */
public class Database_MySQL {

	/*
	 * Test of it again!
	 */

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private static String classDriver = "com.mysql.jdbc.Driver";

    private boolean isConnected = false;

    public Database_MySQL() {

        this(classDriver);

    }

    public Database_MySQL(String cDriver) {
        classDriver = cDriver;
        try {
            Class.forName(classDriver);
            System.out.println("Driver loaded!");
        }
        catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
    }


    /*
     *
     *
     */
    public boolean connectToDb (String url, String username, String password) {

        System.out.println("Connecting database...");

        try {
            connect = DriverManager.getConnection(url, username, password);

            isConnected = true;
            System.out.println("Database connected!");

        }
        catch (SQLException e) {
            isConnected = false;
            throw new IllegalStateException("Cannot connect the database!", e);
        }


        return isConnected;
    }


    public boolean disconnectFromDb() {

        try{
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }

            System.out.println("Database disconnected!");
        }
        catch (SQLException e) {
            throw new IllegalStateException("Failed to disconnect from the database!", e);
        }

        isConnected = false;

        return isConnected;
    }



    public void readFromDb(String mainSchemaTable) {

        // Statements allow to issue SQL queries to the database
        try {
            statement = connect.createStatement();

            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from " + mainSchemaTable);

            writeResultSet(resultSet);
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void insertToDb(String mainSchemaTable, String[] columnList, String[] inputList) {

        int columnSize = columnList.length;
        int counter = 1;
        StringBuilder defaultQs = new StringBuilder("?");

        // PreparedStatements can use variables and are more efficient
        for (int i = 0; i < columnSize - 1; i++)
        {
            defaultQs.append(", ?");
        }

        System.out.print("");

        try{
            preparedStatement = connect.prepareStatement("insert into " + mainSchemaTable + " values (default, " + defaultQs + ")");

            for (int i = 0; i < columnSize; i++,counter++)
            {
                System.out.println(counter + "  " + columnList[i]);
                preparedStatement.setString(counter, inputList[i]);
            }
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            throw new IllegalStateException("Failed to insert into the database!", e);
        }
    }


    /*
     *
     */
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String head = resultSet.getString("v_sng_c_head");
            String dur = resultSet.getString("v_sng_c_dur");
            String last = resultSet.getString("v_sng_c_comp-l");
            String first = resultSet.getString("v_sng_c_comp-f");



            System.out.printf("%-35s", "Head:  " + head);
            System.out.printf("      %-17s", "Dur:  " + dur);
            System.out.printf("      %-30s", "Last:  " + last);
            System.out.printf("      %-30s\n", "First:  " + first);



        }
    }

}
