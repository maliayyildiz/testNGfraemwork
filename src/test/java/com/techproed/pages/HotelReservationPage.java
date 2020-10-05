package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelReservationPage  {
    WebDriver driver;
    public HotelReservationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addReservationButton;

    @FindBy (id = "IDUser")
    public WebElement IDUserDropdown;

    @FindBy (id = "IDHotelRoom")
    public  WebElement IDHotelRoomDropdown;

    @FindBy (id = "Price")
    public WebElement price;

    @FindBy (id = "DateStart")
    public WebElement dateStart;

    @FindBy (id = "DateEnd")
    public WebElement dateEnd;

    @FindBy(id = "AdultAmount")
    public WebElement capacityOfAdult;

    @FindBy(id = "ChildreAmount")
    public WebElement capacityOfChildren;

    @FindBy (id = "ContactNameSurname")
    public WebElement contactPerson;

    @FindBy (id = "ContactPhone")
    public WebElement contactPhone;

    @FindBy (id = "ContactEmail")
    public  WebElement contactEmail;

    @FindBy (id = "Notes")
    public WebElement notes;

    @FindBy (id = "Approved")
    public  WebElement approvedCheckBox;

    @FindBy (id = "IsPaid")
    public  WebElement idPaidCheckBox;

    @FindBy (id = "btnSubmit")
    public WebElement submitButton;

}
