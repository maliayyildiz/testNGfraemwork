package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables extends TestBase {
    public void logInOnApp(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainPageLoginButton = driver.findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement ht = driver.findElement(By.linkText("Hotel Management"));
        ht.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
    }
    @Test
    public void entireTable() throws InterruptedException {
        logInOnApp();
        Thread.sleep(5000);
        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        List<WebElement> tableData = driver.findElements(By.xpath("//td"));
        System.out.println(tableData.size());
//        for (WebElement eachData : tableData) {
//            System.out.println(eachData.getText());
//        }
        List<WebElement> allHeaders = driver.findElements(By.xpath("//th"));
        for (WebElement eachHeader : allHeaders) {
            System.out.println(eachHeader.getText());
        }
    }
    @Test
    public void printRows(){
        logInOnApp();
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement eachRow : allRows) {
            System.out.println(eachRow.getText());
        }
        WebElement fourthRow = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(fourthRow.getText());
    }
    @Test
    public void printCells(){
        logInOnApp();
        List<WebElement> allCells = driver.findElements(By.xpath("//tbody/td"));
        System.out.println(allCells.size());
        for (WebElement eachCell : allCells) {
            System.out.println(eachCell.getText());
        }
    }
    @Test
    public void printColumns(){
        logInOnApp();
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        System.out.println(allColumns.size());
        WebElement fifthColumn = driver.findElement(By.xpath("//tr//td[5]"));
        for (WebElement eachColumn : allColumns) {
            System.out.println(eachColumn.getText());
        }
    }
    public void printData(int row, int column){
        String xPath="//tbody//tr["+row+"]//td["+column+"]";
        WebElement data = driver.findElement(By.xpath(xPath));
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
    logInOnApp();
    printData(4,6);

    }
}
