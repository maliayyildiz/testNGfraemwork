package com.techproed.DTseleniumpractice.day06;

import com.techproed.DTseleniumpractice.practicePages.WebTablePage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {

//    1.Go to ” https://demoqa.com/webtables”
//            2.Print Department from the headers
//3.Print the all the department name of Alden
     @Test
    public void testCase02(){
         driver.get(ConfigReader.getProperty("toolsqa_url"));
         WebTablePage webTablePage = new WebTablePage(driver);
         //System.out.println(webTablePage.headers.getText());

         System.out.println(webTablePage.departmentOnHeaders.getText());

         System.out.println(webTablePage.aldenDepartment.getText());
     }
}
