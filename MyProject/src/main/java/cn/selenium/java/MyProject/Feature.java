package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.List;

public class Feature {
	
	protected WebDriver driver;
	
	protected String baseUrl="http://www.51testing.com";
	
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
	public WebElement findElementById(String id) {
		WebElement webElement = driver.findElement(By.id(id));
		return webElement;
	}

	//通过name定位元素
	public WebElement findElementByName(String name){
		WebElement webElement = driver.findElement(By.name(name));
		return webElement;
	}

	//通过链接文字定位元素
	public WebElement findElementByLinkText(String text){
		WebElement webElement = driver.findElement(By.linkText(text));
		return webElement;
	}

	//通过部分文字链接定位元素
	public WebElement findElementByPartialLinkText(String text){
		WebElement webElement = driver.findElement(By.partialLinkText(text));
		return  webElement;
	}

	//通过部分文字链接定位多个元素
	public List<WebElement> findElementsByPartialLinkText(String text){
		List<WebElement> webelements = driver.findElements(By.partialLinkText(text));
		return webelements;
	}

	//通过标签定位元素 - 未测试
	public WebElement findElementByTagName(String name){
		WebElement webElement = driver.findElement(By.tagName(name));
		return  webElement;
	}

	//通过类名定位元素 - 未测试
	public  WebElement findElementByClassName(String name){
		WebElement webElement = driver.findElement(By.className(name));
		return webElement;
	}
}
