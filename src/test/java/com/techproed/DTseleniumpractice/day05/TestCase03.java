package com.techproed.DTseleniumpractice.day05;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends TestBase {
    @Test
    public void testCase04(){
//        1.Go to ” https://demoqa.com/dynamic-properties”
        driver.get("https://demoqa.com/dynamic-properties");
//        2.Verify the Visible After 5 Seconds button is displayed
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
       Assert.assertTrue( visibleButton.isDisplayed());
    }
}
