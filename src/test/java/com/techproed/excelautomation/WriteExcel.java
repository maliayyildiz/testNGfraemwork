package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeExcel() throws Exception {
        String path = "./src/test/java/resources/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);

        Cell cell4 = row.createCell(3);
        row.createCell(3).setCellValue("");
        cell4.setCellValue("POPULATION");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);




    }
}
