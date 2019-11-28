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

        findElement("id","su").click();

        String keys = Keys.CONTROL+"a";

        findElement("partiallinktext","软件测试进阶").sendKeys(Keys.chord(keys));

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
