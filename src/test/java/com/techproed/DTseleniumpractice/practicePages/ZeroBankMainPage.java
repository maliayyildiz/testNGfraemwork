package com.techproed.DTseleniumpractice.practicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroBankMainPage {
    WebDriver driver;
    public ZeroBankMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (id = "signin_button")
    public WebElement signInMainButton;
}
