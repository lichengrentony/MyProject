package cn.selenium.java.MyProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Demo1 {
	
	WebDriver driver;
	
	String baseUrl="http://www.baidu.com";
	
	@Test
	public void f() {
		driver.get(baseUrl);
		
		WebElement inputbox = driver.findElement(By.id("kw"));
		
		Assert.assertTrue(inputbox.isDisplayed());
		
		Reporter.log("显示输入框");		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
