package com.Lumen.YourStore.Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	public WebElement firstName;
	@FindBy(xpath = "//input[@id='input-lastname']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	public WebElement phone;
	@FindBy(xpath = "//input[@id='input-password']")
	public WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	public WebElement confPassword;
	@FindBy(xpath = "//input[@name='agree']")
	public WebElement policy;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement submit;
	@FindBy(xpath = "(//div[@id='content']//p)[1]")
	public WebElement confirmMsg;
	@FindBy(xpath = "//a[normalize-space()='Success']")
	private WebElement registerBreadCrumb;
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyBreadCrumb() {
		return registerBreadCrumb.getText();
	}
	
	public void enterFirstName(String firstname) {
		firstName.clear();
		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lname) {
		lastName.clear();
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String eMail) {
		email.clear();
		email.sendKeys(eMail);
	}
	
	public void enterPhoneNum(String num) {
		phone.clear();
		phone.sendKeys(num);
	}
	
	public void enterPassword(String password1) {
		password.clear();
		password.sendKeys(password1);
	}
	
	public void enterconfirmpassword(String password2) {
		confPassword.clear();
		confPassword.sendKeys(password2);
	}
	
	public void clickOnPolicy() {
		policy.click();
	}
	
	public void clickOnsubmit() {
		submit.click();
	}
	
	public String verifyConfirmationMsg() {
		return confirmMsg.getText();
	}
	
	
	
	public String verifyRegitrationwithValidFields(String firstname,String lastname,String email1,String phone1,String password1) {
		firstName.clear();
		firstName.sendKeys(firstname);
		lastName.clear();
		lastName.sendKeys(lastname);
		email.clear();
		email.sendKeys(email1);
		phone.clear();
		phone.sendKeys(phone1);
		password.clear();
		password.sendKeys(password1);
		confPassword.clear();
		confPassword.sendKeys(password1);
		policy.click();
		submit.click();
		return confirmMsg.getText();
		
	}
	

}
