package cn.selenium.java.MyProject;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Demo1 extends Feature {

    @Test
    public void f() throws InterruptedException, IOException {

        getUrl();

        findElement("id","kw").sendKeys("selenium");

        findElement("id","su").sendKeys(Keys.TAB);

        findElement("id","su").sendKeys(Keys.ENTER);

        Thread.sleep(2000);

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
