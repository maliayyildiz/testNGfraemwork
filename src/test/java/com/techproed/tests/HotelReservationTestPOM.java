package com.techproed.tests;


import com.techproed.pages.*;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelReservationTestPOM {
    @Test
    public void hotelReservationTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("koala_url"));
        KoalaPalaceMainPage koalaPalaceMainPage = new KoalaPalaceMainPage(Driver.getDriver());
        koalaPalaceMainPage.mainPageLoginButton.click();

        KoalaPalaceLoginPage koalaPalaceLoginPage = new KoalaPalaceLoginPage(Driver.getDriver());
        koalaPalaceLoginPage.username.sendKeys(ConfigReader.getProperty("username"));
        koalaPalaceLoginPage.password.sendKeys(ConfigReader.getProperty("password"));
        koalaPalaceLoginPage.loginButton.click();
        Thread.sleep(5000);
        KoalaDefaultPage koalaDefaultPage = new KoalaDefaultPage(Driver.getDriver());
        koalaDefaultPage.hotelManagement.click();
        koalaDefaultPage.hotelReservation.click();

        HotelReservationPage hotelReservationPage = new HotelReservationPage(Driver.getDriver());
        hotelReservationPage.addReservationButton.click();
        Select select = new Select(hotelReservationPage.IDUserDropdown);
        select.selectByVisibleText(ConfigReader.getProperty("iduser"));
        Select select1 = new Select(hotelReservationPage.IDHotelRoomDropdown);
        select1.selectByVisibleText("idhotel");
        hotelReservationPage.price.sendKeys(ConfigReader.getProperty("price"));
        hotelReservationPage.dateStart.sendKeys(ConfigReader.getProperty("date_start"));
        hotelReservationPage.dateEnd.sendKeys(ConfigReader.getProperty("date_end"));
        hotelReservationPage.capacityOfAdult.sendKeys(ConfigReader.getProperty("adult"));
        hotelReservationPage.capacityOfChildren.sendKeys(ConfigReader.getProperty("child"));
        hotelReservationPage.contactPerson.sendKeys(ConfigReader.getProperty("contact_person"));
        hotelReservationPage.contactPhone.sendKeys(ConfigReader.getProperty("phone"));
        hotelReservationPage.contactEmail.sendKeys(ConfigReader.getProperty("contact_email"));
        hotelReservationPage.notes.sendKeys(ConfigReader.getProperty("note"));
        hotelReservationPage.approvedCheckBox.click();
        hotelReservationPage.idPaidCheckBox.click();
        hotelReservationPage.submitButton.click();
       Driver.closeDriver();
    }
}
