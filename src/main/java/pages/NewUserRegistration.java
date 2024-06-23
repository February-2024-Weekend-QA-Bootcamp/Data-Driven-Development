package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static common.CommonActions.*;
import static common.CommonWaits.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewUserRegistration {

	public WebDriver driver;
	JavascriptExecutor js;

	public NewUserRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth']//parent::a//parent::div//parent::nav")
	WebElement logo;
	
	@FindBy(xpath = "//a[contains(text(), 'New')]")
	WebElement newUserRegistration;
	
	@FindBy(xpath = "//div[@class='ng-input']")
	WebElement selectYourApplication;

	@FindBy(id = "textSearch")
	WebElement textSearch;
	
	// @FindBy(xpath = "//a[text()='Cancel']//parent::div[@class='col-xs-12 col-sm-2 col-md-1 cms-agree-item cms-cancel']")
	// @FindBy(xpath = "(//a[text()='Cancel'])[1]")
	@FindBy(xpath = "(//a[@class='cms-p-reg-register-cancel'])[1]")
	WebElement stepOneCancel;
	
	@FindBy(xpath = "//p[contains(text(), ' Step #')]")
	WebElement stepOneHeader;

	@FindBy(xpath = "//p[contains(text(), ' Step 1 of 3')]")
	WebElement stepOneSubHeader;
	
	@FindBy(id = "cms-tos-reg")
	WebElement agreeToTheTerms;

	@FindBy(name = "termsAndCondNext")
	WebElement StepOneNextButton;
	
	@FindBy(id = "cms-register-information")
	WebElement stepTwoHeader;

	@FindBy(xpath = "//p[contains(text(), ' Step 2 of 3')]")
	WebElement stepTwoSubHeader;
	
	@FindBy(xpath = "(//p[contains(text(), 'All f')])[1]")
	WebElement stepTwoOtherHeader;

	@FindBy(id = "cms-newuser-firstName")
	WebElement firstName;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderFirstName;
	
	@FindBy(xpath = "//a[contains(text(), 'First Name')]")
	WebElement firstNameErrorMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must be alphabetic characters.']")
	WebElement alphabeticCharactersErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-middleName")
	WebElement middleName;

	@FindBy(id = "cms-newuser-lastName")
	WebElement lastName;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderLastName;
	
	@FindBy(xpath = "//a[contains(text(), 'Last Name')]")
	WebElement lastNameErrorMsgTopOfThePage;

	@FindBy(id = "cms-newuser-nameSuffix")
	WebElement suffix;
	
	@FindBy(xpath = "//select[@id='cms-newuser-nameSuffix']/option")
	List <WebElement> suffixList;
	
	@FindBy(id = "cms-newuser-birthMonth")
	WebElement birthMonth;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthMonth;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Month')]")
	WebElement birthMonthErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthMonth']/option")
	List<WebElement> birthMonthList;

	@FindBy(id = "cms-newuser-birthDate")
	WebElement birthDate;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthDate;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Date')]")
	WebElement birthDateErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthDate']/option")
	List<WebElement> birthDateList;

	@FindBy(id = "cms-newuser-birthYear")
	WebElement birthYear;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderBirthYear;
	
	@FindBy(xpath = "//a[contains(text(), 'Birth Year')]")
	WebElement birthYearErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-birthYear']/option")
	List<WebElement> birthYearList;
	
	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item']")
	WebElement usBasedAddress;

	@FindBy(xpath = "//label[@class='check-radio']//parent::li[@class='cms-radio-item2']")
	WebElement nonUsBasedAddress;

	@FindBy(id = "cms-newuser-homeAddressLine1")
	WebElement addressLine1;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderHomeAddressLine1;
	
	@FindBy(xpath = "//a[contains(text(), 'Home Address Line1')]")
	WebElement homeAddressLine1ErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//span[text()='Must be alphanumeric characters.']")
	WebElement alphanumericCharactersErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usAddress2")
	WebElement addressLine2;

	@FindBy(id = "cms-newuser-usCity")
	WebElement city;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderCity;
	
	@FindBy(xpath = "//a[contains(text(), 'City')]")
	WebElement cityErrorMsgTopOfThePage;

	@FindBy(id = "cms-newuser-usState")
	WebElement state;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderState;
	
	@FindBy(xpath = "//a[contains(text(), 'State')]")
	WebElement stateErrorMsgTopOfThePage;
	
	@FindBy(xpath = "//select[@id='cms-newuser-usState']/option")
	List<WebElement> stateList;

	@FindBy(name = "cms-newuser-zipcode")
	WebElement zipCode;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderZipCode;
	
	@FindBy(xpath = "//a[contains(text(), 'Zip Code')]")
	WebElement zipCodeMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP Code.']")
	WebElement numericZipCodeErrorMsgUnderTheField;

	@FindBy(xpath = "//span[text()='Must be a valid numeric ZIP+4 Code.']")
	WebElement numericZipPlus4CodeErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usZipcodeExt")
	WebElement zipCodeExt;

	@FindBy(id = "cms-newuser-usEmail")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderEmail;
	
	@FindBy(xpath = "//a[contains(text(), 'Email Address')]")
	WebElement emailAddressMsgTopOfThePage;

	@FindBy(id = "cms-newuser-usConfirmEmail")
	WebElement confirmEmail;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderConfirmEmail;
	
	@FindBy(xpath = "//a[contains(text(), 'Confirm Email Address')]")
	WebElement confirmEmailAddressMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Must match Email Address values.']")
	WebElement mismatchEmailAddressErrorMsgUnderTheField;

	@FindBy(id = "cms-newuser-usPhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//span[contains(text(), 'Required field.')]")
	WebElement requiredFieldErrorMsgUnderPhoneNumber;
	
	@FindBy(xpath = "//a[contains(text(), 'Phone Number')]")
	WebElement phoneNumberMsgTopOfThePage;

	@FindBy(xpath = "//span[text()='Phone Number must not start with a 1 or 0.']")
	WebElement phoneNumberNotStartWithErrorMsgUnderTheField;

	@FindBy(xpath = "//span[text()='Must be a valid Phone Number.']")
	WebElement validPhoneNumberErrorMsgUnderTheField;

	@FindBy(id = "step2NextButton")
	WebElement nextButtonStep2;
	
	@FindBy(xpath = "(//a[contains(text(), 'Cancel')])[2]")
	WebElement stepTwoCancel;
	
	@FindBy(id = "step2BackButton")
	WebElement stepTwoBackButton;
		
	
	
	public void landingOnhomePageAndDirectingToNewUserRegistration() {
		elementDisplayed(logo);
		verifyTitle(driver, "CMS Enterprise Portal");
		elementEnabled(newUserRegistration);
		verifyTextOfTheWebElement(newUserRegistration, "New User Registration");
		clickElement(newUserRegistration);
		pause(3);	
	}
	
	public void stepOneClickOnCancelButtonDirectToHomePage() {
		clickElement(selectYourApplication);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		elementEnabled(stepOneCancel);
		verifyTextOfTheWebElement(stepOneCancel, "Cancel");
		usingJavascriptExecutor(driver, "arguments[0].scrollIntoView(true)", stepOneCancel);
		pause(3);
		usingJavascriptExecutor(driver, "arguments[0].click()", stepOneCancel);
		//clickElement(stepOneCancel);
		pause(3);
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/");
		verifyTitle(driver, "CMS Enterprise Portal");
		pause(3);
	}
	
	public void selectApplicationOnStepOneAndNavigateToStepTwo() {
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/newuserregistration");
		validationOfHeader(stepOneHeader, "Step #1: Select Your Application");
		validationOfSubHeader(stepOneSubHeader, "Step 1 of 3 - Select your application from the dropdown. You will then need to agree to the terms & conditions.");
		pause(3);
		clickElement(selectYourApplication);
		inputTextThenClickEnter(textSearch, "BCRS Web");
		elementSelected(agreeToTheTerms);
		waitThenClick(driver, agreeToTheTerms);
		pause(3);
		elementEnabled(StepOneNextButton);
		verifyTextOfTheWebElement(StepOneNextButton, "Next");
		clickElement(StepOneNextButton);
		pause(3);	
	}
	
	public void stepTwoTitleAndHeaderValidation() {
		verifyTitle(driver, "CMS Enterprise Portal - New User Registration");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/newuserregistration");
		validationOfHeader(stepTwoHeader, "Step #2: Register Your Information");
		validationOfSubHeader(stepTwoSubHeader, "Step 2 of 3 - Please enter your personal and contact information.");
		validationOfOtherHeader(stepTwoOtherHeader, "All fields are required unless marked (optional).");
		pause(3);
	}
	
	
	
	

}
