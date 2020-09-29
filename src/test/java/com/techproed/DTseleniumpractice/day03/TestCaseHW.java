package com.techproed.DTseleniumpractice.day03;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseHW extends TestBase {
    @Test
    public void seleniumPracticeTestCase2() throws InterruptedException {
        driver.get("http://zero.webappsecurity.com/");
        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();
        Thread.sleep(5000);
        WebElement userNameBox = driver.findElement(By.id("user_login"));
        userNameBox.sendKeys("username");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement signInButton2 = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton2.click();

        WebElement payBills = driver.findElement(By.linkText("Pay Bills"));
        payBills.click();
        Thread.sleep(5000);
        WebElement purchaseBar = driver.findElement(By.linkText("Purchase Foreign Currency"));
        purchaseBar.click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement currencyBar = driver.findElement(By.id("pc_currency"));
        Select currencyList = new Select(currencyBar);
        currencyList.selectByValue("EUR");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement amountBox = driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("500");
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement usdRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usdRadioButton.isSelected());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement selectedCurrencyButton = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrencyButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement calculateButton = driver.findElement(By.id("pc_calculate_costs"));
        calculateButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement messageText = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(messageText.isDisplayed());
    }
}
