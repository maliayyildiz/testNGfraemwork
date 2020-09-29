package com.techproed.DTseleniumpractice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase01 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void alert01(){

        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        WebElement button1 = driver.findElement(By.id("button1"));
        button1.click();

        String popupText = driver.switchTo().alert().getText();
        Assert.assertEquals(popupText,"I am an alert box!");

        driver.switchTo().alert().accept();

    }
    @AfterMethod
    public void tearDown(){
      driver.close();
    }
}
