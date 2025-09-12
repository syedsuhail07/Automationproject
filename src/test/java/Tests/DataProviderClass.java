package Tests;

import org.testng.annotations.DataProvider;
import com.automationproj.utilities.Excelutilities;

public class DataProviderClass {

    @DataProvider(name = "contactUsData")
    public Object[][] getContactUsData() {
        String filePath = "C:\\Users\\CHAKRADHAR\\eclipse-workspace\\Automationproject\\src\\test\\resources\\Functional.xlsx";
        String sheetName = "ContactUs"; 

        Excelutilities excel = new Excelutilities(filePath, sheetName);
        int rows = excel.getRowCount();
        int cols = excel.getColCount();

        Object[][] data = new Object[rows - 1][cols]; 

        for (int i = 1; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = excel.getCellData(i, j);
            }
        }
        return data;
    }

    // Separate provider for subscription test
    @DataProvider(name = "subscriptionData")
    public Object[][] getSubscriptionData() {
        return new Object[][] {
            {"validsub@mail.com"},
            {"invalidsubmail.com"}
        };
    }
}
