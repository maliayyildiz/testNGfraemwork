package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest  extends TestBase {
    @Test
    public void uploadFileMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(5000);
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String pathOfPic = "/Users/mehmetali/Desktop/FLOWER. IMG.jpg";
        chooseFile.sendKeys(pathOfPic);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        String actualResult = driver.findElement(By.xpath("//h3")).getText();
        String expectedResult = "File Uploaded!";
        Assert.assertEquals(expectedResult,actualResult, "It is not matching.");
    }
}
