package com.techproed.DTseleniumpractice.practicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {
    WebDriver driver;
    public WebTablePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//div[@class='rt-thead -header']")
    public WebElement headers;

    @FindBy(xpath = "(//div[@class='rt-td'])[8]")
    public WebElement aldenDepartment;

    @FindBy (xpath = "(//div[@class='rt-resizable-header-content'])[6]")
    public WebElement departmentOnHeaders;

}
