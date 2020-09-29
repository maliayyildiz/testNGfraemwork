package com.techproed.DTseleniumpractice.TestAPI;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class FirstAPITest {
//    Verify sorting hat
//1.Send a get request to /sortingHat. Request includes :
//            2.Verify status code 200,
//            3.Verify the content type is application/json; charset=utf-8
//            4. Verify that response body contains one of the following houses:
//            "Gryﬃndor", "Ravenclaw", "Slytherin", "Huﬄepuﬀ"
    String URI = "https://www.potterapi.com/v1/";

    @Test
    public void sortingHat(){
        Response response = given().get(URI+"sortingHat");
        System.out.println(response.prettyPrint());

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json; charset=utf-8" );

        List<String> allHouse = Arrays.asList("\"Gryﬃndor\"", "\"Ravenclaw\"","\"Slytherin\"", "\"Huﬄepuﬀ\"");

        assertTrue(allHouse.contains(response.body().asString()));
    }
    @Test
    public void sortingHat1(){
        
    }
}
