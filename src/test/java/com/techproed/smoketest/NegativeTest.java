package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    public void clickOnLogIn(){
        driver.navigate().to("http://www.kaolapalace-qa-environment2.com/");
        driver.findElement(By.linkText("Log in")).click();
    }
    @Test
    public void invalidPassword(){
    clickOnLogIn();
    driver.findElement(By.id("UserName")).sendKeys("manager2");
    driver.findElement(By.id("Password")).sendKeys("Abcdjk61*");
    driver.findElement(By.id("btnSubmit")).click();
    String wrongPasswordText = driver.findElement(By.id("divMessageResult")).getText();
      //  System.out.println(wrongPasswordText);
    Assert.assertTrue(wrongPasswordText.contains("Wrong password"));

    }
    @Test
    public void invalidID(){
        clickOnLogIn();
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        String errorMsgText = driver.findElement(By.id("divMessageResult")).getText();
       // System.out.println(wrongPasswordText);
        Assert.assertTrue(errorMsgText.contains("Username or password is incorrect, please correct them and try again"));
    }
    @Test
    public void invalidIDAndPassword(){
    clickOnLogIn();
        driver.findElement(By.id("UserName")).sendKeys("manager");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2");
        driver.findElement(By.id("btnSubmit")).click();
        String errorMsgText = driver.findElement(By.id("divMessageResult")).getText();
        System.out.println(errorMsgText);
        Assert.assertTrue(errorMsgText.contains("Try again please"));
    }
}
