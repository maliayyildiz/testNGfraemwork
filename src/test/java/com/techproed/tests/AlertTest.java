package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    //    Go to https://the-internet.herokuapp.com/javascript_alerts
//    Create setUp method
//    Create 3 test methods:
//    acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
//    dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
//    sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        //    acceptAlert() => click on the first alert,
        //    verify the text “I am a JS Alert” , click OK ,
        //    and Verify “You successfuly clicked an alert”
        WebElement firstAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        firstAlertButton.click();
        String firstAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(firstAlertText, "I am a JS Alert");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String resultText = driver.findElement(By.id("result")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(resultText, "You successfuly clicked an alert");

    }
    @Test
    public void secondOne() throws InterruptedException {
        WebElement secondAlertButton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        secondAlertButton.click();
        String secondAlertText = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        Assert.assertEquals(secondAlertText, "I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
        String secondAlertResultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(secondAlertResultText, "You clicked: Cancel");
        Thread.sleep(3000);
    }
    @Test
    public void thirdOne() throws InterruptedException {
        // sendKeysAlert()=> click on the third alert,
        // verify text “I am a JS prompt”, type “Hello Word”,
        // click OK, and Verify “You entered: Hello Word”
        WebElement thirdAlertButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirdAlertButton.click();
        Thread.sleep(3000);
        String thirdAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(thirdAlertText, "I am a JS prompt");
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Hello Word");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        String thirdResultText = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(thirdResultText, "You entered: Hello Word");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
