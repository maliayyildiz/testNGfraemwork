package com.techproed.DTseleniumpractice.day05;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCase02  extends TestBase {
    @Test
    public void testCase02(){
//        1.Go to ”https://www.mediawiki.org/wiki/Download”
        driver.get("https://www.mediawiki.org/wiki/Download");
//        2.Click Download MediaWiki 1.34.2
        driver.findElement(By.linkText("Download MediaWiki 1.34.4")).click();
//        3.Verify the file is downloaded
        String filePath = "/Users/mehmetali/Downloads/mediawiki-1.34.4.tar.gz";

        boolean isDowlanded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDowlanded);
    }
}
