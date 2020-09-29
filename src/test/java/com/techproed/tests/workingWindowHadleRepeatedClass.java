package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class workingWindowHadleRepeatedClass extends TestBase {
    //    Given user is on the https://the-internet.herokuapp.com/windows
    //    Then user verifies the text : “Opening a new window”
    //    Then user verifies the title of the page is “The Internet”
    //Check if the expectedTitle equals the actual Title. If they are not equal then print Title is incorrect
    //    When user clicks on the “Click Here” button
    //    Then user verifies the new window title is “New Window”
    //    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void wHRC() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        String expectedH3Text = "Opening a new window";
        String actualH3Text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actualH3Text,expectedH3Text);

        String actualTitleText = driver.getTitle();
        String expectedTitleText = "The Internet";
        Assert.assertEquals(actualTitleText,expectedTitleText, "Titles is incorrect.");

        String defaultWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String eachWindow : allWindows) {
            if(!eachWindow.equals(defaultWindow)){
                driver.switchTo().window(eachWindow);
            }
        }

        String newWindowTitle = driver.getTitle();
        String expectedNewWindowTitle = "New Window";
        Assert.assertEquals(newWindowTitle,expectedNewWindowTitle);

        String newWindowText = driver.findElement(By.tagName("h3")).getText();
        String expectedNewWindowText = "New Window";
        Assert.assertEquals(newWindowText,expectedNewWindowText);

        Assert.assertEquals(actualTitleText,expectedTitleText, "it is not a default window");
    }
}
