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

		System.out.println(isEnable(findElementById("searchkey")));

		clearAndSendKeys(findElementById("searchkey"),"selenium");

		System.out.println(getTitle());

		System.out.println(getCurrentUrl());

		Navigate("http://www.baidu.com");

		goBack();

		goForward();

		refresh();

		System.out.println(getPageSource());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
