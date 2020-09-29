package com.techproed.BugFigthers;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase01 extends TestBase {
    @Test
    public void techProEdTest() throws InterruptedException {

        driver.get("https://www.gap.com/");
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        Thread.sleep(15000);
        driver.switchTo().alert().dismiss();



    }
}
