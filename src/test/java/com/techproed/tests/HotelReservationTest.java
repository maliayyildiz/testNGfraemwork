package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class   HotelReservationTest extends TestBase {
    //Create a clickOnLogin method
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }
    @Test
    public void hotelRoomReservation() throws InterruptedException {
        clickOnLogin();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
//Click on Hotel Management
        driver.findElement(By.linkText("Hotel Management")).click();
//Click on Room reservations
        driver.findElement(By.partialLinkText("Room reservations")).click();
// Click on Add Room Reservation
       driver.findElement(By.xpath("//span[@class='hidden-480']")).click();
//Enter All required fields
        WebElement SelectIdUserBox = driver.findElement(By.id("IDUser"));
        Select select = new Select(SelectIdUserBox);
        select.selectByVisibleText("manager2");
        WebElement SelectHotelRoomBox = driver.findElement(By.id("IDHotelRoom"));
        Select select1 = new Select(SelectHotelRoomBox);
        select1.selectByVisibleText("team3");
        driver.findElement(By.id("Price")).sendKeys("700");
        driver.findElement(By.id("DateStart")).sendKeys("10/24/2020");
        driver.findElement(By.id("DateEnd")).sendKeys("10/30/2020");
        driver.findElement(By.id("AdultAmount")).sendKeys("2");
        driver.findElement(By.id("ChildrenAmount")).sendKeys("0");
        driver.findElement(By.id("ContactNameSurname")).sendKeys("Bug Fighters");
        driver.findElement(By.id("ContactPhone")).sendKeys("0123456789");
        driver.findElement(By.id("ContactEmail")).sendKeys("bug@fighters.com");
        driver.findElement(By.id("Notes")).sendKeys("Test");
        driver.findElement(By.id("Approved")).click();
        driver.findElement(By.id("IsPaid")).click();
        driver.findElement(By.id("btnSubmit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        String successMessage = driver.findElement(By.xpath("//div[@class='bootbox-body']")).getText();
        Assert.assertEquals(successMessage,"RoomReservation was inserted successfully", "It did not match!");
        driver.findElement(By.xpath("(//button)[10]")).click();
    }
}
