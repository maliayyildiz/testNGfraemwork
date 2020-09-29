package com.techproed.DTseleniumpractice.day04;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase03 extends TestBase {
    @Test
    public void testCase03() throws InterruptedException {
//        1.Go to http://webdriveruniversity.com/IFrame
        driver.get("http://webdriveruniversity.com/IFrame");
//        2.Click the Our Products button
        WebElement iframe = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("Our Products")).click();

//        3.Click Cameras product

        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();
//        4.Print the message from popup
        WebElement popUp  = driver.findElement(By.xpath("//h4"));
        String popUpText = popUp.getText();
        Thread.sleep(3000);
        System.out.println(popUpText);
//        5.Click the close button
        driver.findElement(By.xpath("(//button)[4]")).click();
    }
}
