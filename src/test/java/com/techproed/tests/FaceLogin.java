package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {
    @Test
    public void LoginTest(){
        driver.get("https://www.facebook.com/");
        FaceLoginPage faceLoginPage = new FaceLoginPage(driver);
        faceLoginPage.username.sendKeys("adflkyiwkjh");
        faceLoginPage.password.sendKeys("2437502hkjfm");
        faceLoginPage.loginButton.click();

        String expectedErrorMessage = "The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(faceLoginPage.errorMessage.getText(),expectedErrorMessage);
    }

}
