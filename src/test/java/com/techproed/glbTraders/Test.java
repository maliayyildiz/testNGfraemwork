package com.techproed.glbTraders;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test extends TestBase {
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
        driver.get("https://www.glbtrader.com/index.html");
        Thread.sleep(5000);
       driver.findElement(By.xpath("//*[text()=' Seller Join Now']")).click();
       Thread.sleep(5000);
       String title = driver.getTitle();
       Assert.assertEquals(title,"Vender Register");
//       WebElement menu = driver.findElement(By.xpath("(//span[@class='icon_widh'])[4]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(menu).click().perform();
//        Thread.sleep(5000);
//        WebElement wallet = driver.findElement(By.linkText("Wallet Cases"));
//        Assert.assertTrue(wallet.isDisplayed());
    }

}
