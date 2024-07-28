package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class LoginTest extends BaseClass {
	@Test
	public void loginTest() {
		lmd.validateLogoAndTitle();
		lmd.validateLogInModal();
		lmd.validateUserId("Narima.tushty@gmail.com");
		lmd.validatePassword("Login@123456789");
		lmd.validateCheckBox();
		lmd.validateLogin();
		lmd.landingOnMultiFactorAuthentication();
	}

}
