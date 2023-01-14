package com.gwit.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gwit.base.BaseTest;
import com.gwit.pages.AccountCreatedPage;
import com.gwit.pages.HomePage;
import com.gwit.pages.RegistrationPage;
import com.gwit.utils.Utilities;

public class RegisterTests extends BaseTest {
	RegistrationPage rp;
	public WebDriver driver;
	
	public RegisterTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		rp = homePage.clickOnRegisterLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterAccountWithMandatoryFields() {
		
		rp.enterFirstNameOnRegistrationPage("TestFirstName");		
		rp.enterLastNameOnRegistrationPage("TestLastNameTwo");		
		rp.enterEmailOnRegistrationPage(Utilities.generateEmailwitTimeStamp());		
		rp.enterPhoneOnRegistrationPage("1234567890");		
		rp.enterPasswordOnRegistrationPage("12345");		
		rp.enterConfirmPasswordOnRegistrationPage("12345");		
		rp.clickonPrivacyPolicyOnRegistrationPage();	
		AccountCreatedPage acp = rp.clickonContinuButtonOnRegistrationPage();	
		//To verify account created message		
		Assert.assertTrue(acp.getHeadingFromAccountCreatedPage().contains("Your Account Has Been Created!"), "Account Might not created, Please check");
		
		
	}
	@Test(priority=2)
	public void verifyRegisterAccountWithAllFields() {
		
		
		rp.enterFirstNameOnRegistrationPage("TestFirstName");
		rp.enterLastNameOnRegistrationPage("TestLastName");
		rp.enterEmailOnRegistrationPage(Utilities.generateEmailwitTimeStamp());
		rp.enterPhoneOnRegistrationPage("1234567890");
		rp.enterPasswordOnRegistrationPage("12345");
		rp.enterConfirmPasswordOnRegistrationPage("12345");
		rp.clickonSubscribtionOnRegistrationPage();
		rp.clickonPrivacyPolicyOnRegistrationPage();
		AccountCreatedPage acp = rp.clickonContinuButtonOnRegistrationPage();		
		//To verify account created message		
		Assert.assertTrue(acp.getHeadingFromAccountCreatedPage().contains("Your Account Has Been Created!"), "Account Might not created, Please check");
		
		
	}
	
	@Test(priority=3)
	public void verifyRegisterAccountWithExistingEmailAccount() {
		
		
		rp.enterFirstNameOnRegistrationPage("TestFirstName");
		rp.enterLastNameOnRegistrationPage("TestLastName");
		rp.enterEmailOnRegistrationPage(prop.getProperty("validemail"));
		rp.enterPhoneOnRegistrationPage("1234567890");
		rp.enterPasswordOnRegistrationPage("12345");
		rp.enterConfirmPasswordOnRegistrationPage("12345");
		rp.clickonSubscribtionOnRegistrationPage();
		rp.clickonPrivacyPolicyOnRegistrationPage();
		rp.clickonContinuButtonOnRegistrationPage();		
		//To verify account created message		
		Assert.assertTrue(rp.getExistingEmailAlertTextOnREgistrationPage().contains("Warning: E-Mail Address is already registered!"), "Account registered with existing email, Please check");
		
		
	}
	
	@Test(priority=4)
	public void verifyRegisterAccountWithoutfillingAnydetails() {
		
		
		rp.clickonContinuButtonOnRegistrationPage();		
		Assert.assertTrue(rp.getPrivacyPolicyWarningOnREgistrationPage().contains("Warning: You must agree to the Privacy Policy!"), "PLease check prinvacy policy warning expected");
		String expectedFirstNameFieldValidation = "First Name must be between 1 and 32 characters!";
		Assert.assertEquals(rp.getFirstNameValidationMessageOnREgistrationPage(), expectedFirstNameFieldValidation, "Validation does not match for Firstname, Please review");
		String expectedLastNameFieldValidation = "Last Name must be between 1 and 32 characters!";
		Assert.assertEquals(rp.getLastNameValidationMessageOnREgistrationPage(), expectedLastNameFieldValidation, "Validation does not match for Last Name, Please review");
		String expectedEmailFieldValidation = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(rp.getEmailValidationMessageOnREgistrationPage(), expectedEmailFieldValidation, "Validation does not match for Email, Please review");
		
	}

}
