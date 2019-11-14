package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Feature {
	
	protected WebDriver driver;
	
	protected String baseUrl="http://www.baidu.com";
	
	//打开IE浏览器
	public void before(){
		System.setProperty("webdriver.ie.driver", ".\\IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();
	}
	
	//关闭浏览器
	public void after() {
		driver.quit();
	}
	
	//跳转到指定页面
	public void getUrl() {
		driver.get(baseUrl);
	}
	
	//通过id定位元素
	public WebElement findElementById(String value) {
		WebElement webElement = driver.findElement(By.id(value));
		return webElement;
	}
	
	
}
