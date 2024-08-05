package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class LoginTest extends BaseClass {
	@Test
	public void loginTest() {
		login.validateLogoAndTitle();
		login.validateLogInModal();
		login.validateUserId("Narima.tushty@gmail.com");
		login.validatePassword("Login@123456789");
		login.validateCheckBox();
		login.validateLogin();
		login.landingOnMultiFactorAuthentication();
	}

}
