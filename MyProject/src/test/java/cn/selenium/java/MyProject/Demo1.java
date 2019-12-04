package cn.selenium.java.MyProject;


import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Demo1 extends Feature {



    @Test
    public void f() throws InterruptedException, IOException, AWTException, FindFailed {

        getUrl();
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
