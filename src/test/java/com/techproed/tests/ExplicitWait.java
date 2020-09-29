package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ExplicitWait extends TestBase {
    @Test
    public void explicitWait(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebElement message1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //WebElement message1 = driver.findElement(By.id("message"));
        String message1Text = message1.getText();
        Assert.assertEquals(message1Text, "It's gone!");

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        // String message2 = driver.findElement(By.id("message")).getText();
        String message2Text = message2.getText();
        Assert.assertEquals(message2Text, "It's back!");



    }
}
