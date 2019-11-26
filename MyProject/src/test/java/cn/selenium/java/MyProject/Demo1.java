package cn.selenium.java.MyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Demo1 extends Feature {

    @Test
    public void f() throws InterruptedException {

        getUrl();

        getWindow();

        scrollDown();
        Thread.sleep(3000);
        scrollUp();
        Thread.sleep(3000);
        scrollIntoView(findElement("xpath","//div[@class='tese']//a[contains(text(),'QT')]"));
		Thread.sleep(3000);
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
