package com.Lumen.YourStore.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Lumen.YourStore.BaseClass.Base;
import com.Lumen.YourStore.Pages.LandingPage;
import com.Lumen.YourStore.Pages.LoginPage;
import com.Lumen.YourStore.Pages.MyAccountPage;
import com.Lumen.YourStore.utils.XLutility;

public class LoginPageTest extends Base {

	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	MyAccountPage myAccount;

	public LoginPageTest() {
		super();
	}
	
	@DataProvider(name ="LoginData")
	public Object[][] supplyTestData() throws IOException {

		Object[][] data= XLutility.getcellData("sheet1");
		
		return data;
	}

	@BeforeMethod
	public void setUp() {

		driver = launchDriver(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider ="LoginData")
	public void verifyLoginWithExcelData(String username, String password) {
		
		landingPage.lanuchApplication(prop.getProperty("url"));
		String actualTitle = landingPage.titleOfHomePage();
		Assert.assertEquals(actualTitle, prop.getProperty("title"));
		loginPage = landingPage.clickOnLoginlink();
		loginPage.enterEmail(username);
		loginPage.enterpassword(password);
		myAccount=loginPage.clickOnloginBtn();
		String actualHeader=myAccount.verifyPageHeader();
		Assert.assertEquals(actualHeader, prop.getProperty("accountpageHeader"));
		landingPage=myAccount.clickOnHomeBreadCrumb();
			

	}

}
