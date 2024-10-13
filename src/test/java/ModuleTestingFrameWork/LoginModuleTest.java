package ModuleTestingFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginModuleTest {

    public WebDriver driver;

    // Function to launch the application
    public void launchApplication() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    // Function to login with valid credentials
    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginBtn"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    // Function to verify login success
    public boolean verifyLoginSuccess() {
        WebElement dashboardElement = driver.findElement(By.id("dashboard"));
        return dashboardElement.isDisplayed();
    }

    // Function to close the application
    public void closeApplication() {
        driver.quit();
    }
}
