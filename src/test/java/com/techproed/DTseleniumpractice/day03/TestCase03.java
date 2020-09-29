package com.techproed.DTseleniumpractice.day03;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase03 extends TestBase {
    @Test
    public void alert1() {
        driver.get("http://zero.webappsecurity.com/");
        WebElement signInButton = driver.findElement(By.id("signin_button"));
        signInButton.click();
        WebElement userNameBox = driver.findElement(By.id("user_login"));
        userNameBox.sendKeys("username");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement passwordBox = driver.findElement(By.id("user_password"));
        passwordBox.sendKeys("password");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement signInButton2 = driver.findElement(By.xpath("//input[@type='submit']"));
        signInButton2.click();

        WebElement accountActivity = driver.findElement(By.linkText("Account Activity"));
        accountActivity.click();

        WebElement dropDownAccountBar = driver.findElement(By.id("aa_accountId"));
        Select dropDownAccountMenu = new Select(dropDownAccountBar);
        dropDownAccountMenu.selectByValue("6");
        Assert.assertTrue(dropDownAccountMenu.getFirstSelectedOption().isSelected() );
        List<WebElement> menuList = dropDownAccountMenu.getOptions();

        List<String> actualList = new ArrayList<String>();

        for (WebElement e : menuList) {
             actualList.add(e.getText());
        }
        List<String> expectedList = Arrays.asList("Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage");

        Assert.assertEquals(expectedList,actualList );
    }
}
