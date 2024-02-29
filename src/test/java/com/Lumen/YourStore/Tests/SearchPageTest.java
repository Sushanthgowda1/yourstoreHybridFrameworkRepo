package com.Lumen.YourStore.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Lumen.YourStore.BaseClass.Base;
import com.Lumen.YourStore.Pages.LandingPage;
import com.Lumen.YourStore.Pages.SearchPage;

public class SearchPageTest extends Base{
	
	WebDriver driver;
	LandingPage landing;
	SearchPage searchpage;

	public SearchPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = launchDriver(prop.getProperty("browser"));
		landing = new LandingPage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checksearchpageBreadCrumb() {
		
		landing.lanuchApplication(prop.getProperty("url"));
		Assert.assertTrue(landing.verifyLogo());
		searchpage=landing.searchingvalidProd(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchpage.getsearchPageBreadCrumb().contains("Search"));
		
	}
	
	public void searchProdWithValidInput() {
		landing.lanuchApplication(prop.getProperty("url"));
		searchpage= landing.searchInvalidProd(dataProp.getProperty("invalidProduct"));
		
	}

}
