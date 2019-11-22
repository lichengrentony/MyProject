package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class Feature {
	
	protected WebDriver driver;
	
	protected String baseUrl="http://www.51testing.com";
	
	//打开并最大化浏览器
	public void before(String type){

		if (type.equalsIgnoreCase("ie")){

			DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
			desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS,false);
			//暂时不起作用
			//desiredCapabilities.setBrowserName("ie");
			//desiredCapabilities.setPlatform(Platform.WINDOWS);

			System.setProperty("webdriver.ie.driver","./IEDriverServer.exe");

			driver = new InternetExplorerDriver(desiredCapabilities);
		}

		if (type.equalsIgnoreCase("chrome")){

			DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

			//暂时不起作用
			//desiredCapabilities.setBrowserName("chrome");
			//desiredCapabilities.setPlatform(Platform.WINDOWS);

			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");

			driver = new ChromeDriver(desiredCapabilities);
		}

		if (type.equalsIgnoreCase("firefox")){

			DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();

			//暂时不起作用
			//desiredCapabilities.setBrowserName("firefox");
			//desiredCapabilities.setPlatform(Platform.WINDOWS);

			System.setProperty("webdriver.gecko.driver","./geckodriver.exe");

			driver = new FirefoxDriver(desiredCapabilities);
		}

		driver.manage().window().maximize();
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
