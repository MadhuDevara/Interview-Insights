package HybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {

    ChromeDriver driver = new ChromeDriver();
    @BeforeClass
    public void setUp() {

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login"); // Demo login page URL
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        // Locate the username, password fields, and login button
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Assert a successful or failed login message (update based on your requirement)
        boolean loginSuccess = driver.findElement(By.id("flash")).getText().contains("Your password is invalid!");
        Assert.assertTrue(loginSuccess, "Login did not display expected result!");
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException {
        String filePath = "C:\\Users\\madhu\\Desktop\\loginData.xlsx\\";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];
        DataFormatter formatter = new DataFormatter(); // To format cell values as string

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

        workbook.close();
        return data;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
