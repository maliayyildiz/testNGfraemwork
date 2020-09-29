package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.WeakHashMap;

public class ActionClass3 extends TestBase {
    @Test
    public void keysUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions
                .keyDown(searchBox, Keys.SHIFT)
                .sendKeys("iPhone X prices")
                .keyUp(searchBox,Keys.SHIFT)
                .perform();
        Thread.sleep(10000);
    }
}
