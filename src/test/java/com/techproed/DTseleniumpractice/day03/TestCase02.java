package com.techproed.DTseleniumpractice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase02 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void alert02(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebElement button4 = driver.findElement(By.id("button4"));
        button4.click();

        Alert popup = driver.switchTo().alert();
        String popupText = popup.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(popupText,"Press a button");
        popup.dismiss();
        WebElement alertResultText = driver.findElement(By.id("confirm-alert-text"));
        Assert.assertTrue(alertResultText.isDisplayed());
        softAssert.assertAll();
        }
    @Test(dependsOnMethods = "alert02")
    public void alert2(){
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebElement button4 = driver.findElement(By.id("button4"));
        button4.click();

        Alert popup = driver.switchTo().alert();
        String popupText = popup.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(popupText,"Press a button!");
        popup.dismiss();
        WebElement alertResultText = driver.findElement(By.id("confirm-alert-text"));
        Assert.assertTrue(alertResultText.isDisplayed());
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
