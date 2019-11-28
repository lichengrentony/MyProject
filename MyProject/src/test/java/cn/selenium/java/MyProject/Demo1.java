package cn.selenium.java.MyProject;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Demo1 extends Feature {

    @Test
    public void f() throws InterruptedException, IOException {

        killAllBrowser();

        getUrl();

        setPosition(150,150);

        setDimension(500,500);

        getPosition();

        getSize();

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
