package com.techproed.smoketest;

import com.techproed.pages.KoalaPalaceLoginPage;
import com.techproed.pages.KoalaPalaceMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KoalaPalaceLogin extends TestBase {
    @Test
    public void koalaLoginTest(){
        driver.get(ConfigReader.getProperty("koala_url"));
        //driver.get("http://www.kaolapalace.com/");
        KoalaPalaceMainPage koalaPalaceMainPage = new KoalaPalaceMainPage(driver);
        koalaPalaceMainPage.mainPageLoginButton.click();

        KoalaPalaceLoginPage koalaPalaceLoginPage = new KoalaPalaceLoginPage(driver);
        koalaPalaceLoginPage.username.sendKeys(ConfigReader.getProperty("username"));
        koalaPalaceLoginPage.password.sendKeys(ConfigReader.getProperty("password"));
        koalaPalaceLoginPage.loginButton.click();
    }

}
