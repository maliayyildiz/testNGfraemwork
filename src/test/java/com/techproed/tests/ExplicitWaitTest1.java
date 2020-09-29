package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest1 extends TestBase {

    @Test
    public void isEnabled(){
        WebDriverWait wait = new WebDriverWait(driver,10);
//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebElement message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        Click enable Button
        //WebElement message1 = driver.findElement(By.xpath("//p[@id=
        String message1Text = message1.getText();
//        And verify the message is equal to “It's enabled!”
        Assert.assertEquals(message1Text, "It's enabled!");

//        And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textBox.isEnabled());
//        And click on Disable button
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

        WebElement message2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
//        And verify the message is equal to “It's disabled!”
       // WebElement message2 = driver.findElement(By.xpath("//p[@id='message']"));
        String message2Text = message2.getText();
       // Assert.assertEquals(message2Text, "It's disabled!");
//        And verify the textbox is disabled (I cannot type in the box)
        Assert.assertFalse(textBox.isEnabled());
    }
}
