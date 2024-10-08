import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class BrowserModule {
    private WebDriver driver;

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Set path to ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

class LoginModule {
    private WebDriver driver;

    public LoginModule(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username); // Replace with actual locator
        driver.findElement(By.id("password")).sendKeys(password); // Replace with actual locator
        driver.findElement(By.id("loginButton")).click(); // Replace with actual locator
    }

    public String getLoggedInUserName() {
        // This method should return the logged-in user's name or any element to validate successful login
        WebElement userNameElement = driver.findElement(By.id("userProfile")); // Replace with actual locator
        return userNameElement.getText();
    }
}

public class TestRunner {
    private BrowserModule browserModule;
    private LoginModule loginModule;

    @Before
    public void setUp() {
        browserModule = new BrowserModule();
        browserModule.openBrowser();
        WebDriver driver = browserModule.getDriver();
        driver.get("http://example.com/login"); // Replace with actual URL
        loginModule = new LoginModule(driver);
    }

    @Test
    public void testLogin() {
        // Replace with actual credentials
        String username = "testuser";
        String password = "password";

        // Perform login
        loginModule.login(username, password);

        // Assert that the login was successful
        String loggedInUserName = loginModule.getLoggedInUserName();
        Assert.assertEquals("Expected User Name", loggedInUserName); // Replace with expected user name
    }

    @After
    public void tearDown() {
        // Close the browser after the test
        browserModule.closeBrowser();
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("TestRunner");
    }
}
