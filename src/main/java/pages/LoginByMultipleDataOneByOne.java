package pages;

import static common.CommonActions.clickElement;
import static common.CommonActions.elementDisplayed;
import static common.CommonActions.elementEnabled;
import static common.CommonActions.elementSelected;
import static common.CommonActions.inputText;
import static common.CommonActions.pause;
import static common.CommonActions.validationOfHeader;
import static common.CommonActions.verifyCurrentUrl;
import static common.CommonActions.verifyTextOfTheWebElement;
import static common.CommonActions.verifyTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginByMultipleDataOneByOne {
	WebDriver driver;

	public LoginByMultipleDataOneByOne(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement mainLogo;
	
	@FindBy(id = "cms-homepage-login-logo")
	WebElement loginLogo;
		
	@FindBy(name = "user-d")
	WebElement userId;
	
	@FindBy (how = How.NAME, using = "pass-d")
	WebElement password;
	
	@FindBy(xpath = "//label[@id='cms-label-tc']")
	WebElement checkBox;
	
	@FindBy (id = "cms-login-submit")
	WebElement login;
	
	@FindBy(xpath = "//h3[contains(text(), 'Authentication')]")
	WebElement multiFactorAuthentication;
	
	public void validateLogoAndTitle() {
		elementDisplayed(mainLogo);
		verifyTitle(driver, "CMS Enterprise Portal");		
		pause(3);
	}
	
	public void validateLogInModal() {
		elementDisplayed(loginLogo);
		pause(3);
	}
	
	public void validateUserId(String uId) {
		elementDisplayed(userId);
		inputText(userId, uId);
		pause(3);
	}
	
	public void validatePassword(String pwd) {
		elementDisplayed(password);
		inputText(password, pwd);
		pause(3);
	}
	
	
	public void validateCheckBox() {
		elementSelected(checkBox);
		clickElement(checkBox);
		pause(3);
	}
	
	public void validateLogin() {
		elementEnabled(login);
		verifyTextOfTheWebElement(login, "Login");
		clickElement(login);
		pause(3);
	}
	
	public void landingOnMultiFactorAuthentication() {
		verifyTitle(driver, "CMS Enterprise Portal");
		verifyCurrentUrl(driver, "https://portal.cms.gov/portal/");
		validationOfHeader(multiFactorAuthentication, "Multi-factor Authentication");
		pause(3);
	}

}
