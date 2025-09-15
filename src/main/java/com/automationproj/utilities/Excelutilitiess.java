package com.automationproj.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excelutilitiess {
    private Sheet sheet;
    private Workbook workbook;

    public Excelutilitiess(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            this.workbook = new XSSFWorkbook(fis);
            this.sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return (sheet != null) ? sheet.getPhysicalNumberOfRows() : 0;
    }

    public int getColCount() {
        return (sheet != null && sheet.getRow(0) != null)
                ? sheet.getRow(0).getLastCellNum()
                : 0;
    }

    public String getCellData(int rowNum, int colNum) {
        if (sheet == null || sheet.getRow(rowNum) == null) {
            return "";
        }
        Cell cell = sheet.getRow(rowNum).getCell(colNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
