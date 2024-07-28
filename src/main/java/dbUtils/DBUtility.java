package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import reports.Loggers;

public class DBUtility {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	ResultSetMetaData resultSetMetaData;
	
	public DBUtility() {
		getConnection();
	}
	
	private Connection getConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employees_db", "postgres", "hr");
			//Loggers.logTheTest("Database Connected ...");
		} catch (SQLException e) {
			Loggers.logTheTest("Database Connected cannot be established");
			e.printStackTrace();
		}
		return connection;
	}
	
	public void executeQuery(String query) {
		try {
			statement = connection.createStatement();
			statement.execute(query);
			//Loggers.logTheTest("Query executed ...");
		}catch (SQLException e) {
			Loggers.logTheTest("Statement Cannot be Created");
		}
	}
	
	public ResultSet getResultSet() {
		try {
			resultSet = statement.getResultSet();
			//Loggers.logTheTest("ResultSet Generated");
		} catch (SQLException e) {
			Loggers.logTheTest("ResultSet cannot be genrated");
		}
		return resultSet;
	}
	
	// ResultsetMetaData returns the types of data we received
	// We didn't used it
	public ResultSetMetaData getMetaData(ResultSet resultSet) {
		ResultSetMetaData resultSetMetaData = null;
		try {
			resultSetMetaData = resultSet.getMetaData();
			//Loggers.logTheTest("ResultSetMetaData Generated");
		}catch (SQLException e) {
			Loggers.logTheTest("ResultSetMetaData cannot be genrated");
		}
		return resultSetMetaData;
	}
	
	public void closeConnection() {
		try {
			connection.close();
			//Loggers.logTheTest("Connection Terminated");
		} catch (SQLException e) {
			Loggers.logTheTest("Connection is not Terminated");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
