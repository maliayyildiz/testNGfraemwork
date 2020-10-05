package com.techproed.tests;

import com.techproed.pages.KoalaPalaceLoginPage;
import com.techproed.pages.KoalaPalaceMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class FirstDriverTest {
    @Test
    public void firstDriverTest(){
        //    When user goes to the application http://www.kaolapalace-qa-environment2.com/
//    And click on the Login button
//    Then verify user is able to log in
        Driver.getDriver().get(ConfigReader.getProperty("koala_url"));

        KoalaPalaceMainPage koalaPalaceMainPage = new KoalaPalaceMainPage(Driver.getDriver());
        koalaPalaceMainPage.mainPageLoginButton.click();

        KoalaPalaceLoginPage koalaPalaceLoginPage = new KoalaPalaceLoginPage(Driver.getDriver());
        koalaPalaceLoginPage.username.sendKeys(ConfigReader.getProperty("username"));
        koalaPalaceLoginPage.password.sendKeys(ConfigReader.getProperty("password"));
        koalaPalaceLoginPage.loginButton.click();
        Driver.closeDriver();
    }
}
