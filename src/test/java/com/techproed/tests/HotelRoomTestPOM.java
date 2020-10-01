package com.techproed.tests;

import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.KoalaDefaultPage;
import com.techproed.pages.KoalaPalaceLoginPage;
import com.techproed.pages.KoalaPalaceMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;
import org.testng.annotations.Test;


public class HotelRoomTestPOM extends TestBase {
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
    @Test
    public void hotelRoomTest() throws InterruptedException {
        koalaLoginTest();
        KoalaDefaultPage koalaDefaultPage = new KoalaDefaultPage(driver);
        koalaDefaultPage.hotelManagement.click();
        koalaDefaultPage.hotelRooms.click();

        HotelRoomsPage hotelRoomsPage = new HotelRoomsPage(driver);
        hotelRoomsPage.addHotelRoomsButton.click();
        Select idHotels = new Select(hotelRoomsPage.idHotel);
        idHotels.selectByVisibleText(ConfigReader.getProperty("hotel_name_test"));
        hotelRoomsPage.hotelCode.sendKeys(ConfigReader.getProperty("code_test"));
        hotelRoomsPage.hotelName.sendKeys(ConfigReader.getProperty("name_test"));
        hotelRoomsPage.location.sendKeys(ConfigReader.getProperty("location_test"));
        hotelRoomsPage.note.sendKeys(ConfigReader.getProperty("note_test"));
        hotelRoomsPage.price.sendKeys(ConfigReader.getProperty("price_test"));
        Thread.sleep(5000);
        Select roomTypes = new Select(hotelRoomsPage.roomType);
        roomTypes.selectByVisibleText(ConfigReader.getProperty("room_type_test"));
        hotelRoomsPage.adultCount.sendKeys(ConfigReader.getProperty("adult_count"));
        hotelRoomsPage.childCount.sendKeys(ConfigReader.getProperty("child_count"));
        hotelRoomsPage.availableCheckBox.click();
        hotelRoomsPage.submitButton.click();
        //Assert that hotel room created
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.successMessage));
        String actualMessage = hotelRoomsPage.successMessage.getText();
        assertEquals(actualMessage,ConfigReader.getProperty("expected_success_message"));
    }
}
