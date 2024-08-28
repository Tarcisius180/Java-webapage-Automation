package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelDataReader {
    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";
    private static Workbook workbook;

    static {
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getTestData(String sheetName, String testCase) {
        Map<String, String> data = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet " + sheetName + " not found in the Excel file");
        }

        for (Row row : sheet) {
            if (getCellValueAsString(row.getCell(0)).equals(testCase)) {
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    String columnName = getCellValueAsString(sheet.getRow(0).getCell(i));
                    String cellValue = getCellValueAsString(row.getCell(i));
                    data.put(columnName, cellValue);
                }
                break;
            }
        }
        return data;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public static Map<String, String> getLoginData() {
        return getTestData("Login", "Login");
    }
}