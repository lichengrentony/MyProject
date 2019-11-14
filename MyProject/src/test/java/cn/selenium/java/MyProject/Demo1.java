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

public class Demo1 extends Feature{
	
	@Test
	public void f() {
		
		getUrl();
		
		findElementById("kw");
		
		Reporter.log("显示输入框");		
	}

	@BeforeMethod
	public void beforeMethod() {
		before();
	}

	@AfterMethod
	public void afterMethod() {
		after();
	}

}
