package cn.selenium.java.MyProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 extends Feature{
	
	@Test
	public void f() {
		
		getUrl();


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
