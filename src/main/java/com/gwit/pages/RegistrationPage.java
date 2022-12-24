package com.gwit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement eleRegFirstNameTextBox;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement eleRegLastNameTextBox;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement eleRegEmailTextBox;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement eleRegTelephoneTextBox;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement eleRegPasswordTextBox;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement eleRegConfirmPasswordTextBox;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement eleRegPrivacyPolicyCheckbox;
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement eleRegSubscribeRadioButton;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement eleRegContinueButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement eleExistingEmailAlert;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement elePrivacyPolicyWarningt;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement eleFirstNameFieldValidation;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement eleLastNameFieldValidation;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement eleEmailFieldValidation;
	
	public RegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterFirstNameOnRegistrationPage(String firstName) {
		eleRegFirstNameTextBox.clear();
		eleRegFirstNameTextBox.sendKeys(firstName);
	}
	
	public void enterLastNameOnRegistrationPage(String lastName) {
		eleRegLastNameTextBox.clear();
		eleRegLastNameTextBox.sendKeys(lastName);
	}
	public void enterEmailOnRegistrationPage(String email) {
		eleRegEmailTextBox.clear();
		eleRegEmailTextBox.sendKeys(email);
	}
	
	public void enterPhoneOnRegistrationPage(String phone) {
		eleRegTelephoneTextBox.clear();
		eleRegTelephoneTextBox.sendKeys(phone);
	}
	
	public void enterPasswordOnRegistrationPage(String password) {
		eleRegPasswordTextBox.clear();
		eleRegPasswordTextBox.sendKeys(password);
	}
	
	public void enterConfirmPasswordOnRegistrationPage(String password) {
		eleRegConfirmPasswordTextBox.clear();
		eleRegConfirmPasswordTextBox.sendKeys(password);
	}
	
	public void clickonPrivacyPolicyOnRegistrationPage() {
		eleRegPrivacyPolicyCheckbox.click();
		
	}
	
	public void clickonSubscribtionOnRegistrationPage() {
		eleRegSubscribeRadioButton.click();
		
	}
	public AccountCreatedPage clickonContinuButtonOnRegistrationPage() {
		eleRegContinueButton.click();
		return new AccountCreatedPage(driver);
		
	}
	
	public String getExistingEmailAlertTextOnREgistrationPage() {
		
		return eleExistingEmailAlert.getText();
		
	}
	public String getPrivacyPolicyWarningOnREgistrationPage() {
		
		return elePrivacyPolicyWarningt.getText();
		
	}
	public String getFirstNameValidationMessageOnREgistrationPage() {
		
		return eleFirstNameFieldValidation.getText();
		
	}
	
	public String getLastNameValidationMessageOnREgistrationPage() {
		
		return eleLastNameFieldValidation.getText();
		
	}
	public String getEmailValidationMessageOnREgistrationPage() {
		
		return eleEmailFieldValidation.getText();
		
	}

}
