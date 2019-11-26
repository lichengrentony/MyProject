package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 extends Feature{
	
	@Test
	public void f() {
		
		getUrl();

		for (WebElement webelement:findElements("//div[@id=\"u1\"]//a")) {
			webelement.click();
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		before("chrome");
	}

	@AfterMethod
	public void afterMethod() {
		after();
	}

}
