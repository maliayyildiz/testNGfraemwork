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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWorkDy08 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void firstSelectedDepartmet(){
        WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownOptions = new  Select(dropDownList);
        dropdownOptions.selectByIndex(0);
        String actualFirstSelectedDepartmentText = dropdownOptions.getFirstSelectedOption().getText();
        String expectedFirstSelectedDepartmentText = "All Departments";
        Assert.assertEquals(actualFirstSelectedDepartmentText,expectedFirstSelectedDepartmentText);
    }
    @Test
    public void seventhSelectedDepartment(){
        WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownOptions = new  Select(dropDownList);
        dropdownOptions.selectByIndex(6);
        String seventhSelectedDepartment = dropdownOptions.getFirstSelectedOption().getText();
        String expectedSeventhDepartmentText = "Computers";
        Assert.assertEquals(seventhSelectedDepartment,expectedSeventhDepartmentText);
    }
    @Test
    public void allDepartmentList(){
        WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownOptions = new  Select(dropDownList);
        List<WebElement> allDepartmentsList = dropdownOptions.getOptions();
        for (WebElement lists : allDepartmentsList){
            System.out.println(lists.getText());
        }
    }
    @Test
    public void sizeOfTheList(){
        WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownOptions = new  Select(dropDownList);
        List<WebElement> allDepartmentsList = dropdownOptions.getOptions();
        System.out.println(allDepartmentsList.size());
    }
    @Test
    public void existDepartment() {
        String dropDownList = driver.findElement(By.id("searchDropdownBox")).getText();
        System.out.println(dropDownList.contains("Appliance"));
    }
    @Test
    public void naturalOrderTest(){
        WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));
        Select dropdownOptions = new Select(dropDownList);
        List<String> departmentsList = new ArrayList<String>();
        for (WebElement e : dropdownOptions.getOptions()) {
             departmentsList.add(e.getText());
        }
        List<String> naturalOrderList = departmentsList;
        Collections.sort(naturalOrderList);
        Assert.assertEquals(departmentsList,naturalOrderList);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
