package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {
    @Test
    public void logIn(){
        System.out.println("Log in TEST");
    }
    @Test
    public void homePage(){
        System.out.println("this is homepage");
       // Assert.assertEquals(3,4 );
    }
    @Test(dependsOnMethods = "homePage")
    public void searchTest(){
        System.out.println("Search Test");
    }
    @Test
    public void verifyTheResult(){
        System.out.println("Result Test");
    }
}
