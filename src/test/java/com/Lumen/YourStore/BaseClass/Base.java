package com.Lumen.YourStore.BaseClass;

import java.io.File;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Lumen.YourStore.utils.customUtils;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;

	public Base() {
		try {
			prop = new Properties();
			File fi= new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Lumen\\YourStore\\config\\Config.properties");
			FileInputStream file = new FileInputStream(fi);
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			dataProp = new Properties();
			File fi1= new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\Lumen\\YourStore\\Testdata\\testData.properties");
			FileInputStream file2 = new FileInputStream(fi1);
			dataProp.load(file2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver launchDriver(String browser) {
		

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			System.out.println("launching chrome driver");
			
		} else if (browser.equalsIgnoreCase("firefox")) {

	
			driver = new FirefoxDriver();
			System.out.println("launching firefox driver");
			
		} else if (browser.equalsIgnoreCase("io")) {

	
			driver = new EdgeDriver();
			System.out.println("launching edgedriver driver");
			
		} else

		{
			System.out.println("No Such Browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(customUtils.wait_Time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(customUtils.wait_Time));
		return driver;
	}
	
	

}
