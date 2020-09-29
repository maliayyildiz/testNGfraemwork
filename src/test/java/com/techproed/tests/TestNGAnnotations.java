package com.techproed.tests;

import org.testng.annotations.*;

public class TestNGAnnotations {
//    1. create a method: setUp using @BeforeMethod annotation and print "This is BeforeMethod"
//            2. Create a method: tearDown using @AfterMethod annotation and print "This is @AfterMethod"
//            3. Create 3 TEST METHODS: test1,test2,test3,test4 and print "Test1", "Test2", "Test3","Test4" respectively
//4. Skip test2
//5. print the test in this order: Test3, Test4, Test1




    @BeforeMethod
   public void setUp(){
        System.out.println("This is BeforeMethod");
   }

    @Test(priority = 3)
    public void test1(){
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test(priority = 1)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 2)
    public void test4(){
        System.out.println("test4");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("his is @AfterMethod");
    }

    @Test
    public void testAll(){
        test3();
        test4();
        test1();
    }
}
