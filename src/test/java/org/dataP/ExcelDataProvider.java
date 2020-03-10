package org.dataP;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    public static Object[][] testData(String hoja){
        ExcelUtils excelUtils = new ExcelUtils(hoja);
        int rowCount = ExcelUtils.getRowCount();
        int colCount = ExcelUtils.getColCount();

        Object[][] data = new Object[rowCount-1][colCount];

        for (int i = 1; i < rowCount; i++){
            for( int x = 0; x < colCount; x++){
                String cellData = ExcelUtils.getCellDataString(i, x);
                data[i-1][x] = cellData;
            }
        }
        return data;
    }
}
