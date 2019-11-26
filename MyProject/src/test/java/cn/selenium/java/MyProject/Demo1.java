package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 extends Feature{

	@Test
	public void f() throws InterruptedException {
		
		getUrl();

		findElement("id","HD_CheckIn").click();

		WebElement webElement = findElement("xpath","//dl[@class=\"calendar_day\"]//dd");

		List<WebElement> list =webElement.findElements(By.xpath("//a"));

		for (WebElement webs:list) {
			if (webs.getText().equals(30)){
				webs.click();
				break;
			}
		}

		//waitForElement(By.xpath("//dd//a[@id='2019-11-30']"),3).click();

		Thread.sleep(2000);

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
