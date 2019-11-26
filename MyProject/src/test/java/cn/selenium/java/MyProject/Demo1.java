package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 extends Feature{

	@Test
	public void f() {
		
		getUrl();

		waitForElement(By.id("kw"),1);

		clearAndSendKeys(findElement("id","kw"),"selenium");

	}

	@BeforeMethod
	public void beforeMethod() {
		before("ie");
	}

	@AfterMethod
	public void afterMethod() {
		after();
	}

}
