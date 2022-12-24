package com.gwit.tests;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gwit.base.BaseTest;
import com.gwit.pages.AccountPage;
import com.gwit.pages.HomePage;
import com.gwit.pages.LoginPage;
import com.gwit.utils.Utilities;

public class LoginTests extends BaseTest {
	
	public WebDriver driver;
	LoginPage lp;
	
	public LoginTests() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		lp = homePage.clickOnLogin();		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1,dataProvider="validSupplierTestData")
	public void verifyLoginwithValidCredentials(String email, String password) {
		//Reading email data from data provider
		lp.enterEmailAddress(email);
		lp.enterPassword(password);		
		AccountPage ap =lp.clickOnLOginButton();		
		Assert.assertTrue(ap.getDisplaySttausofAccountInfo());
				
		 
	}
	
	@DataProvider(name="validSupplierTestData")
	public Object[][] supplyTestData() {
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
		
	@Test(priority=2)
	public void verifyLoginwithInValidCredentials() {
		
		lp.enterEmailAddress(Utilities.generateEmailwitTimeStamp());
		lp.enterPassword(dataProp.getProperty("invalidpassword"));		
		lp.clickOnLOginButton();		
		String expectedInvalidLoginwarningText = dataProp.getProperty("expectedinvalidloginwarningtext");
		Assert.assertTrue(lp.getInvalidLoginWarningText().contains(expectedInvalidLoginwarningText), "Users are not on Invalid Login Page");
		
		
	}
	@Test(priority=3)
	public void verifyLoginwithInValidEmailValidPassword() {
				
		lp.enterEmailAddress(Utilities.generateEmailwitTimeStamp());
		lp.enterPassword("test123");		
		lp.clickOnLOginButton();		
		String expectedInvalidLoginwarningText = dataProp.getProperty("expectedInvalidLoginwarningTextWarningEmail");
		Assert.assertTrue(lp.getInvalidLoginWarningText().contains(expectedInvalidLoginwarningText), "Users are not on Invalid Login Page");
		
		
	}
	@Test(priority=4)
	public void verifyLoginwithValidEmailInValidPassword() {
		
		lp.enterEmailAddress("test52@tmail.com");
		lp.enterPassword(dataProp.getProperty("invalidpassword"));		
		lp.clickOnLOginButton();			
		String expectedInvalidLoginwarningText = dataProp.getProperty("expectedInvalidLoginwarningTextWarningEmail");
		Assert.assertTrue(lp.getInvalidLoginWarningText().contains(expectedInvalidLoginwarningText), "Users are not on Invalid Login Page");
		
		
	}
	@Test(priority=5)
	public void verifyLoginwithoutEmailandPassword() {
		
		lp.enterEmailAddress("");
		lp.enterPassword("");		
		lp.clickOnLOginButton();		
		String expectedInvalidLoginwarningText = dataProp.getProperty("expectedInvalidLoginwarningTextWarningEmail");
		Assert.assertTrue(lp.getInvalidLoginWarningText().contains(expectedInvalidLoginwarningText), "Users are not on Invalid Login Page");
		
		
	}
	
	
}
