package com.gwit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement eleEmailTextbox;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement elePasswordTextbox;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement eleLoginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement eleActualInvalidLoginwarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String emailText) {
		eleEmailTextbox.clear();
		eleEmailTextbox.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		elePasswordTextbox.clear();
		elePasswordTextbox.sendKeys(passwordText);
	}
	public AccountPage clickOnLOginButton() {
		eleLoginButton.click();
		return new AccountPage(driver);
	}
	
	public String getInvalidLoginWarningText() {
		String text = eleActualInvalidLoginwarning.getText();
		return text;
	}

}
