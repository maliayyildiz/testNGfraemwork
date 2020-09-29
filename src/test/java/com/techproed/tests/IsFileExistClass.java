package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsFileExistClass  extends TestBase {
    @Test
    public void isExist(){
        //find path of the image
        String pathOfPic = "/Users/mehmetali/Desktop/FLOWER. IMG.jpg";
        //we ll use java to check if the file exist or not
        boolean isExist = Files.exists(Paths.get(pathOfPic));

        Assert.assertTrue(isExist);

    }
}
