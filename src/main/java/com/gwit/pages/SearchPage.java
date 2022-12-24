package com.gwit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	

	
	@FindBy(xpath="//a[text()='iMac']")
	private WebElement eleSearchResult;
	
	@FindBy(xpath="//h2[text()='Products meeting the search criteria']/following-sibling::p")
	private WebElement eleSearchResultText;
			
		
	
	public SearchPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean statusofSearchResultOnSearchPage() {
		
		return eleSearchResult.isDisplayed();
		
	}
	public String getSearchResultMessageOnSearchPage() {
		
		return eleSearchResultText.getText();
		
	}
	

}
