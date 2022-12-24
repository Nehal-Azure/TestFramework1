package com.gwit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//a[@title ='My Account']")
	private WebElement eleMyAccountlink;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement eleLoginLink;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement eleRegisterLink;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement eleSearchBoxTextField;
	
	@FindBy(xpath="//div[@id='search']//button")
	private WebElement eleSearchBoxButton;
	
	//Homepage Constructor
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public void clickOnMyAccount() {
		eleMyAccountlink.click();
	}
	public LoginPage clickOnLogin() {
		eleLoginLink.click();
		return new LoginPage(driver);
		
	}
	
	public RegistrationPage clickOnRegisterLink() {
		eleRegisterLink.click();
		return new RegistrationPage(driver);
	}
	
	public void enterInSearchTextBox(String itemforSerach) {
		eleSearchBoxTextField.clear();
		eleSearchBoxTextField.sendKeys(itemforSerach);
	}
	
	public SearchPage clickOnSearchButton() {
		eleSearchBoxButton.click();
		return new SearchPage(driver);
	}
	
	


}
