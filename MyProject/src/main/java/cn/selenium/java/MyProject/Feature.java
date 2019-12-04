package cn.selenium.java.MyProject;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Feature {

    private WebDriver driver = null;

    private JavascriptExecutor js = null;

    private static final String baseUrl = "http://www.baidu.com";

    private Alert alert = null;

    private Actions actions = null;

    private Point point = null;

    private Dimension dimension = null;

    private static final Logger log = LogManager.getLogger(Feature.class.getName());

    //打开并最大化浏览器
    public void before(String type) {

        if (type.equalsIgnoreCase("ie")) {

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.internetExplorer();
            desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            desiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            //暂时不起作用
            //desiredCapabilities.setBrowserName("ie");
            //desiredCapabilities.setPlatform(Platform.WINDOWS);

            System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");

            driver = new InternetExplorerDriver(desiredCapabilities);
        }

        if (type.equalsIgnoreCase("chrome")) {

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

            //暂时不起作用
            //desiredCapabilities.setBrowserName("chrome");
            //desiredCapabilities.setPlatform(Platform.WINDOWS);

            System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

            driver = new ChromeDriver(desiredCapabilities);
        }

        if (type.equalsIgnoreCase("firefox")) {

            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();

            //暂时不起作用
            //desiredCapabilities.setBrowserName("firefox");
            //desiredCapabilities.setPlatform(Platform.WINDOWS);

            System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

            driver = new FirefoxDriver(desiredCapabilities);
        }

        driver.manage().window().maximize();

        //隐式等待
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        log.info("打开浏览器");
    }

    //关闭浏览器
    public void after() {
        driver.quit();
        log.info("关闭浏览器");
    }

    //跳转到指定页面
    public void getUrl() {
        driver.get(baseUrl);
        //driver.navigate().to();
    }

    //定位单个元素
    public WebElement findElement(String locator, String value) {

        locator = locator.toLowerCase();

        WebElement webElement = null;

        switch (locator) {
            case "id":
                webElement = driver.findElement(By.id(value));
                break;
            case "name":
                webElement = driver.findElement(By.name(value));
                break;
            case "xpath":
                webElement = driver.findElement(By.xpath(value));
                break;
            case "linktext":
                webElement = driver.findElement(By.linkText(value));
                break;
            case "partiallinktext":
                webElement = driver.findElement(By.partialLinkText(value));
                break;
            case "classname":
                webElement = driver.findElement(By.className(value));
                break;
            case "tagname":
                webElement = driver.findElement(By.tagName(value));
                break;
            default:
                System.out.println("Element not found by-" + locator + ":" + value);
        }
        return webElement;
    }

    //定位元素集合
    public List<WebElement> findElements(String locator, String value) {
        locator = locator.toLowerCase();
        List<WebElement> list = new ArrayList<WebElement>();
        switch (locator) {
            case "id":
                list = driver.findElements(By.id(value));
            case "name":
                list = driver.findElements(By.name(value));
            case "xpath":
                list = driver.findElements(By.xpath(value));
            case "linktext":
                list = driver.findElements(By.linkText(value));
            case "partiallinktext":
                list = driver.findElements(By.partialLinkText(value));
            case "classname":
                list = driver.findElements(By.className(value));
            case "tagname":
                list = driver.findElements(By.tagName(value));
            default:
                if (list.isEmpty()){
                    System.out.println("Element not found by-" + locator + ":" + value);
                }
                return list;
        }
    }

    //遍历表格
    public void Table(String tableId) {
        WebElement webElement = driver.findElement(By.id(tableId));
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.println(col.getText() + "\t");
            }
        }
    }

    //点击链接
    public void click(WebElement webElement) {
        webElement.click();
    }

    //清空并输入
    public void clearAndSendKeys(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    //获取页面标题
    public String getTitle() {
        String url = driver.getTitle();
        return url;
    }

    //获取当前Url
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    //跳转到指定url
    public void Navigate(String url) {
        driver.navigate().to(url);
    }

    //返回上一页
    public void goBack() {
        driver.navigate().back();
    }

    //跳转到下一页
    public void goForward() {
        driver.navigate().forward();
    }

    //刷新
    public void refresh() {
        driver.navigate().refresh();
    }

    //获取页面源代码
    public String getPageSource() {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    //判断元素是否可用
    public boolean isEnable(WebElement webElement) {
        boolean flag = webElement.isEnabled();
        return flag;
    }

    //判断元素是否被选中
    public boolean isSelected(WebElement webElement) {
        boolean flag = webElement.isSelected();
        return flag;
    }

    //操作下拉列表
    public void selectBy(WebElement webElement,String locator,String value){
        Select select = new Select(webElement);
        locator = locator.toLowerCase();
        switch (locator){
            case "value":
                select.selectByValue(value);
            case "index":
                select.selectByIndex(Integer.parseInt(value));
            case "visibletext":
                select.selectByVisibleText(value);
            default:
                System.out.println("Element not found by-" + locator + ":" + value);
        }
    }

    //判断元素是否显示
    public boolean isDisplayed(WebElement webElement){
         return webElement.isDisplayed();
    }

    //获取元素上的文本
    public String getText(WebElement webElement){
        return webElement.getText();
    }

    //获取元素的属性值
    public String getAttributeValue(WebElement webElement,String attribute){
        return webElement.getAttribute(attribute);
    }

    //显示等待
    public WebElement waitForElement(By locator,int timeout){
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Element not displayed");
        }
        return webElement;
    }

    //获取窗口大小
    public void getWindow(){
        Long height = (Long) js.executeScript("return window.innerHeight;");
        Long width = (Long) js.executeScript("return window.innerWidth;");
        System.out.println("The height is:"+height);
        System.out.println("The width is:"+width);
    }

    //向上滚动
    public  void scrollUp(){
        js.executeScript("window.scrollBy(0,-1900);");
    }

    //向下滚动
    public  void scrollDown(){
        js.executeScript("window.scrollBy(0,1900);");
    }

    //滚动到指定元素
    public void scrollIntoView(WebElement webElement){
        js.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }

    //生成随机数
    public String getRandow(int length){
        StringBuilder sb = new StringBuilder();
        String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i=0;i<length;i++){
            int index = (int)(Math.random()*character.length());
            sb.append(character.charAt(index));
        }
        return sb.toString();
    }

    //截图并保存到screenshot目录
    public void getScreenShot(String filename) throws IOException {
        filename = filename +".png";
        String directory = "./screenshot/";
        File scourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(scourceFile.getName());
        FileUtils.copyFile(scourceFile,new File(directory+filename));
    }

    //获取windowhandle
    public String getWindowHandle(){
        String windowHandle = driver.getWindowHandle();
        System.out.println("The handle is"+windowHandle);
        return windowHandle;
    }

    //获取windowhandles
    public Set<String> getWindowhandles(){
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles) {
            System.out.println("The handles is:"+handle);
        }
        return handles;
    }

    //通过handle切换到新窗口
    public void switchToWindow(String handle){
        driver.switchTo().window(handle);
    }

    //关闭当前窗口
    public void closeCurrentWindow(){
        driver.close();
    }

    //切换到iFrame
    public void switchtoiframe(){
        driver.switchTo().frame(0);
    }

    //切换到主窗口
    public void switchtodefault(){
        driver.switchTo().defaultContent();
    }

    //处理Javascript弹窗
    public void clickOnOk(){
        alert = driver.switchTo().alert();
        alert.accept();
    }

    //处理Javascript弹窗
    public void clickOnDismiss(){
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //鼠标悬停
    public void moveToElement(WebElement webElement){
        actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    //鼠标拖拽
    public  void dragAndDrop(WebElement source,WebElement target){
        actions = new Actions(driver);
        //actions.clickAndHold(source).moveToElement(target).release();
        actions.dragAndDrop(source, target).build().perform();
    }

    //拖动滚动条
    public void drapScrollBar(WebElement webElement,int xOffset,int yOffset){
        actions = new Actions(driver);
        actions.dragAndDropBy(webElement,xOffset,yOffset).perform();
    }

    //Actions处理按键
    public void sendkeys(){
        actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
    }

    //设置浏览器的位置
    public void setPosition(int x,int y){
        point = new Point(x,y);
        driver.manage().window().setPosition(point);
    }

    //设置浏览器的大小
    public void setDimension(int x,int y){
        dimension = new Dimension(x,y);
        driver.manage().window().setSize(dimension);
    }

    //获取浏览器的位置
    public void getPosition(){
        System.out.println(driver.manage().window().getPosition());

    }

    //获取浏览器的大小
    public void getSize(){
        System.out.println( driver.manage().window().getSize());
    }

    //关闭所有浏览器
    public void killAllBrowser(){
        WindowsUtils.killByName("iexplore.exe");
        WindowsUtils.killByName("chrome.exe");
        WindowsUtils.killByName("firefox.exe");
    }

}
