package org.dataP;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String hoja) {
        try {
            workbook = new XSSFWorkbook("excel/data.xlsx");
            sheet = workbook.getSheet(hoja);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            System.out.println();
            e.getLocalizedMessage();
            e.getCause();
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getColCount() {
        int colCount = 0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        } catch (Exception e) {
            System.out.println();
            e.getLocalizedMessage();
            e.getCause();
            e.printStackTrace();
        }
        return colCount;
    }

    public static String getCellDataString(int rowNum, int colNum) {
        String cellData = "";
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception e) {
            System.out.println();
            e.getLocalizedMessage();
            e.getCause();
            e.printStackTrace();
        }
        return cellData;
    }

    public static double getCellDataNumeric(int rowNum, int colNum) {
        double cellData = 0;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
        } catch (Exception e) {
            System.out.println();
            e.getLocalizedMessage();
            e.getCause();
            e.printStackTrace();
        }
        return cellData;
    }
}