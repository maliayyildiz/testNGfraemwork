package com.techproed.DTseleniumpractice.day04;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class TestCase04 extends TestBase {
    @Test
    public void testCase04(){
      driver.get("http://webdriveruniversity.com/Actions");
        WebElement hoveroverButton = driver.findElement(By.xpath("(//button)[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoveroverButton).perform();
        driver.findElement(By.linkText("Link 1")).click();
        String pupUpText = driver.switchTo().alert().getText();
        System.out.println(pupUpText);
        driver.switchTo().alert().accept();
        WebElement clickHoldBox = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHoldBox).perform();
        String clickAndHoldText = driver.findElement(By.xpath("(//p)[3]")).getText();
        System.out.println(clickAndHoldText);
    }
}
