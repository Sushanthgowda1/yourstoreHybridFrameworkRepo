package com.Lumen.YourStore.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement registerBtn;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passWordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void enterpassword(String password) {
		passWordField.clear();
		passWordField.sendKeys(password);
	}

	public MyAccountPage clickOnloginBtn() {
		loginBtn.click();
		return new MyAccountPage(driver);
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

	public RegistrationPage clickOnRegisterBTN() {
		registerBtn.click();
		return new RegistrationPage(driver);
	}

}
