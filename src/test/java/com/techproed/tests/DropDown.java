package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test
    public void selectByIndex() throws InterruptedException {
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Thread.sleep(5000);
        Select options = new Select(option1);
        Thread.sleep(5000);
        options.selectByIndex(1);
        Thread.sleep(5000);
        options.selectByValue("2");
    }

    @Test
    public void selectByValue() throws InterruptedException {
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Thread.sleep(5000);
        Select options = new Select(option1);
        Thread.sleep(5000);
        options.selectByValue("2");
       
    }
    @Test
    public void selectByVisibleText() throws InterruptedException {
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Thread.sleep(5000);
        Select options = new Select(option1);
        Thread.sleep(5000);
        options.selectByVisibleText("Option 1");
    }
    @Test
    public void printAllValues() throws InterruptedException {
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Thread.sleep(5000);
        Select options = new Select(option1);
        List<WebElement> alloptions = options.getOptions();
        for (WebElement option:alloptions){
            System.out.println(option.getText());
        }
    }
    @Test
    public void dropdownSize() throws InterruptedException {
        WebElement option1 = driver.findElement(By.id("dropdown"));
        Thread.sleep(5000);
        Select options = new Select(option1);
        int actualSizeOfDropdown = options.getOptions().size();
        Assert.assertEquals(actualSizeOfDropdown,3,"Expected not equal to actual");
    }
    @AfterMethod
    public void tersDown(){
        driver.close();
    }
}

