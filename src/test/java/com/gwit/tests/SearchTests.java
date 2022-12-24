package com.gwit.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gwit.base.BaseTest;
import com.gwit.pages.HomePage;
import com.gwit.pages.SearchPage;

public class SearchTests extends BaseTest {
	
public WebDriver driver;
	
public SearchTests() {
	super();
}
	
	@BeforeMethod
	public void setUp() {
		
		driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifywithExistingProductName() {
		HomePage hp = new HomePage(driver);		
		hp.enterInSearchTextBox("imac");	
		SearchPage sp = hp.clickOnSearchButton();		
		Assert.assertTrue(sp.statusofSearchResultOnSearchPage());
		
	}
	
	@Test(priority=2)
    public void verifywithnonExistingProductName() {
		HomePage hp = new HomePage(driver);		
		hp.enterInSearchTextBox("fitbit");
		SearchPage sp = hp.clickOnSearchButton();		
		Assert.assertTrue(sp.getSearchResultMessageOnSearchPage().contains("Fail There is no product that matches the search criteria."));
		
	}
	@Test(priority=3,dependsOnMethods= {"verifywithnonExistingProductName"})
    public void verifywithoutProductName() {		
		
		
		HomePage hp = new HomePage(driver);			
		SearchPage sp = hp.clickOnSearchButton();		
		Assert.assertTrue(sp.getSearchResultMessageOnSearchPage().contains("There is no product that matches the search criteria."));
		
	}

}
