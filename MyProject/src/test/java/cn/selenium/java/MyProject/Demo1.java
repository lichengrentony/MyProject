package cn.selenium.java.MyProject;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
