package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClass2 extends TestBase {
    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement accountPlace = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountPlace).perform();
        Thread.sleep(10000);

        WebElement account = driver.findElement(By.linkText("Your Account"));
        account.click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Your Account";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void languageTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement languagePlace = driver.findElement(By.id("icp-nav-flyout"));
        Actions actions = new Actions(driver);
        actions.moveToElement(languagePlace).perform();
        Thread.sleep(20000);
    }
}
