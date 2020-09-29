package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {
    //Create a clickLogin Method
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }
    @Test
    public void positiveLoginTest() throws InterruptedException {
        clickOnLogin();
        Thread.sleep(5000);
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(15000);
        WebElement addUserButton  = driver.findElement(By.xpath("//span[@class='hidden-480']"));
        Assert.assertTrue(addUserButton.isDisplayed());
    }
}
