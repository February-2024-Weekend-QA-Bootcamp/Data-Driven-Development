package pages;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseUtil.BaseClass;
import dataTestObject.User;
import queries.UserQueries;


public class LoginByMultipleDataTest extends BaseClass {
	
	@DataProvider (name = "users_obj")
	public Object[][] getUserObjects(){
		List<User>list = UserQueries.getUsers();		
		Object[][]objects = new Object[list.size()][];
		for(int i =0; i<list.size(); i++ ) {
			objects[i]=new Object [] {list.get(i)};
		}
		return objects;		
	}
	
	@DataProvider(name = "users_iterator")
	public Iterator<User> getStudentIterator(){
		List<User>list = UserQueries.getUsers();
		return list.iterator();
	}
	
	@Test (dataProvider = "users_iterator")
	public void loginTest(User user) {
		lmd.validateLogoAndTitle();
		lmd.validateLogInModal();
		lmd.validateUserId(user.getUserId());
		lmd.validatePassword(user.getPassword());
		lmd.validateCheckBox();
		lmd.validateLogin();
		lmd.landingOnMultiFactorAuthentication();
	}

}
