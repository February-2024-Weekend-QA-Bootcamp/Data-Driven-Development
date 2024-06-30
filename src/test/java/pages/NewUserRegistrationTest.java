package pages;

import org.testng.annotations.Test;
import baseUtil.BaseClass;

public class NewUserRegistrationTest extends BaseClass {
	
	@Test
	public void landingOnhomePageAndDirectingToNewUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
	}
	
	@Test
	public void stepOneClickOnCancelButtonDirectToHomePageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.stepOneClickOnCancelButtonDirectToHomePage();		
	}
		
	@Test
	public void stepTwoClickOnCancelButtonDirectToHomePageTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
		newUserRegistration.stepTwoTitleAndHeaderValidation();
		newUserRegistration.stepTwoClickOnCancelButtonDirectToHomePage();
	}
	
	@Test
	public void stepTwoNewUserRegistrationTest() {
		newUserRegistration.landingOnhomePageAndDirectingToNewUserRegistration();
		newUserRegistration.selectApplicationOnStepOneAndNavigateToStepTwo();
//		newUserRegistration.stepTwoTitleAndHeaderValidation();
//		newUserRegistration.firstNameValidation();
//		newUserRegistration.middleNameValidation();
//		newUserRegistration.lastNameValidation();
//		newUserRegistration.suffixValidation();
//		newUserRegistration.addressLine1Validation();
//		newUserRegistration.addressLine2Validation();
		newUserRegistration.cityValidation();
	}


}