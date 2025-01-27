package queries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataTestObject.User;
import dbUtils.DBUtility;

public class UserQueries {
	
	static DBUtility dbUtility;
	
	public static void init() {
		dbUtility = new DBUtility();
		// When we will create object from DBUtility, the constructor of DBUtility will be initialized
		// Constructor contain getConnection() method to connect the database
	}
	
	public static List<User> getUsers(){
		init();
		String query = "select * from february2024;";
		dbUtility.executeQuery(query);
		ResultSet resultSet = dbUtility.getResultSet();
		
		List<User>listOfUsers = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				String userId = resultSet.getString(1);
				String password = resultSet.getString(2);
				User user = new User(userId, password);
				listOfUsers.add(user);
			}
			dbUtility.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUsers;
	}
}
