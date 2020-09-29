package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHandleExample extends TestBase {
    //    Then user verifies the text:  “New Window”
//    When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void newWindowTest(){
//    Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //    Then user verifies the text : “Opening a new window”
        String actualNewWindowText=driver.findElement(By.xpath("//div[@class='example']//h3")).getText();
        String expectedNewWindowText="Opening a new window";
        Assert.assertEquals(actualNewWindowText,expectedNewWindowText);
        //    Then user verifies the title of the page is “The Internet”
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        //Check if the expectedTitle equals the actual Title. If they are not equal then print Title is incorrect
        Assert.assertEquals(actualTitle,expectedTitle,"Title is incorrect");
        //WE ARE GETTING THE FIRST WINDOW HANDLE sO WHEN WE NEED TO SWITCH BACK TO THIS WINDOW WE CAN DO IT
        String window1=driver.getWindowHandle();
     //   System.out.println("Default Window Handle : "+window1);
//    When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();
        //    Then user verifies the new window title is “New Window”
        //THE NEW WINDOW OPENS IN A NEW TAB. THIS MEANS WE HAVE TO SWITCH TO THE NEW WINDOW!!!!
        ///WE WILL GET ALL OPEN WINDOW HANDLES AND PUT THEM IN A SET.
        Set<String> allWindows=driver.getWindowHandles();
        //Using for each loop, we can switch to the new window.
        for (String eachWindow:allWindows){
            if (!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);
            }
        }

        String actualNewPageTitle=driver.getTitle();
        String expectedNewPageTitle="New Window";
        Assert.assertEquals(actualNewPageTitle,expectedNewPageTitle,"New Page Title is not equal");

        String actualSecondNewWindowText = driver.findElement(By.xpath("//h3")).getText();
        String expectedSecondNewWindowText = "New Window";
        Assert.assertEquals(expectedSecondNewWindowText,actualSecondNewWindowText, "New window text is not matching.");

        driver.switchTo().window(window1);
        Assert.assertEquals(driver.getTitle(),"The Internet");

    }

}
