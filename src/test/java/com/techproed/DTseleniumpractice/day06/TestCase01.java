package com.techproed.DTseleniumpractice.day06;

import com.techproed.DTseleniumpractice.practicePages.ZeroBankLoginPage;
import com.techproed.DTseleniumpractice.practicePages.ZeroBankMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {

    @Test
    public void testCase01(){
        zeroBankLoginMethod();
    }
    public void zeroBankLoginMethod(){
        driver.get(ConfigReader.getProperty("zero_bank_url"));
        ZeroBankMainPage zeroBankMainPage = new ZeroBankMainPage(driver);
        zeroBankMainPage.signInMainButton.click();
        ZeroBankLoginPage zeroBankLogin = new ZeroBankLoginPage(driver);
        zeroBankLogin.userBox.sendKeys(ConfigReader.getProperty("zero_username"));
        zeroBankLogin.password.sendKeys(ConfigReader.getProperty("zero_password"));
        zeroBankLogin.signInButton.click();
    }
}
