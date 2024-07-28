package dddUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

// This is an Unit test to check the connectivity is working or not
public class DBConnectionTest {
	
	String createTable = "create table february2024 ("
									+ "userId varchar (25) not null primary key, "
									+ "password varchar (25));";
	
	
	String insertData = "insert into february2024 (userId, password)values"
									+ "('Narima.tushty@gmail.com', 'Login@123456789'),"
									+ "('shampa.afroz82@gmail.com', 'ShumuLove$2024&'),"
									+ "('S_1999', 'Silia19??abcsilia');"; 
	
	
	String runTheQuery = "select * from february2024";
	
	@Test
	public void dbConnection() throws SQLException {
		/*
		 The steps need to be follow:
		 - Step 1: Register the DB by DriverManager from java.sql
		 - We don't need to register separately -- when we added dependency
		 - Step 2: Connection from java.sql 
		 - Step 3: Statement from java.sql, accept the query and execute the query
		 - Step 4: ResultSet from java.sql
		 */
		
		/*
		 To Find the local host, user id etc from below:
		 PostgreSQL16 --- right click -- properties -- connection	
		 */
				
		// getConnection returns the Connection
		// https://jdbc.postgresql.org/documentation/use/
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees_db", "postgres", "hr");
		
		// createStatement() return Statement object
		Statement statement = connection.createStatement();
		statement.execute(runTheQuery);
		
		// after execution, the result we got can be returned by statement object. 
		ResultSet resultSet = statement.getResultSet();
		resultSet.next();
		// resultSet.getString(1); // it will read String from Column 1
		System.out.println(resultSet.getString(2));
		
		// Releases this Connection object's database and JDBC resources immediately instead of waiting for them to be automatically released. 
		connection.close();
		
	}

}
