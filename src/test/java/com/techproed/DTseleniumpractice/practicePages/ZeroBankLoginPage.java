package com.techproed.DTseleniumpractice.practicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroBankLoginPage {
//    Go to http://zero.webappsecurity.com/
//            2. Write a useful method which is named login under the
//    practicePage
//3. Call the login method from TestCase1 class.
WebDriver driver;
    public ZeroBankLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "user_login")
    public WebElement userBox;

    @FindBy (id = "user_password")
    public WebElement password;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement signInButton;

}
