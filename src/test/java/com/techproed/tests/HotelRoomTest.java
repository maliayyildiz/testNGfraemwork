package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelRoomTest extends TestBase {
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
    }
    @Ignore
    @Test
    public void positiveLoginTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement addUserButton  = driver.findElement(By.xpath("//span[@class='hidden-480']"));
        Assert.assertTrue(addUserButton.isDisplayed());
    }
    @Test
    public void createHotelRoom() throws InterruptedException {
        clickOnLogin();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ht = driver.findElement(By.linkText("Hotel Management"));
        ht.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();

        driver.findElement(By.xpath("//span[@class='hidden-480']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement idHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotel);
        select.selectByVisibleText("Star");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("Code")).sendKeys("0033");
        driver.findElement(By.id("Name")).sendKeys("Paris Palace");
        driver.findElement(By.id("Location")).sendKeys("Paris");
        driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("Best place in Paris");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement priceWithNumber = driver.findElement(By.xpath("//li[@data-id='700']"));
        WebElement priceBox = driver.findElement(By.id("Price"));
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        actions.dragAndDrop(priceWithNumber, priceBox);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        priceBox.sendKeys("700");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomType);
        select1.selectByVisibleText("King");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("0");
        driver.findElement(By.id("IsAvailable")).click();
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement succesMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        String succesMessageText = succesMessage.getText();
        Assert.assertEquals(succesMessageText, "HotelRoom was inserted successfully", "It did not match!");
        WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();
    }
        @Test
        public void verifyHotelRoomCreation() throws InterruptedException {

            clickOnLogin();
            driver.findElement(By.id("UserName")).sendKeys("manager2");
            driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
            driver.findElement(By.id("btnSubmit")).click();

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Hotel Management")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.partialLinkText("Hotel Rooms")).click();
            driver.findElement(By.xpath("//input[@name='IDHotelRoom']")).sendKeys("254");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.xpath("(//button)[6]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement verifyCreatedRoom = driver.findElement(By.xpath("//td[@class='sorting_1']"));
            String createdRoomText = verifyCreatedRoom.getText();
            System.out.println(createdRoomText);
            Assert.assertEquals(createdRoomText, "Star", "It did not match!");
        }

}
