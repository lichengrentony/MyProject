package cn.selenium.java.MyProject;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class Demo1 extends Feature {

    public Logger log = LogManager.getLogger(Demo1.class.getName());

    @Test
    public void f() throws InterruptedException, IOException, AWTException, FindFailed {

        getUrl();
        log.debug("Debug message logged");
        log.error("Error message logged");
        log.fatal("fatal message logged");
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
