package com.techproed.tests;

import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.KoalaDefaultPage;
import com.techproed.pages.KoalaPalaceLoginPage;
import com.techproed.pages.KoalaPalaceMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HotelRoomTestPOMDrive {
   @Test
    public void hotelRoomTest() throws InterruptedException {
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
       koalaDefaultPage.hotelRooms.click();
       Thread.sleep(5000);
       HotelRoomsPage hotelRoomsPage = new HotelRoomsPage(Driver.getDriver());
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
       Thread.sleep(5000);
       WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
       wait.until(ExpectedConditions.visibilityOf(hotelRoomsPage.successMessage));
       String actualMessage = hotelRoomsPage.successMessage.getText();
       assertEquals(actualMessage,ConfigReader.getProperty("expected_success_message"));
       Driver.closeDriver();
   }
}
