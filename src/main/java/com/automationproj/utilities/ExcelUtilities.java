
package com.automationproj.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

    private static final String EXCEL_PATH = 
        "C:\\Users\\user\\OneDrive\\Desktop\\CGI Automation Testing\\Eclipse\\Automationproject\\src\\test\\resources\\Test Data\\TestDataProducts.xlsx";

    public static String getCellValue(String sheetName, int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String value = sheet.getRow(row).getCell(col).getStringCellValue();
        wb.close();
        fis.close();
        return value;
    }
}
