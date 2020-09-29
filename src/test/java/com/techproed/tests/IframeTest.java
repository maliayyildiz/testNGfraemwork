package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/iframe
//        Verify the Bolded text contains “Editor”
//        Locate the text box
//        Delete the text in the text box
//        Type “This text box is inside the iframe”
//        Verify the text Elemental Selenium text is displayed on the
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement boldedText = driver.findElement(By.xpath("//h3"));
        String boldedTextText = boldedText.getText();
        Assert.assertTrue(boldedTextText.contains("Editor"));
// we have to switchTo() iframe first bcz the text box in the i frame
        //driver.switchTo().frame(0); // it is first iframe index= 0
        //driver.switchTo().frame("mce_0_ifr"); //we just need to put iframe ID value to sitch to that iframe

        driver.findElement(By.xpath("//iframe"));//switching to iframe by webelement
        Thread.sleep(5000);
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']//p"));
        textBox.clear();
        Thread.sleep(5000);
        textBox.sendKeys("This text box is inside the iframe");
//Elemental Selenium is outside of ifream but currently our driver is inside the iframe
        //so we need to get out from
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        String text = driver.findElement(By.linkText("Elemental Selenium")).getText();
        Assert.assertTrue(text.equals("Elemental Selenium"));
    }
}
