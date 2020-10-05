package com.techproed.pages;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelRoomsPage {
    WebDriver driver;
    public HotelRoomsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //hotel mamagment  hotel room
    @FindBy(xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomsButton;

    @FindBy(id = "IDHotel")
    public WebElement idHotel;

    @FindBy (id = "Code")
    public WebElement hotelCode;

    @FindBy (id = "Name")
    public WebElement hotelName;

    @FindBy (id = "Location")
    public WebElement location;

    @FindBy (xpath = "//textarea[@role='textbox']")
    public WebElement note;

    @FindBy (id = "Price")
    public WebElement price;

    @FindBy (id = "IDGroupRoomType")
    public WebElement roomType;

    @FindBy (id = "MaxAdultCount")
    public WebElement adultCount;

    @FindBy (id = "MaxChildCount")
    public WebElement childCount;

    @FindBy (id = "IsAvailable")
    public WebElement availableCheckBox;

    @FindBy (id="btnSubmit")
    public WebElement submitButton;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement successMessage;







}
