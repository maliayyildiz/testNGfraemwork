package com.techproed.glbTraders;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogIn  extends TestBase {
    public void LogIn(){
        driver.get("https://glbtrader.com");
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("email")).sendKeys("maliayyildiz61@gmail.com");
        driver.findElement(By.id("password")).sendKeys("ayyildiz61");
        driver.findElement(By.xpath("(//button)[2]")).click();
    }
    @Test
    public void lg() throws InterruptedException {
       // LogIn();

        driver.get("https://glbtrader.com");
        driver.findElement(By.linkText("See All >>")).click();
    }
}
