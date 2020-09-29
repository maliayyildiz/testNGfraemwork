package com.techproed.DTseleniumpractice.day05;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCase01 extends TestBase {
    @Test
    public void testCase01() throws InterruptedException {
//        1.Go to http://webdriveruniversity.com/
        driver.get("http://webdriveruniversity.com/");
//        2.Go down to Login Portal
        Actions actions = new Actions(driver);

        WebElement loginPortal = driver.findElement(By.xpath("(//h1)[2]"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        3.Click the Login Portal
        loginPortal.click();
//        4.Go to second windows
        String window1 = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Thread.sleep(10000);
        for (String eachWindow : allWindows) {
            if (!eachWindow.equals(window1)) {
                driver.switchTo().window(eachWindow);
            }
        }
            String title = driver.getTitle();
            System.out.println(title);
//        5.Fill the username and password
            WebElement user = driver.findElement(By.id("text"));
            user.sendKeys("ali");
           WebElement password = driver.findElement(By.id("password"));
           password.sendKeys("veli");
//        6.Click the login button
            driver.findElement(By.id("login-button")).click();
//        7.Print the popup text
            String popUpText = driver.switchTo().alert().getText();
            System.out.println(popUpText);
//        8.Accept the popup
            driver.switchTo().alert().accept();
        }
    }
