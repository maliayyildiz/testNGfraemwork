package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHandleExample2 extends TestBase {
    //    Given user is on the https://the-internet.herokuapp.com/windows
    //    Then user verifies the text : “Opening a new window”
    //    Then user verifies the title of the page is “The Internet”
    //Check if the expectedTitle equals the actual Title. If they are not equal then print Title is incorrect
    //    When user clicks on the “Click Here” button
    //    Then user verifies the new window title is “New Window”
    //    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”
    @Test
    public void windowHandle(){
        driver.get("https://the-internet.herokuapp.com/windows");
        String actualText  = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle,expectedTitle,"Title is incorrect");

        String window1 = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();


        Set<String> allWindow = driver.getWindowHandles();

        for (String s : allWindow) {
           if (!s.equals(window1)){
               driver.switchTo().window(s);
           }
        }

        String newPageText = driver.findElement(By.tagName("h3")).getText();
        String expectedNewPageText = "New Window";
        Assert.assertEquals(newPageText,expectedNewPageText);





    }
}
