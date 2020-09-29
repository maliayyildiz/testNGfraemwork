package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }
    @Test
    public void hardAssertTest(){
        WebElement gmailText = driver.findElement(By.linkText("Gmail"));
        Assert.assertTrue(gmailText.isDisplayed());

        WebElement imagesText = driver.findElement(By.linkText("Images"));
        Assert.assertTrue(imagesText.isDisplayed());

        WebElement connexionButton = driver.findElement(By.linkText("Connexion"));
        Assert.assertTrue(connexionButton.isDisplayed());
    }
    @Test
    public void sofAssertTest(){
        SoftAssert softAssert = new SoftAssert();

        WebElement gmailText = driver.findElement(By.linkText("Gmail"));
        String expectedGmailText = "gmail";
        String actualGmailText = gmailText.getText();
        softAssert.assertEquals(actualGmailText,expectedGmailText);

        WebElement imagesText = driver.findElement(By.linkText("Images"));
        String expectedImagesText = "images";
        String actualImagesText = imagesText.getText();
        softAssert.assertEquals(actualImagesText,expectedImagesText);

        WebElement connexionButton = driver.findElement(By.linkText("Connexion"));
        String expectedSignInText = "Connexion";
        String actualSignInText = connexionButton.getText();
        softAssert.assertEquals(actualSignInText,expectedSignInText);

        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
