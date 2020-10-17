package com.techproed.excelautomation;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws Exception {
  String path = "./src/test/java/resources/Capitals.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        Cell cell = row.getCell(0);

        System.out.println("Data in the first cell: "+cell);
        Cell cell1 = row.getCell(1);
        System.out.println("2nd cell ;" +cell1);

        Row row1 = sheet.getRow(1);
        Cell cell2 = row1.getCell(0);
        System.out.println(cell2);
        //short way
        String str = workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(str.toUpperCase());

        String str1 = workbook.getSheetAt(0).getRow(2).getCell(1).toString();
        System.out.println(str1);

        Cell str2 = sheet.getRow(2).getCell(1);
        System.out.println(str2);
       // Assert.assertEquals(str2, "Ottowa");

        int rowCount = sheet.getLastRowNum();
          System.out.println("Row Count : "+ (++rowCount));

        int numberOfPhysicalRows = sheet.getPhysicalNumberOfRows();// index star at 1
          System.out.println("number cell that is used: " +numberOfPhysicalRows);

          Map<String, String> capitals = new HashMap<>();
          int countryColumn=0;
          int capitalColumn=1;
          for (int rowNumber =1; rowNumber<rowCount; rowNumber++){
                String country = sheet.getRow(rowNumber).getCell(countryColumn).toString();
              //  System.out.println(country);
                String capital = sheet.getRow(rowNumber).getCell(capitalColumn).toString();
               // System.out.println(capital);

                capitals.put(country,capital);
          }
          System.out.println(capitals);
          fileInputStream.close();
          workbook.close();
    }
}
