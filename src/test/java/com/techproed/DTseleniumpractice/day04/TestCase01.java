package com.techproed.DTseleniumpractice.day04;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCase01 extends TestBase {

    @Test
    public void testCase01(){
//        Go to http://zero.webappsecurity.com/
//        2. Click Sign in button
//        3. Enter login ( “username”)
//        4. Enter wrong password (“password”)
//        5. Click Sign in button
//        6. Go to Pay Bills page
//        7. Click Purchase Foreign Currency
//        8. Select Eurozone from currency drop dawn menu
//        9. Verify the Euro zone is selected
//        10. Verify the List Options is following {Select One, Australia (dollar), Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}

        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("Pay Bills")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Select dropdownList = new Select(dropDown);
        dropdownList.selectByValue("EUR");
        Assert.assertEquals(dropdownList.getFirstSelectedOption().getText(),"Eurozone (euro)");

        List<WebElement> menuList = dropdownList.getOptions();

        for (WebElement listMenu : menuList) {
            System.out.println(listMenu.getText());
        }
        List<String> expectedList = Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)"
                ,"Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
                "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");

        List<String> actualList = new ArrayList<>();
        for (WebElement listMenu : menuList) {
            actualList.addAll(Collections.singleton(listMenu.getText()));
        }







    }
}
