package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class FileDownload extends TestBase {
   @Test
    public void downloadTest() throws InterruptedException {
       driver.get("https://the-internet.herokuapp.com/download");
       driver.findElement(By.linkText("FLOWER.JPG")).click();
       Thread.sleep(5000);
       String userFolder = System.getProperty("user.home");
       System.out.println(userFolder);
       String downloadedFile = userFolder+"/Downloads/FLOWER.JPG";

       boolean isDownloaded = Files.exists(Paths.get(downloadedFile));

       Assert.assertTrue(isDownloaded);

   }
//    Create a class:FileDownload
//    downloadTest()
//    In the downloadTest() method, do the following test:
//    Go to https://the-internet.herokuapp.com/download
//    Download logo.png file
//    Then verify if the file downloaded successfully
}
