package com.gwit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement eleAccountCreationHeading;
	
	public AccountCreatedPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getHeadingFromAccountCreatedPage() {
		
		String headingText = eleAccountCreationHeading.getText();
		return headingText;
		
	}

}
