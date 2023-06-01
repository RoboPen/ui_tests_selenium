package com.automationexercise.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Objects;

public class ExcelReader {
    private static XSSFWorkbook readExcelFile(String fileName) {

        try {
            return new XSSFWorkbook(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Object[][] getData(String fileName, String sheetName) {

        XSSFSheet sheet;
        XSSFRow singleRow;

        sheet = Objects.requireNonNull(readExcelFile(fileName)).getSheet(sheetName);

        singleRow = sheet.getRow(0);

        Object[][] testData = new Object[sheet.getLastRowNum()][singleRow.getLastCellNum()];

        for (int rowCount = 1; rowCount <= sheet.getLastRowNum(); rowCount++) {

            singleRow = sheet.getRow(rowCount);

            for (int cell = 0; cell < singleRow.getLastCellNum(); cell++) {
                testData[rowCount - 1][cell] = singleRow.getCell(cell)
                        .toString();
            }

        }
        return testData;
    }
}
