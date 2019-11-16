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

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//findElementByLinkText("测试技术").click();

		for (WebElement webelement :findElementsByPartialLinkText("测试")) {
			System.out.println(webelement.getText());
			if(webelement.getText().equals("测试工具")){
				webelement.click();
				break;
			}

		}

		System.out.println("定位成功");
		
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
