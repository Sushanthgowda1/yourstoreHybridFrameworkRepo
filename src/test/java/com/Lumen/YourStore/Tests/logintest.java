package com.Lumen.YourStore.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Lumen.YourStore.BaseClass.Base;
import com.Lumen.YourStore.Pages.LandingPage;
import com.Lumen.YourStore.Pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logintest  extends Base{
	
	WebDriver driver;
	LandingPage landing;
	LoginPage login;
	
	@Test
	public void loginTest() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		landing = new LandingPage(driver);
		landing.lanuchApplication("https://www.demoopencart.in/themes/salestore/oc3/index.php?route=common/home");
		
		
	}

}
