package com.techproed.smoketest;

import com.techproed.pages.KoalaPalaceLoginPage;
import com.techproed.pages.KoalaPalaceMainPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KoalaPalaceLogin extends TestBase {
    @Test
    public void koalaLoginTest(){
        driver.get("http://www.kaolapalace.com/");
        KoalaPalaceMainPage koalaPalaceMainPage = new KoalaPalaceMainPage(driver);
        koalaPalaceMainPage.mainPageLoginButton.click();

        KoalaPalaceLoginPage koalaPalaceLoginPage = new KoalaPalaceLoginPage(driver);
        koalaPalaceLoginPage.username.sendKeys("manager2");
        koalaPalaceLoginPage.password.sendKeys("Man1ager2!");
         koalaPalaceLoginPage.loginButton.click();
    }

}
