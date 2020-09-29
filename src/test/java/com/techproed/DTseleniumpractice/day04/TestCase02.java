package com.techproed.DTseleniumpractice.day04;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {
    @Test
    public void testCase02(){
//        1.Go to http://webdriveruniversity.com/File-Upload/
//        2.Click the Choose file button
//        3.Create a text document in your desktop
//        4.Upload this document from your desktop
//        5.Click the Submit button
//        6.Verify the “Your file has now been uploaded!” is displayed
//        7.Accept the popup.
        driver.get("http://webdriveruniversity.com/File-Upload/");
        WebElement  doc1 = driver.findElement(By.id("myFile"));
        String pathOfDoc = "/Users/mehmetali/Desktop/test1.docx";
        doc1.sendKeys(pathOfDoc);
        driver.findElement(By.id("submit-button")).click();

        String popUpMsg = driver.switchTo().alert().getText();
        String expectedMsg = "Your file has now been uploaded!";
        Assert.assertEquals(popUpMsg,expectedMsg);
        driver.switchTo().alert().accept();
    }
}
